package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCpf;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(new Color(175, 238, 238));
		setLayout(new MigLayout("", "[30.00,grow][][166.00][30.00,grow]", "[30.00,grow][][][][][][][][][][34.00][grow]"));
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbNome, "cell 1 1 2 1,alignx center,aligny center");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tfNome, "cell 1 2 2 1,growx");
		tfNome.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbUsuario, "cell 1 4 2 1,alignx center,aligny center");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tfUsuario, "cell 1 5 2 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbCpf, "cell 1 7 2 1,alignx center,aligny center");
		
		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tfCpf, "cell 1 8 2 1,growx");
		tfCpf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		add(panel_3, "cell 1 10,alignx left,growy");
		
		JButton btNaoTenhoConta = new JButton("Não tenho conta");
		btNaoTenhoConta.setForeground(new Color(16, 90, 95));
		btNaoTenhoConta.setBackground(new Color(175, 238, 238));
		btNaoTenhoConta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btNaoTenhoConta.setBorderPainted(false);
		panel_3.add(btNaoTenhoConta);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		add(panel, "cell 2 10,alignx right,aligny center");
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBackground(new Color(64, 128, 128));
		btEntrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel.add(btEntrar);
		btEntrar.setBorderPainted(false);;

	}

}
