const httpProvider = require("../providers/httpProvider");

const apiGatewayServiceAPI = httpProvider(process.env.API_GATEWAY_URL);

const apiGatewayService = {
  getConsumer(consumerId) {
    return apiGatewayServiceAPI.get(`/consumers/${consumerId}`);
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
};

module.exports = apiGatewayService;
