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
	

	public LoginController(Login login, UsuariosDAO usuariosDAO, Navegador navegador) {
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
		});
		
	}
	
	private void verificarUsuario() {
		
		List<Usuarios> usuarios = usuariosDao.listarUsuarios();
		
		if(login.getTfNome().getText().isEmpty() || login.getTfCpf().getText().isEmpty() 
				|| login.getTfUsuario().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
		
		else {
			
			Usuarios usuarioEncontrado = null;
			
			for (Usuarios usuario : usuarios) {
				
				if(usuario.getNome().equals(login.getTfNome().getText())
						&& usuario.getUsuario().equals(login.getTfUsuario().getText())
						&& usuario.getCpf().equals(login.getTfCpf().getText())){
					
					usuarioEncontrado = usuario;
					break;
				}
			}
			
			if (usuarioEncontrado != null) {

			    usuarioExistente = usuarioEncontrado.getNome();

			    if (usuarioEncontrado.isAdm()) {
			        this.navegador.navegar("CADASTRO_INSUMOS");
			    } else {
			        this.navegador.navegar("COMPRA");
			    }
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado! \nVerfique as informações.", "Informação", 1);
			}
		}
		
	}
	
	
	
	
	

}
