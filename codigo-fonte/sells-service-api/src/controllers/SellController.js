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
      const sellDto = new Sell(customerId, productId, quantity);

      // validar se o cliente existe
      await apiGatewayService.getConsumer(customerId);

      // validar se o produto existe
      await apiGatewayService.getProduct(productId);

      // validar se a quantidade de unidades desse produto suficientes do estoque para realizar a venda
      const { data: availableProducts } =
        await apiGatewayService.getProductsInStockAvailableToBeSold(productId);

      if (!(availableProducts instanceof Array)) {
        throw new DontHaveEnoughProductsError();
      }

      if (availableProducts.length >= quantity) {
        // se sim, cria a venda no banco, relaciona os produtos que estão no stock que vão ser vendidos com a venda, e atualiza o status dos produtos no stock vendidos
        await SellDAO.create(sellDto);

        for (let count = 0; count < quantity; count++) {
          const { id } = availableProducts[count];

          const productSoldDto = new ProductSold(id, sellDto.id);

          await ProductSoldDAO.create(productSoldDto);

          await apiGatewayService.updateProductInStock(id, {
            status: "SELLED",
          });
        }

        return res.status(200).json({ message: "Venda realizada", sellDto });
      } else {
        // se não, dispara uma exceção informando que não há produtos suficientes no estoque para realizar a venda
        throw new DontHaveEnoughProductsError();
      }
    } catch (error) {
      const errorMessage =
        error?.message ??
        error?.response?.data?.message ??
        "Não foi possível realizar a venda.";

      console.error(error);
      return res.status(400).json({ message: errorMessage, error });
    }
  }
}

module.exports = SellController;
