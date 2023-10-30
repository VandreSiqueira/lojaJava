package br.edu.ifpb.pi.view;

import java.sql.SQLException;
import java.util.Scanner;

import br.edu.ifpb.pi.controller.ClienteDAO;
import br.edu.ifpb.pi.controller.ProdutoDAO;
import br.edu.ifpb.pi.model.Cliente;
import br.edu.ifpb.pi.model.ConexaoBD;
import br.edu.ifpb.pi.model.Produto;

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
        ConexaoBD.getConnection();
        menu();
    }

    public static void menu() throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.println("\n========== Menu ==========");
        System.out.println("[1] Cliente" + "\n[2] Produtos" + "\n[3] Pedido" + "\n[4] Sair");
        System.out.println("==========================");
        System.out.print("\nEscolha uma opção: ");
        
        int op = in.nextInt();

        switch (op) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuProduto();
                break;
            case 3:
                menuPedido();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.print("Opção inválida!");
                menu();
                break;
        }

        in.close();
    }

    private static void menuProduto() throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.println("\n========== PRODUTOS ==========");
        System.out.println("[1] Cadastrar Produto" + "\n[2] Listar Produtos" + "\n[3] Atualizar produto" + "\n[4] Deletar produto" + "\n[5] Voltar" + "\n[6] Sair");
        System.out.println("==============================");
        System.out.print("\nEscolha uma opção: ");
        
        int op = in.nextInt();

        switch (op) {
            case 1:
                createProduto();
                break;
            case 2:
                readProduto();
                break;
            case 3:
                updateProduto();
            case 4:
                deleteProduto();
                break;
            case 5:
                menu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opção inválida!");
                menu();
                break;
        }
        in.close();
    }

    private static void menuPedido() throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.println("\n========== PEDIDOS ==========");
        System.out.println("[1] Gerar pedido" + "\n[2] Listar Pedidos" + "\n[3] Atualizar pedido" + "\n[4] Deletar pedido" + "\n[5] Voltar" + "\n[6] Sair");
        System.out.println("=============================");
        System.out.print("\nEscolha uma opção: ");
        
        int op = in.nextInt();

        switch (op) {
            case 1:
                //createPedido();
                break;
            case 2:
                //readPedido();
                break;
            case 3:
                //updatePedido();
            case 4:
                //deletePedido();
                break;
            case 5:
                menu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opcao invalida!");
                menu();
                break;
        }
        in.close();

    }

    public static void menuCliente() throws SQLException {
        Scanner in = new Scanner(System.in);

        System.out.println("\n========== CLIENTES ==========");
        System.out.println("[1] Cadastrar cliente" + "\n[2] Listar Clientes" + "\n[3] Atualizar" + "\n[4] Deletar cadastro" + "\n[5] Voltar" + "\n[6] Sair");
        System.out.println("==============================");
        System.out.print("\nEscolha uma opção: ");
        
        int op = in.nextInt();

        switch (op) {
            case 1:
                createCliente();
                break;
            case 2:
                readCliente();
                break;
            case 3:
                updateCliente();
                break;
            case 4:
                deleteCliente();
                break;
            case 5:
                menu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opcao invalida!");
                menu();
                break;
        }
        in.close();
    }

    private static void createProduto() throws SQLException {
        Scanner in = new Scanner(System.in);
        Produto produto = new Produto();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        System.out.println("========== Cadastro de Produto ==========");
        System.out.println("Insira o nome do item:");
        produto.setNomeProduto(in.nextLine());
        System.out.println("Insira o valor do item:");
        produto.setPreco(in.nextDouble());
        System.out.println("Insira estoque do item:");
        produto.setQnt(in.nextInt());

        produtoDAO.create(new Produto(produto.getNomeProduto(), produto.getPreco(), produto.getQnt()));
        menuProduto();
        in.close();
        System.out.println("=========================================");
        menuProduto();
    }

    private static void readProduto() throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.read();
        menuProduto();
    }

    private static void deleteProduto() throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Insira o ID do Produto: ");
        int produto_id = in.nextInt();
        in.close();
        produtoDAO.delete(produto_id);
        menuProduto();
    }

    private static void updateProduto() throws SQLException {
        //menuProduct();
    	menuProduto();
    }

    public static void createCliente() throws SQLException {
        try (Scanner in = new Scanner(System.in)) {
            Cliente cliente = new Cliente();
            ClienteDAO clienteDAO = new ClienteDAO();

            System.out.print("Nome:");
            cliente.setNome(in.nextLine());
            System.out.print("Endereco:");
            cliente.setEndereco(in.nextLine());
            System.out.print("Email:");
            cliente.setEmail(in.next());
            System.out.print("Senha de acesso:");
            cliente.setSenha(in.nextInt());
            clienteDAO.create(cliente);
            menuCliente();
            in.close();
            menuCliente();
        }
    }

    public static void readCliente() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.read();
        menuCliente();
    }

    private static void updateCliente() throws SQLException {
        try (Scanner in = new Scanner(System.in)) {
            Cliente cliente = new Cliente();
            ClienteDAO clienteDAO = new ClienteDAO();
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Qual o ID do cliente que você deseja atualizar?");
            
            int cliente_id = scan.nextInt();
            System.out.print("Nome:");
            cliente.setNome(in.nextLine());
            System.out.print("Endereco:");
            cliente.setEndereco(in.nextLine());
            System.out.print("Email:");
            cliente.setEmail(in.next());
            System.out.print("Senha de acesso:");
            cliente.setSenha(in.nextInt());

            clienteDAO.update(cliente, cliente_id);
            
            menuCliente();
        }
    }

    private static void deleteCliente() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        System.out.print("Insira o ID do Cliente: ");
        Scanner in = new Scanner(System.in);
        int cliente_id = in.nextInt();
        in.close();
        clienteDAO.delete(cliente_id);
        menuCliente();
    }

}
