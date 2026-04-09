package controller;

import view.CadastroInsumos;
import view.CadastroProdutos;
import view.Produtos;

public class CadastroProdutosController {
	
	private Navegador navegador;
	private CadastroInsumos cadastroInsumos;
	private CadastroProdutos cadastroProdutos;
	private Produtos produtos;
	
	
	public CadastroProdutosController(Navegador navegador, CadastroInsumos cadastroInsumos,
			CadastroProdutos cadastroProdutos, Produtos produtos) {
		super();
		this.navegador = navegador;
		this.cadastroInsumos = cadastroInsumos;
		this.cadastroProdutos = cadastroProdutos;
		this.produtos = produtos;
		
		this.cadastroProdutos.cadastrar( e -> {
			this.navegador.navegar("CADASTRO_INSUMOS");
		});
		
		this.cadastroProdutos.visualizar(e ->{
			this.navegador.navegar("PRODUTOS");
		});
		
		this.cadastroProdutos.editar(e ->{
			this.navegador.navegar("PRODUTOS");
		});
		this.cadastroProdutos.remover(e ->{
			this.navegador.navegar("PRODUTOS");
		});
		
	}
	
	
}
