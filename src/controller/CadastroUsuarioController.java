package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Usuarios;
import model.UsuariosDAO;
import view.CadastroUsuario;

public class CadastroUsuarioController {

	private CadastroUsuario cadastroUsuario;
	private Navegador navegador;
	private UsuariosDAO usuariosDao;

	public CadastroUsuarioController(CadastroUsuario cadastroUsuario, Navegador navegador, UsuariosDAO usuariosDao) {

		this.cadastroUsuario = cadastroUsuario;
		this.navegador = navegador;
		this.usuariosDao = usuariosDao;

		this.cadastroUsuario.voltar(e -> {
			navegador.navegar("LOGIN");
			limparDados();

		});

		this.cadastroUsuario.cadastrar(e -> {

			if (cadastroUsuario.getTfNome().getText().isEmpty() || cadastroUsuario.getTfUsuario().getText().isEmpty()
					|| cadastroUsuario.getTfCpf().getText().isEmpty()
					|| (!cadastroUsuario.getRbCliente().isSelected() && !cadastroUsuario.getRbAdm().isSelected())) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			String cpf = cadastroUsuario.getTfCpf().getText();
			String usuario = cadastroUsuario.getTfUsuario().getText();

			if (verificarCpf(cpf)) {
				JOptionPane.showMessageDialog(null, "Este CPF já está em uso!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			if (verificarUsuario(usuario)) {
				JOptionPane.showMessageDialog(null, "Este usuário já está em uso!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			Usuarios novoUsuario = new Usuarios(cpf, cadastroUsuario.getTfNome().getText(), usuario,
					cadastroUsuario.getRbAdm().isSelected());

			usuariosDao.adicionarDados(novoUsuario);

			JOptionPane.showMessageDialog(null, "O usuário foi cadastrado!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			navegador.navegar("LOGIN");
			limparDados();
		});
	}

	private boolean verificarCpf(String cpfDigitado) {
		List<Usuarios> listaUsuarios = usuariosDao.listarUsuarios();
		for (Usuarios u : listaUsuarios) {
			if (u.getCpf().equals(cpfDigitado)) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarUsuario(String usuarioDigitado) {
		List<Usuarios> listaUsuarios = usuariosDao.listarUsuarios();
		for (Usuarios u : listaUsuarios) {
			if (u.getUsuario().equals(usuarioDigitado)) {
				return true;
			}
		}
		return false;
	}

	public void limparDados() {
		cadastroUsuario.getTfNome().setText("");
		cadastroUsuario.getTfCpf().setText("");
		cadastroUsuario.getTfUsuario().setText("");
		cadastroUsuario.limparSelecao();

	}
}