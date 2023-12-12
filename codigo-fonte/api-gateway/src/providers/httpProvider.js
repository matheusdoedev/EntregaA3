import axios from "axios";

export const httpProvider = (baseURL) =>
  axios.create({
    baseURL,
  });
