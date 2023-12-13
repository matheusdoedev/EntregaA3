module.exports = class SellDto {
  constructor(id, consumerId, productId, quantity) {
    this.id = id;
    this.consumerId = consumerId;
    this.productId = productId;
    this.quantity = quantity;
  }
};
