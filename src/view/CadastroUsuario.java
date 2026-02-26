package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		setBackground(new Color(211, 211, 211));
		setLayout(new MigLayout("", "[grow][sizegroup tamanhoIgual][sizegroup tamanhoIgual][grow]", "[grow][][][][][][][][][grow]"));
		
		JLabel lbCadastroUsuario = new JLabel("Cadastro de usuário");
		lbCadastroUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		add(lbCadastroUsuario, "cell 1 1 2 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome completo");
		lbNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbNome, "cell 1 3");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbUsuario, "cell 1 4,alignx left");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		tfUsuario.setColumns(10);
		add(tfUsuario, "cell 2 4,growx");
		
		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbCpf, "cell 1 5,alignx left");
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textField.setColumns(10);
		add(textField, "cell 2 5,growx");
		
		
		
		JRadioButton rbCliente = new JRadioButton("Sou cliente");
		rbCliente.setBackground(new Color(211, 211, 211));
		rbCliente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(rbCliente, "cell 1 6,alignx left");
		
		JRadioButton rbAdm = new JRadioButton("Sou administrador");
		rbAdm.setBackground(new Color(211, 211, 211));
		rbAdm.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(rbAdm, "cell 2 6,alignx center");
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		add(panel, "cell 1 8,grow");
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBackground(new Color(178, 34, 34));
		btVoltar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel.add(btVoltar);
		btVoltar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		add(panel_1, "cell 2 8,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(178, 34, 34));
		btCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_1.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
				
		ButtonGroup identificador = new ButtonGroup();
		identificador.add(rbAdm);
		identificador.add(rbCliente);
	}

}
