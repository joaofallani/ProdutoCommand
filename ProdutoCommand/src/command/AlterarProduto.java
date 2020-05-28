package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class AlterarProduto implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeProduto = request.getParameter("nome");
		String descProduto = request.getParameter("descricao");
		int idProduto = Integer.parseInt(request.getParameter("id"));
		double valorProduto = Double.parseDouble(request.getParameter("valor"));
		int estoqueProduto = Integer.parseInt(request.getParameter("estoque"));

		Produto produto = new Produto();
		produto.setId(idProduto);
		produto.setNomeProduto(nomeProduto);
		produto.setDescricao(descProduto);
		produto.setPreco(valorProduto);
		produto.setEstoque(estoqueProduto);

		ProdutoService produtoService = new ProdutoService();

		produtoService.atualizarProduto(produto);

		request.setAttribute("mensagem", "O produto foi editado com sucesso!");

		RequestDispatcher view = request.getRequestDispatcher("homeLista.jsp");
		view.forward(request, response);
	}
}
