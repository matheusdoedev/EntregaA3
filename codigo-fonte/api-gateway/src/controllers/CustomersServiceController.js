import { customersService } from "../services/customersService.js";

export default class CustomersServiceController {
  static async postCreateCustomer(req, res) {
    try {
      const response = await customersService.createCustomer(req.body);

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async putUpdateCustomer(req, res) {
    try {
      const response = await customersService.updateCustomer(
        req.params.customerId,
        req.body
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getCustomer(req, res) {
    try {
      const response = await customersService.getCustomer(
        req.params.customerID
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async getCustomers(req, res) {
    try {
      const response = await customersService.listCustomers();

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }

  static async deleteCustomers(req, res) {
    try {
      const response = await customersService.deleteCustomer(
        req.params.customerId
      );

      return res.status(response.status).json(response.data);
    } catch (error) {
      return res.status(error.response.status).json(error.response.data);
    }
  }
}
