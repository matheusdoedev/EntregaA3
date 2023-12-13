const SellDto = require("../dto/SellDto");

class SellController {
	postSell(req, res) {
		const sellDto = new SellDto(req.body);

		// validar se o cliente existe

		// validar se o produto existe

		// validar se a quantidade de unidades desse produto suficientes do estoque para realizar a venda
			// se sim, cria a venda no banco, relaciona os produtos que estão no stock que vão ser vendidos com a venda, e atualiza o status dos produtos no stock vendidos
			// se não, dispara uma exceção informando que não há produtos suficientes no estoque para realizar a venda
	}
}

module.exports = SellController;