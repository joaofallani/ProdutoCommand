package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

import java.sql.ResultSet;

public class ProdutoDAO {
	
	private Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Produto produto) {
			
		String inserir = "INSERT INTO produto "
				+ " (codigo, nome, descricao, valor, estoque) "
				+ " VALUES (?, ?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produto.getId());
			pst.setString(2, produto.getNomeProduto());
			pst.setString(3, produto.getDescricao());
			pst.setDouble(4, produto.getPreco());
			pst.setInt(5, produto.getEstoque());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Produto produto) {
		
		String alterar = "UPDATE produto "
				+ "SET nome = ?, descricao = ?, valor = ?, estoque = ? "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getPreco());
			pst.setInt(4, produto.getEstoque());
			pst.setInt(5, produto.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Produto produto) {
		
		String excluir = "DELETE FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, produto.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
		}
	}
	
	public Produto buscar(int codigo) {
		
		String consultar = "SELECT * FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, codigo);
			ResultSet resultado = pst.executeQuery();
			
			Produto p = new Produto();
			if (resultado.next()) {
				p.setId(codigo);
				p.setDescricao(resultado.getString("descricao"));
				p.setNomeProduto(resultado.getString("nome"));
				p.setPreco(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Produto> listarProdutos() {
		
		String consultar = "SELECT * FROM produto";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Produto> lista = new ArrayList<>();
			while (resultado.next()) {
				Produto p = new Produto();
				p.setId(resultado.getInt("codigo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setNomeProduto(resultado.getString("nome"));
				p.setPreco(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
