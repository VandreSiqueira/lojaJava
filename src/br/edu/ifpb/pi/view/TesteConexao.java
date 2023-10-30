package br.edu.ifpb.pi.view;

import java.sql.SQLException;
import java.util.Scanner;

import br.edu.ifpb.pi.controller.ClienteDAO;
import br.edu.ifpb.pi.model.Cliente;
import br.edu.ifpb.pi.model.ConexaoBD;

public class TesteConexao {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ConexaoBD.testarConexao();
		menu();
	}
	
	public static void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("====== Menu ========");
		System.out.println("1 - Cliente");
		System.out.println("2 - Produtos");
		System.out.println("3 - Pedido");
		System.out.println("4 - Sair");
		System.out.println("====================");
		
		System.out.println("Escolha uma opção do menu: ");
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1: {
			menuCliente();
			break;
		}
		case 2: {
			menuProduto();
			break;
		}
		case 3: {
			menuPedido();
			break;
		}
		case 4: {
			System.exit(0);
		}
		default:
			System.out.println("Opção inválida");
			menu();
			break;
		}
	}

	public static void menuCliente() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("======== Menu Cliente ==========");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar Clientes");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar Cadastro");
		System.out.println("5 - Voltar");
		System.out.println("6 - Sair");
		System.out.println("================================");
		
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1: {
			createCliente();
			break;
		}
		case 2: {
			readCliente();
			break;
		}
		case 3: {
			updateCliente();
			break;
		}
		case 4: {
			deleteCliente();
			break;
		}
		case 5: {
			menu();
			break;
		}
		case 6: {
			System.exit(0);
		}
		default:
			System.out.println("Opção inválida");
			menu();
			break;
		}
		
	}
	
	public static void createCliente() {
		try {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Nome: ");
		cliente.setNome(in.nextLine());
		System.out.println("Endereço: ");
		cliente.setEndereco(in.nextLine());
		System.out.println("Email: ");
		cliente.setEmail(in.next());
		System.out.println("Senha de acesso: ");
		cliente.setSenha(in.nextInt());
		clienteDAO.create(cliente);	
		in.close();
		menuCliente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
