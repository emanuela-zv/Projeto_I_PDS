package model;

public class Usuarios {
	
	private String cpf;
	private String nome;
	private String usuario;
	private boolean adm;
	
	public Usuarios(String cpf, String nome, String usuario, boolean adm) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.usuario = usuario;
		this.adm = adm;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
