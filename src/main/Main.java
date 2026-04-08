package main;

import controller.LoginController;
import controller.Navegador;
import model.UsuariosDAO;
import view.CadastroInsumos;
import view.CadastroProdutos;
import view.CadastroUsuario;
import view.Compra;
import view.Login;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();		
		CadastroInsumos cadastroInsumos = new CadastroInsumos();
		CadastroProdutos cadastroProdutos = new CadastroProdutos();
		CadastroUsuario cadastroUsuario = new CadastroUsuario();
		Compra compra = new Compra();
		Login login = new Login();
		
		Navegador navegador = new Navegador (login, telaPrincipal);
		
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		
		LoginController loginController = new LoginController(login, usuariosDAO, navegador);
		
		navegador.adicionarPainel("LOGIN", login);
		navegador.adicionarPainel("CADASTROINSUMOS", cadastroInsumos);
		navegador.adicionarPainel("CADASTROPRODUTOS", cadastroProdutos);
		navegador.adicionarPainel("COMPRA", compra);		
		
		telaPrincipal.setVisible(true);
		navegador.navegar("LOGIN");
		
	}

}
