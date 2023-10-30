package br.edu.ifpb.pi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	public static Connection testarConexao() throws SQLException {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "");
			System.out.println("BD - OK!");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("BD - Erro: " + "\n" + e);
		}
		return null;
	}
	
	public static Connection getConnection() throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "");
	}
}
