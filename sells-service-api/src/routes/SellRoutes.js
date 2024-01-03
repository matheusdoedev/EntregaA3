const express = require("express");
const SellController = require("../controllers/SellController");

const SellRouter = express.Router();

SellRouter.post("/sell", SellController.postSell);

module.exports = SellRouter;
