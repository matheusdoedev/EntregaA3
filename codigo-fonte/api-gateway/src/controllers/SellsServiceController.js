import { sellsService } from "../services/sellsService.js";

export class SellsServiceController {
  static async postSell(req, res) {
    try {
      const response = await sellsService.createSell(req.body);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }
}
