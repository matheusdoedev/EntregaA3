const axios = require("axios");

const httpProvider = (baseURL) => {
  return axios.create({
    baseURL,
  });
};

module.exports = httpProvider;
