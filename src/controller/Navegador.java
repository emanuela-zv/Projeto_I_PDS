package controller;

import javax.swing.JPanel;

import view.CadastroInsumos;
import view.CadastroProdutos;
import view.CadastroUsuario;
import view.Login;
import view.TelaPrincipal;

public class Navegador {

	private Login login;
	private TelaPrincipal telaPrincipal;

	
	public Navegador( TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		
	}


	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal.adicionarTela(nome, tela);
	}
	
	public void navegar(String nome) {
		this.telaPrincipal.mostrarTela(nome);
		this.telaPrincipal.setTitle(getTitulo(nome));
	}
	
	private String getTitulo(String nome) {
	    switch (nome) {
	    case "LOGIN":
	        return "Login";
	    case "CADASTRO_INSUMOS":
	    	return "Cadastre o produto";
	    case "CADASTRO_PRODUTOS":
	    	return "Administre os produtos";
	    case "CADASTRO_USUARIO":
	    	return "Cadastre-se";
	    case "COMPRA":
	    	return "Faça sua compra";
	    case "PRODUTOS":
	    	return "Adminstre os produtos";
	    case "CARRINHO":
	    	return "Verifique seu carrinho e conclua a compra";
	    default:
	        return "";
	    }
	}	
	
}
