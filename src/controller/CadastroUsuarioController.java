package controller;

import view.CadastroUsuario;

public class CadastroUsuarioController {
	
	private CadastroUsuario cadastroUsuario;
	private Navegador navegador;
	
	
	public CadastroUsuarioController(CadastroUsuario cadastroUsuario, Navegador navegador) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.navegador = navegador;
		
		this.cadastroUsuario.voltar( e ->{
			this.navegador.navegar("LOGIN");
		});
	}
	
	
	
	
	
	

}
