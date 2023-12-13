module.exports = class DontHaveEnoughProductsError extends Error {
  constructor() {
    super("Não há produtos no estoque disponíveis para concluir a venda.");
  }
};
