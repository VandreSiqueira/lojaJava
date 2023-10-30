package br.edu.ifpb.pi.model;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private int senha;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String endereco, String email, int senha) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha
				+ "\n";
	}
	
}
