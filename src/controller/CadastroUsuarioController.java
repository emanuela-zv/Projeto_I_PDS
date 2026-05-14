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

			String nome = cadastroUsuario.getTfNome().getText().trim();

			if (!nome.matches("^[A-Za-zÀ-ÿ]+\\s+[A-Za-zÀ-ÿ]{2,}.*$")) {
				JOptionPane.showMessageDialog(null, "Digite nome e sobrenome.", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			String cpf = cadastroUsuario.getTfCpf().getText().replace(" ", "");

			if (!cpf.matches("\\d{11}")) {
				JOptionPane.showMessageDialog(null, "CPF inválido! (Digite apenas os 11 números!)", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			if (verificarCpf(cpf)) {
				JOptionPane.showMessageDialog(null, "Este CPF já está em uso!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			String usuario = cadastroUsuario.getTfUsuario().getText().trim();

			if (verificarUsuario(usuario)) {
				JOptionPane.showMessageDialog(null, "Este usuário já está em uso!", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			Usuarios novoUsuario = new Usuarios(cpf, nome, usuario, cadastroUsuario.getRbAdm().isSelected());
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