import express from "express";

import { SellsServiceController } from "../controllers/SellsServiceController.js";

const SellsServiceRouter = express.Router();

SellsServiceRouter.post("/sell", SellsServiceController.postSell);

export default SellsServiceRouter;
