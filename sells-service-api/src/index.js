const express = require("express");
const cors = require("cors");

const SellRouter = require("./routes/SellRoutes");

const PORT = process.env.PORT || 3333;
const app = express();

app.use(cors());
app.use(express.json());

// routes
app.use(SellRouter);

app.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});
