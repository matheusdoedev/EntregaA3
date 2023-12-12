import dotenv from "dotenv";

import { httpProvider } from "../providers/httpProvider.js";

dotenv.config();

const customersAPI = httpProvider(process.env.CUSTOMERS_SERVICE_API_URL);

export const customersService = {
  createCustomer(customersDto) {
    return customersAPI.post("/customers/create", customersDto);
  },

  updateCustomer(customerId, customersDto) {
    return customersAPI.put(`/customers/update/${customerId}`, customersDto);
  },

  getCustomer(customerId) {
    return customersAPI.get(`/customers/${customerId}`);
  },

  listCustomers() {
    return customersAPI.get("/customers");
  },

  deleteCustomer(customerId) {
    return customersAPI.delete(`/customers/delete/${customerId}`);
  },
};
