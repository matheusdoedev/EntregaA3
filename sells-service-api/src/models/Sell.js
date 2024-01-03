const { v4: uuidv4 } = require("uuid");

module.exports = class Sell {
  constructor(customerId, productId, quantity) {
    this.id = uuidv4();
    this.customerId = customerId;
    this.productId = productId;
    this.quantity = quantity;
  }
};
