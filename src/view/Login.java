package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfCpf;
	private JButton btEntrar;
	private JButton btNaoTenhoConta;
	private JLabel logo;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(new Color(255, 255, 224));
		setLayout(new MigLayout("", "[30.00,grow][][350.00][30.00,grow]", "[30.00,grow][][][][][][][34.00][grow]"));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/imagens/Semblante.png")));
		add(logo, "cell 1 0 2 1,alignx center");
		
		ImageIcon iconLogo = new ImageIcon(
		        Login.class.getResource("/imagens/Semblante.png")
		);

		Image imgLogo= iconLogo.getImage().getScaledInstance(
		        230,
		        230,
		        Image.SCALE_SMOOTH
		);
		logo.setIcon(new ImageIcon(imgLogo));

		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUsuario, "cell 1 1 2 1,alignx center,aligny center");

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfUsuario, "cell 1 2 2 1,growx");
		tfUsuario.setColumns(10);

		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCpf, "cell 1 4 2 1,alignx center,aligny center");

		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCpf, "cell 1 5 2 1,growx");
		tfCpf.setColumns(10);

		tfCpf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String cpf = tfCpf.getText().replace(" ", "");

				StringBuilder formatado = new StringBuilder();

				for (int i = 0; i < cpf.length(); i++) {
					if (i > 0 && i % 3 == 0) {
						formatado.append(" ");
					}
					formatado.append(cpf.charAt(i));
				}

				tfCpf.setText(formatado.toString());
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 224));
		add(panel_3, "cell 1 7,alignx left,growy");

		btNaoTenhoConta = new JButton("Não tenho conta");

		btNaoTenhoConta.setForeground(new Color(178, 34, 34));
		btNaoTenhoConta.setBackground(new Color(255, 255, 224));
		btNaoTenhoConta.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btNaoTenhoConta.setBorderPainted(false);
		panel_3.add(btNaoTenhoConta);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 2 7,alignx right,aligny center");

		btEntrar = new JButton("Entrar");

		btEntrar.setBackground(new Color(95, 158, 160));
		btEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btEntrar);
		btEntrar.setBorderPainted(false);
		;

	}

	public void entrar(ActionListener actionListener) {
		this.btEntrar.addActionListener(actionListener);
	}

	public void semConta(ActionListener actionListener) {
		this.btNaoTenhoConta.addActionListener(actionListener);
	}

	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(JTextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public JTextField getTfCpf() {
		return tfCpf;
	}

	public void setTfCpf(JTextField tfCpf) {
		this.tfCpf = tfCpf;
	}

}