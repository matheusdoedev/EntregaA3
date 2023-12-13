module.exports = class ProductSoldDto {
  constructor(id, productInStockId, sellId) {
    this.id = id;
    this.productInStockId = productInStockId;
    this.sellId = sellId;
  }
};
