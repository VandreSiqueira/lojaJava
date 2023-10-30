package br.edu.ifpb.pi.model;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private Cliente cliente;
	ArrayList<Pedido> pedido = new ArrayList<>();
	private Produto produto;
	private int qnt;
	
	public Pedido() {
		super();
	}
	
	public Pedido(Cliente cliente, Produto produto, int qnt) {
		this.cliente = cliente;
		this.produto = produto;
		this.qnt = qnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(ArrayList<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	@Override
	public String toString() {
		return "Pedido id=" + id + ", cliente=" + cliente + ", pedido=" + pedido + ", produto =" + produto + ", qnt=" + qnt + "\n";
	}
	
}
