const ProductSoldDAO = require("../dao/ProductSoldDao");
const SellDAO = require("../dao/SellDao");
const DontHaveEnoughProductsError = require("../exceptions/DontHaveEnoughProductsError");
const ProductSold = require("../models/ProductSold");
const Sell = require("../models/Sell");
const apiGatewayService = require("../services/apiGatewayService");

class SellController {
  static async postSell(req, res) {
    try {
      const { customerId, productId, quantity } = req.body;

      // check if customer exists
      await apiGatewayService.getConsumer(customerId);

      // check if product exists
      await apiGatewayService.getProduct(productId);

      const sellDto = new Sell(customerId, productId, quantity);

      // check if have enough product quantity to sell
      const { data: availableProducts } =
        await apiGatewayService.getProductsInStockAvailableToBeSold(productId);

      if (!(availableProducts instanceof Array)) {
        throw new DontHaveEnoughProductsError();
      }

      if (availableProducts.length < quantity) {
        throw new DontHaveEnoughProductsError();
      }

      await handleRegisterProductsInStockToSell(sellDto, availableProducts);

      return res.status(200).json({ message: "Venda realizada", sellDto });
    } catch (error) {
      const errorMessage =
        error?.message ??
        error?.response?.data?.message ??
        "Não foi possível realizar a venda.";

      console.error(error);
      return res.status(400).json({ message: errorMessage, error });
    }
  }

  async handleRegisterProductsInStockToSell(sellDto, availableProducts) {
    // if is, creates the sell, the relation between the products in stock with the sell, and updates products in stock to 'SELLED'
    await SellDAO.create(sellDto);

    for (let count = 0; count < quantity; count++) {
      const { id } = availableProducts[count];

      const productSoldDto = new ProductSold(id, sellDto.id);

      await ProductSoldDAO.create(productSoldDto);

      await apiGatewayService.updateProductInStock(id, {
        status: "SELLED",
      });
    }
  }
}

module.exports = SellController;
