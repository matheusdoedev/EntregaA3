const db = require("./config");

const initDatabase = () => {
  db.query(
    `
		  CREATE DATABASE IF NOT EXISTS mysql;
	  `,
    (error, result) => {
      if (error) throw error;
      console.log("Database created.");
    }
  );

  db.query(
    `
		  CREATE TABLE IF NOT EXISTS mysql.sells (
			  id varchar(40) PRIMARY KEY NOT NULL,
			  customerId varchar(40) NOT NULL,
			  productId varchar(40) NOT NULL,
			  quantity int NOT NULL
		  );
	  `,
    (error, result) => {
      if (error) throw error;
      console.log("Sells table created.");
    }
  );

  db.query(
    `
		  CREATE TABLE IF NOT EXISTS mysql.products_sold(
			  id varchar(40) PRIMARY KEY NOT NULL,
			  productInStockId varchar(40) NOT NULL,
			  sellId varchar(40) NOT NULL REFERENCES mysql.sells(id) ON DELETE CASCADE
		  );
	  `,
    (error, result) => {
      if (error) throw error;
      console.log("ProductSolds table created.");
      process.exit();
    }
  );
};

initDatabase();
