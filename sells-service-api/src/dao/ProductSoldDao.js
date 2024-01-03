const db = require("../database/config");

class ProductSoldDAO {
  static create(productSold) {
    return new Promise((resolve, reject) => {
      db.query(
        `INSERT INTO mysql.products_sold (id, productInStockId, sellId) VALUES ("${productSold.id}", "${productSold.productInStockId}", "${productSold.sellId}")`,
        (error, result) => {
          if (error) {
            console.error(error);
          }
          resolve(result);
        }
      );
    });
  }
}

module.exports = ProductSoldDAO;
