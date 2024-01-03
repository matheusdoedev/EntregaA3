import dotenv from "dotenv";

import { httpProvider } from "../providers/httpProvider.js";

dotenv.config();

const stockServiceAPI = httpProvider(process.env.PRODUCT_STOCK_SERVICE_API_URL);

export const stockService = {
  createProduct(productDto) {
    return stockServiceAPI.post("/products/create", productDto);
  },

  updateProduct(productId, productDto) {
    return stockServiceAPI.put(`/products/update/${productId}`, productDto);
  },

  getProduct(productId) {
    return stockServiceAPI.get(`/products/${productId}`);
  },

  listProducts() {
    return stockServiceAPI.get("/products");
  },

  deleteProduct(productId) {
    return stockServiceAPI.delete(`/products/delete/${productId}`);
  },

  createProductInStock(productInStockDto) {
    return stockServiceAPI.post("/product-in-stock/create", productInStockDto);
  },

  createProductInStockInBatch(createProductInStockInBatchDto) {
    return stockServiceAPI.post(
      "/product-in-stock/create-in-batch",
      createProductInStockInBatchDto
    );
  },

  updateProductInStock(productInStockId, productInStockDto) {
    return stockServiceAPI.put(
      `/product-in-stock/update/${productInStockId}`,
      productInStockDto
    );
  },

  getProductInStock(productInStockId) {
    return stockServiceAPI.get(`/product-in-stock/${productInStockId}`);
  },

  getProductsInStockAvailableToBeSold(productId) {
    return stockServiceAPI.get(`/product-in-stock/available/${productId}`);
  },

  listProductsInStock() {
    return stockServiceAPI.get("/product-in-stock");
  },

  deleteProductInStock(productInStockId) {
    return stockServiceAPI.delete(
      `/product-in-stock/delete/${productInStockId}`
    );
  },
};
