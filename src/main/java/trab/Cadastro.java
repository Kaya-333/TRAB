package trab;

public class Cadastro {
	private int id;
	private String email;
	private String nome;
	private String senha;

	public Cadastro(int id, String email, String nome, String senha) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
