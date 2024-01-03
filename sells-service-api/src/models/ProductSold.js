const { v4: uuidv4 } = require("uuid");

module.exports = class ProductSold {
  constructor(productInStockId, sellId) {
    this.id = uuidv4();
    this.productInStockId = productInStockId;
    this.sellId = sellId;
  }
};
