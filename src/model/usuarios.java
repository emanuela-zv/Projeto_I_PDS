package model;

public class usuarios {
	
	private String nome;
	private String cpf;
	private String usuario;
	private boolean adm;
	
	
	public usuarios(String nome, String cpf, String usuario, boolean adm) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.adm = adm;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public boolean isAdm() {
		return adm;
	}


	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	
	

}
