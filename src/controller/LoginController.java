package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Usuarios;
import model.UsuariosDAO;
import view.CadastroUsuario;
import view.Login;
import view.TelaPrincipal;

public class LoginController {
	
	private Login login;
	private UsuariosDAO usuariosDao;
	private Navegador navegador;
	private TelaPrincipal telaPrincipal;
	private String usuarioExistente;
	private CarrinhoController carrinhoController;
	private static Usuarios usuarioLogado;

	public LoginController(Login login, UsuariosDAO usuariosDao, Navegador navegador, TelaPrincipal tela) {
		super();
		this.login = login;
		this.usuariosDao =usuariosDao;
		this.navegador = navegador;	
		this.telaPrincipal = tela;
		
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

			    this.usuarioLogado = usuarioEncontrado; 

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
	
    public void logout() {
    	
	    int confirm = JOptionPane.showConfirmDialog(
		        telaPrincipal,
		        "Deseja sair da conta?",
		        "Sair",
		        JOptionPane.YES_NO_OPTION
		        
		    );
		    if (confirm == JOptionPane.YES_OPTION) {
		        LoginController.usuarioLogado = null;
		        navegador.navegar("LOGIN");
		     		    
		    }
		    
        if (carrinhoController != null) {
            carrinhoController.limparCarrinho();
        }
        
        limparDados();
        
    }
	
	public void setCarrinhoController(CarrinhoController carrinhoController) {
	    this.carrinhoController = carrinhoController;
	}

	public Usuarios getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuarios usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
	
	
	
	
	

}
