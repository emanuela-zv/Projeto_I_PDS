package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuarios;
import model.UsuariosDAO;
import view.Login;

public class LoginController {
	
	private Login login;
	private UsuariosDAO usuariosDao = new UsuariosDAO();
	private Navegador navegador;
	

	public LoginController(Login login, Navegador navegador) {
		super();
		this.login = login;
		this.navegador = navegador;
		
		this.login.btEntrar(e -> {
			//ação do botão	
			verificarUsuario();
			
			
		});
		
	}
	
	private void verificarUsuario() {
		
		List<Usuarios> usuarios = usuariosDao.listarUsuarios();
		
		for (Usuarios u: usuarios) {
			if(u.getCpf().isEmpty()) {
				JOptionPane.showMessageDialog("Usuário não encontrado", usuarios);
			}
			else {
				if(u.isAdm()==true) {
					this.navegador.navegarTela("CADASTROPRODUTOS");
					
				}
				else {
					this.navegador.navegarTela("COMPRA");
				}
			}
		}
		
	}
	
	
	

}
