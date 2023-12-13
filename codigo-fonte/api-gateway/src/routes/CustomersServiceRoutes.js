import express from "express";

import CustomersServiceController from "../controllers/CustomersServiceController.js";

const CustomersServiceRouter = express.Router();

CustomersServiceRouter.post(
  "/customers/create",
  CustomersServiceController.postCreateCustomer
);

CustomersServiceRouter.put(
  "/customers/update/:customerId",
  CustomersServiceController.putUpdateCustomer
);

CustomersServiceRouter.get(
  "/customers/:customerId",
  CustomersServiceController.getCustomer
);

CustomersServiceRouter.get(
  "/customers",
  CustomersServiceController.getCustomers
);

CustomersServiceRouter.delete(
  "/customers/delete/:customerId",
  CustomersServiceController.deleteCustomers
);

export default CustomersServiceRouter;
