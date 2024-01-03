const httpProvider = require("../providers/httpProvider");

const apiGatewayServiceAPI = httpProvider(process.env.API_GATEWAY_URL);

const apiGatewayService = {
  getConsumer(consumerId) {
    return apiGatewayServiceAPI.get(`/customers/${consumerId}`);
  },

  getProduct(productId) {
    return apiGatewayServiceAPI.get(`/products/${productId}`);
  },

  updateProductInStock(productInStockId, productInStockDto) {
    return apiGatewayServiceAPI.put(
      `/product-in-stock/update/${productInStockId}`,
      productInStockDto
    );
  },

  getProductsInStockAvailableToBeSold(productId) {
    return apiGatewayServiceAPI.get(`/product-in-stock/available/${productId}`);
  },
};

module.exports = apiGatewayService;
