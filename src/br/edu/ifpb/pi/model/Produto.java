package br.edu.ifpb.pi.model;

public class Produto {
	private int id;
	private String nomeProduto;
	private double preco;
	private int qnt;
	
	public Produto() {
		super();
	}
	
	public Produto(String nomeProduto, double preco, int qnt) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.qnt = qnt;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	@Override
	public String toString() {
		return "Produto id=" + id + ", nome=" + nomeProduto + ", preco=" + preco + ", Quantidade=" + qnt + "\n";
	}
	
}
