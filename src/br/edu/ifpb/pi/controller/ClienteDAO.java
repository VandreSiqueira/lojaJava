package br.edu.ifpb.pi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.pi.model.ConexaoBD;
import br.edu.ifpb.pi.model.Cliente;

public class ClienteDAO {
	public void create(Cliente cliente) throws SQLException {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "INSERT INTO `cliente` (nome, endereco, email, senha) VALUES (?,?,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setInt(4, cliente.getSenha());
			stmt.execute();
			
			System.out.println("Cliente cadastrado!");
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: Cliente não cadastrado!");
			e.printStackTrace();
		}
	}
	
	public void read() throws SQLException {
		try {
			ArrayList<Cliente> listaClientes = new ArrayList<>();
			Connection con = ConexaoBD.getConnection();
			String sql = "SELECT * FROM `cliente`;";
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setEndereco(rset.getString("endereco"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getInt("senha"));
			
				listaClientes.add(cliente);
			}
			
			con.close();
			System.out.println("Lista Clientes");
			System.out.println(listaClientes.toString());
		} catch (Exception e) {
			System.out.println("Erro: Não foi possível ler os clientes");
			e.printStackTrace();
		}
		
	}
	
	public void update(Cliente cliente, int cliente_id) {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "UPDATE `cliente` SET nome = ?, endereco = ?, email = ?, senha = ? WHERE id = " + cliente_id + ";";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setInt(4, cliente.getSenha());
			stmt.execute();
			
			System.out.println("Cliente atualizado!");
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: Cliente não atualizado!");
			e.printStackTrace();
		}
	}
	
	public void delete(int cliente_id) {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "DELETE FROM `cliente` WHERE id = " + cliente_id + ";";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			System.out.println("Cliente deletado!");
		} catch (Exception e) {
			System.out.println("Erro: Cliente não deletado");
			e.printStackTrace();
		}
	}
}
