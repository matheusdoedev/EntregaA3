const { DataTypes } = require("sequelize");

const sequelize = require("../config/database");
const Sell = require("./Sell");

const ProductSold = sequelize.define("ProductSold", {
  id: {
    type: DataTypes.UUID,
    allowNull: false,
    primaryKey: true,
  },

  productInStockId: {
    type: DataTypes.UUID,
    allowNull: false,
  },
});

ProductSold.belongsTo(Sell);

module.exports = ProductSold;
