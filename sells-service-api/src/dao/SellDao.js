const db = require("../database/config");

class SellDAO {
  static create(sell) {
    return new Promise((resolve, reject) => {
      db.query(
        `INSERT INTO mysql.sells (id, customerId, productId, quantity) VALUES ("${sell.id}", "${sell.customerId}", "${sell.productId}", "${sell.quantity}")`,
        (error, result) => {
          if (error) reject(error);
          resolve(result);
        }
      );
    });
  }
}

module.exports = SellDAO;
