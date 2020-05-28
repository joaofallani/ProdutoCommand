package model;

public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nomeProduto;
	private String descricao;
	private double preco;
	private int estoque;
	
	public Produto() {}
	
	public Produto(int id, String nomeProduto, String descricao, double preco, int estoque) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
}
