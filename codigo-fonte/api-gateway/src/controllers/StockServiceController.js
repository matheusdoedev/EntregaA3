import { stockService } from "../services/stockService.js";

export default class StockServiceController {
  // product features
  static async postCreateProduct(req, res) {
    try {
      const response = await stockService.createProduct(req.body);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async putUpdateProduct(req, res) {
    try {
      const response = await stockService.updateProduct(
        req.params.productId,
        req.body
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getProduct(req, res) {
    try {
      const response = await stockService.getProduct(req.params.productId);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getProducts(req, res) {
    try {
      const response = await stockService.listProducts();

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async deleteProduct(req, res) {
    try {
      const response = await stockService.deleteProduct(req.params.productId);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  // product in stock features
  static async postCreateProductInStock(req, res) {
    try {
      const response = await stockService.createProductInStock(req.body);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async putUpdateProductInStock(req, res) {
    try {
      const response = await stockService.updateProductInStock(
        req.params.productInStockId,
        req.body
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getProductInStock(req, res) {
    try {
      const response = await stockService.getProductInStock(
        req.params.productInStockId
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getProductsInStock(req, res) {
    try {
      const response = await stockService.listProductsInStock();

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async deleteProductInStock(req, res) {
    try {
      const response = await stockService.deleteProductInStock(
        req.params.productInStockId
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }
}
