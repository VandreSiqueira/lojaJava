package br.edu.ifpb.pi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.edu.ifpb.pi.model.Cliente;
import br.edu.ifpb.pi.model.ConexaoBD;

public class ExemploDAO {
	public void create(Cliente cliente) {
		try {
			Connection con = ConexaoBD.getConnection();
			String sql = "INSERT INTO `cliente` (nome, endereco, email, senha) VALUES (?,?,?,?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setInt(4, cliente.getSenha());
			
			System.out.println("Cliente Cadastrado com sucesso!");
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar cliente");
			e.printStackTrace();
		}
	}
}
