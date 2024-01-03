const db = require("./config");

const handleQueryCallback = (message, postAction) => (error) => {
  if (error) throw error;
  if (message) console.log(message);
  if (postAction) postAction();
};

const createTables = () => {
  db.query(
    `
		  CREATE TABLE IF NOT EXISTS mysql.sells (
			  id varchar(40) PRIMARY KEY NOT NULL,
			  customerId varchar(40) NOT NULL,
			  productId varchar(40) NOT NULL,
			  quantity int NOT NULL
		  );
	  `,
    handleQueryCallback("Sells table created.")
  );

  db.query(
    `
		  CREATE TABLE IF NOT EXISTS mysql.products_sold(
			  id varchar(40) PRIMARY KEY NOT NULL,
			  productInStockId varchar(40) NOT NULL,
			  sellId varchar(40) NOT NULL REFERENCES mysql.sells(id) ON DELETE CASCADE
		  );
	  `,
    handleQueryCallback("ProductSolds table created.", () => {
      process.exit();
    })
  );
};

const initDatabase = () => {
  db.query(
    `
		  CREATE DATABASE IF NOT EXISTS mysql;
	  `,
    handleQueryCallback("Database created.")
  );

  createTables();
};

initDatabase();
