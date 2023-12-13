import express from "express";
import cors from "cors";

import CustomersServiceRouter from "./routes/CustomersServiceRoutes.js";
import StockServiceRouter from "./routes/StockServiceRoutes.js";

const PORT = process.env.PORT || 3333;
const app = express();

app.use(cors());
app.use(express.json());

// routers
app.use(CustomersServiceRouter);
app.use(StockServiceRouter);

app.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});
