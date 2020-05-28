package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class DeletarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Produto produto = new Produto();

		int idProduto = Integer.parseInt(request.getParameter("id"));

		produto.setId(idProduto);

		ProdutoService produtoService = new ProdutoService();

		produtoService.deletarProduto(produto);

		request.setAttribute("mensagem", "O produto foi deletado com sucesso!");

		RequestDispatcher view = request.getRequestDispatcher("homeLista.jsp");
		view.forward(request, response);

	}

}
