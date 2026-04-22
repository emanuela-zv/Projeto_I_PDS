package main;

import controller.CadastroInsumosController;
import controller.CadastroProdutosController;
import controller.CadastroUsuarioController;
import controller.CarrinhoController;
import controller.CompraController;
import controller.LoginController;
import controller.Navegador;
import controller.ProdutosController;
import model.Insumos;
import model.InsumosDAO;
import model.UsuariosDAO;
import view.CadastroInsumos;
import view.CadastroProdutos;
import view.CadastroUsuario;
import view.Carrinho;
import view.Compra;
import view.Login;
import view.Produtos;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();		
		CadastroInsumos cadastroInsumos = new CadastroInsumos();
		CadastroProdutos cadastroProdutos = new CadastroProdutos();
		CadastroUsuario cadastroUsuario = new CadastroUsuario();
		Produtos produtos = new Produtos();
		Compra compra = new Compra();
		Login login = new Login();
		Carrinho carrinho = new Carrinho();

		UsuariosDAO usuariosDao = new UsuariosDAO();
		InsumosDAO insumosDao = new InsumosDAO();
		Insumos insumos = new Insumos(null, null, null, null, 0, 0, 0);
		
		Navegador navegador = new Navegador (login, telaPrincipal, cadastroUsuario, cadastroProdutos, cadastroInsumos);				
		LoginController loginController = new LoginController(login, usuariosDao, navegador);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastroUsuario, navegador, usuariosDao);
		CadastroProdutosController cadastroProdutosController = new CadastroProdutosController(navegador, cadastroInsumos,cadastroProdutos, produtos);
		ProdutosController produtosController = new ProdutosController(produtos, insumosDao, navegador, cadastroProdutos);
		CadastroInsumosController cadastroInsumosController = new CadastroInsumosController(cadastroInsumos, navegador, insumosDao, produtos, produtosController );
		CarrinhoController carrinhoController = new CarrinhoController(cadastroUsuario, carrinho, insumosDao, compra, navegador);
		CompraController compraController = new CompraController(compra, carrinho, insumos, navegador, insumosDao, carrinhoController);
		
		navegador.adicionarPainel("LOGIN", login);
		navegador.adicionarPainel("CADASTRO_INSUMOS", cadastroInsumos);
		navegador.adicionarPainel("CADASTRO_PRODUTOS", cadastroProdutos);
		navegador.adicionarPainel("CADASTRO_USUARIO", cadastroUsuario);
		navegador.adicionarPainel("COMPRA", compra);	
		navegador.adicionarPainel("PRODUTOS", produtos);
		navegador.adicionarPainel("CARRINHO", carrinho);

		
		telaPrincipal.setVisible(true);
		navegador.navegar("LOGIN");
		
	}

}
