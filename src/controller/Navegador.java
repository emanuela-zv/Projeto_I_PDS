package controller;

import javax.swing.JPanel;

import view.CadastroInsumos;
import view.CadastroProdutos;
import view.CadastroUsuario;
import view.Login;
import view.TelaPrincipal;

public class Navegador {

	// this.Login = login
	
	private Login login;
	private CadastroUsuario cadastroUsuario;
	private TelaPrincipal telaPrincipal;
	private CadastroProdutos cadastroProdutos;
	private CadastroInsumos cadastroInsumos;
	
	public Navegador(Login login, TelaPrincipal telaPrincipal, CadastroUsuario cadastroUsuario,
			CadastroProdutos cadastroProdutos, CadastroInsumos cadastroInsumos) {
		super();
		this.login = login;
		this.telaPrincipal = telaPrincipal;
		this.cadastroUsuario = cadastroUsuario;
		this.cadastroProdutos = cadastroProdutos;
		this.cadastroInsumos = cadastroInsumos;
		
	}


	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal.adicionarTela(nome, tela);
	}
	
	public void navegar(String nome) {
		this.telaPrincipal.mostrarTela(nome);
	}
	
	//fazer os métodos adicionar tela e mostrar na tela principal.
	
}
