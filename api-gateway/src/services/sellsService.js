import dotenv from "dotenv";

import { httpProvider } from "../providers/httpProvider.js";

dotenv.config();

const sellsServiceAPI = httpProvider(process.env.SELLS_SERVICE_API_URL);

export const sellsService = {
  createSell(sellDto) {
    return sellsServiceAPI.post("/sell", sellDto);
  },
};
