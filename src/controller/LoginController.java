package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuarios;
import model.UsuariosDAO;
import view.CadastroUsuario;
import view.Login;

public class LoginController {
	
	private Login login;
	private UsuariosDAO usuariosDao;
	private Navegador navegador;
	private String usuarioExistente;
	

	public LoginController(Login login, UsuariosDAO usuariosDao, Navegador navegador) {
		super();
		this.login = login;
		this.usuariosDao =usuariosDao;
		this.navegador = navegador;
		
		
		this.login.entrar(e -> {
			//ação do botão	
			verificarUsuario();
			
		});
		
		this.login.semConta(e ->{
			this.navegador.navegar("CADASTRO_USUARIO");
			limparDados();
		});
		
	}
	
	private void verificarUsuario() {
		
		List<Usuarios> usuarios = usuariosDao.listarUsuarios();
		
		if(login.getTfCpf().getText().isEmpty() 
				|| login.getTfUsuario().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
		
		else {
			
			Usuarios usuarioEncontrado = null;
			
			for (Usuarios usuario : usuarios) {
				
				if(usuario.getUsuario().equals(login.getTfUsuario().getText())
						&& usuario.getCpf().equals(login.getTfCpf().getText())){
					
					usuarioEncontrado = usuario;
					break;
				}
			}
			
			if (usuarioEncontrado != null) {

			    usuarioExistente = usuarioEncontrado.getNome();

			    if (usuarioEncontrado.isAdm()) {
			        this.navegador.navegar("CADASTRO_PRODUTOS");
			    } else {
			        this.navegador.navegar("COMPRA");
			    }
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos! \nVerfique as informações.", "Informação", 1);
				
			}
		}
		
	}
	
	public void limparDados(){
		login.getTfCpf().setText("");
		login.getTfUsuario().setText("");		
	}
	
//	public void logout() {
//	    // Limpa dados do usuário (se você tiver algo assim)
//	    login.setUsuario(null);
//
//	    // Limpa carrinho
//	    carrinhoController.limparCarrinho();
//
//	    // Navega para tela de login
//	    navegador.navegar("LOGIN");
//	}
	
	
	
	

}
