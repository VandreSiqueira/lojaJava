package br.edu.ifpb.pi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.pi.model.ConexaoBD;
import br.edu.ifpb.pi.model.Produto;

public class ProdutoDAO {
	public void create(Produto produto) throws SQLException {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "INSERT INTO `produto` (nome, preco, qnt) VALUES (?,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQnt());
			stmt.execute();
			
			System.out.println("Produto cadastrado!");
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: Produto não cadastrado!");
			e.printStackTrace();
		}
	}
	
	public void read() throws SQLException {
		try {
			ArrayList<Produto> listaProdutos = new ArrayList<>();
			Connection con = ConexaoBD.getConnection();
			String sql = "SELECT * FROM `produto`;";
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				Produto produto = new Produto();
				produto.setId(rset.getInt("id"));
				produto.setNomeProduto(rset.getString("nome"));
				produto.setPreco(rset.getDouble("preco"));
				produto.setQnt(rset.getInt("qnt"));
			
				listaProdutos.add(produto);
			}
			
			con.close();
			System.out.println("Lista Produtos");
			System.out.println(listaProdutos.toString());
		} catch (Exception e) {
			System.out.println("Erro: Não foi possível ler os produtos");
			e.printStackTrace();
		}
	}
	
	public void update(Produto produto) {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "UPDATE * FROM `produto` SET nome = ?, preco = ?, qnt = ? WHERE id = " + produto.getId() + ";";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQnt());
			stmt.execute();
			
			System.out.println("Produto atualizado!");
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: Produto não atualizado!");
			e.printStackTrace();
		}
	}
	
	public void delete(int produto_id) {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "DELETE FROM `produto` WHERE id = " + produto_id + ";";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			System.out.println("Produto deletado!");
		} catch (Exception e) {
			System.out.println("Erro: Produto não deletado");
			e.printStackTrace();
		}
	}
}
