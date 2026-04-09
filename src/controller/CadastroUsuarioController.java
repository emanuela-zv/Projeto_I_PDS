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

    public CadastroUsuarioController(CadastroUsuario cadastroUsuario, Navegador navegador,
                                     UsuariosDAO usuariosDao) {

        this.cadastroUsuario = cadastroUsuario;
        this.navegador = navegador;
        this.usuariosDao = usuariosDao;

        
        this.cadastroUsuario.voltar(e -> navegador.navegar("LOGIN"));

        
        this.cadastroUsuario.cadastrar(e -> {

            
            if (cadastroUsuario.getTfNome().getText().isEmpty() ||
                cadastroUsuario.getTfUsuario().getText().isEmpty() ||
                cadastroUsuario.getTfCpf().getText().isEmpty() ||
                (!cadastroUsuario.getRbCliente().isSelected() && !cadastroUsuario.getRbAdm().isSelected())) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            
            if (!verificarCpf(cadastroUsuario.getTfCpf().getText())) {

                
                Usuarios novoUsuario = new Usuarios(
                    cadastroUsuario.getTfCpf().getText(),
                    cadastroUsuario.getTfNome().getText(),
                    cadastroUsuario.getTfUsuario().getText(),
                    cadastroUsuario.getRbAdm().isSelected() // true = admin, false = cliente
                );

                
                usuariosDao.adicionarDados(novoUsuario);

                
                JOptionPane.showMessageDialog(null, "O usuário foi cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                navegador.navegar("LOGIN");

            } else {
                JOptionPane.showMessageDialog(null, "Este CPF já está em uso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
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
}