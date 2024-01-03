import express from "express";

import StockServiceController from "../controllers/StockServiceController.js";

const StockServiceRouter = express.Router();

// product routes
StockServiceRouter.post(
  "/products/create",
  StockServiceController.postCreateProduct
);

StockServiceRouter.put(
  "/products/update/:productId",
  StockServiceController.putUpdateProduct
);

StockServiceRouter.get(
  "/products/:productId",
  StockServiceController.getProduct
);

StockServiceRouter.get("/products", StockServiceController.getProducts);

StockServiceRouter.delete(
  "/products/delete/:productId",
  StockServiceController.deleteProduct
);

// product in stock routes
StockServiceRouter.post(
  "/product-in-stock/create",
  StockServiceController.postCreateProductInStock
);

StockServiceRouter.post(
  "/product-in-stock/create-in-batch",
  StockServiceController.postCreateProductInStockInBatch
);

StockServiceRouter.put(
  "/product-in-stock/update/:productInStockId",
  StockServiceController.putUpdateProductInStock
);

StockServiceRouter.get(
  "/product-in-stock/:productInStockId",
  StockServiceController.getProductInStock
);

StockServiceRouter.get(
  "/product-in-stock",
  StockServiceController.getProductsInStock
);

StockServiceRouter.get(
  "/product-in-stock/available/:productId",
  StockServiceController.getProductInStockAvailableToBeSold
);

StockServiceRouter.delete(
  "/product-in-stock/delete/:productInStockId",
  StockServiceController.deleteProductInStock
);

export default StockServiceRouter;
