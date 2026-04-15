package controller;

import view.CadastroInsumos;
import view.CadastroUsuario;
import view.Carrinho;
import view.Compra;

public class CarrinhoController {
	
	private CadastroUsuario cadastroUsuario;
	private Carrinho carrinho;
	private CadastroInsumos cadastroInsumos;
	private Compra compra;
	private Navegador navegador;
	
	public CarrinhoController(CadastroUsuario cadastroUsuario, Carrinho carrinho, CadastroInsumos cadastroInsumos,
			Compra compra, Navegador navegador) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.carrinho = carrinho;
		this.cadastroInsumos = cadastroInsumos;
		this.compra = compra;
		this.navegador = navegador;
		
		this.carrinho.voltar(e -> {
			
			System.out.println("CLIQUE");
			navegador.navegar("COMPRA");
		});
	}
	
	

}
