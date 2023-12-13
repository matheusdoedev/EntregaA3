const { DataTypes } = require("sequelize");

const sequelize = require("../config/database");
const ProductSold = require("./ProductSold");

const Sell = sequelize.define("Sell", {
  id: {
    type: DataTypes.UUID,
    allowNull: false,
    primaryKey: true,
  },

  consumerId: {
    type: DataTypes.UUID,
    allowNull: false,
  },

  productId: {
    type: DataTypes.UUID,
    allowNull: false,
  },

  quantity: {
    type: DataTypes.FLOAT,
    allowNull: false,
  },
});

Sell.hasMany(ProductSold);

module.exports = Sell;
