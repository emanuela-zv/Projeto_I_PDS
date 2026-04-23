package controller;

import view.CadastroInsumos;
import view.CadastroProdutos;
import view.Produtos;

public class CadastroProdutosController {
	
	private Navegador navegador;
	private CadastroInsumos cadastroInsumos;
	private CadastroProdutos cadastroProdutos;
	private Produtos produtos;
	private LoginController loginController;
	
	
	public CadastroProdutosController(Navegador navegador, CadastroInsumos cadastroInsumos,
			CadastroProdutos cadastroProdutos, Produtos produtos, LoginController loginController) {
		super();
		this.navegador = navegador;
		this.cadastroInsumos = cadastroInsumos;
		this.cadastroProdutos = cadastroProdutos;
		this.produtos = produtos;
		this.loginController = loginController;
		
		this.cadastroProdutos.logout(e -> {
			loginController.logout();			
		});

		
		this.cadastroProdutos.cadastrar( e -> {
			this.navegador.navegar("CADASTRO_INSUMOS");
		});
		
		this.cadastroProdutos.visualizar(e -> {
			this.navegador.navegar("PRODUTOS");
		});
		
		this.cadastroProdutos.editar(e -> {
			this.navegador.navegar("PRODUTOS");
			produtos.setModoEdicao(true);
		});
		
		this.cadastroProdutos.remover(e -> {
			produtos.setModoExclusao(true);
			this.navegador.navegar("PRODUTOS");
			
		});
		
	}
	
	
}
