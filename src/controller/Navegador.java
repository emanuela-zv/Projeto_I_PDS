package controller;

import javax.swing.JPanel;

import view.Login;
import view.TelaPrincipal;

public class Navegador {

	// this.Login = login
	
	private Login login;
	private TelaPrincipal telaPrincipal;
	
	
	public Navegador(Login login, TelaPrincipal telaPrincipal) {
		super();
		this.login = login;
		this.telaPrincipal = telaPrincipal;
	}


	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal.adicionarTela(nome, tela);
	}
	
	public void navegar(String nome) {
		this.telaPrincipal.mostrarTela(nome);
	}
	
	//fazer os métodos adicionar tela e mostrar na tela principal.
	
}
