package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfCpf;
	private JButton btVoltar;
	private JButton btCadastrar;
	private JRadioButton rbCliente;
	private JRadioButton rbAdm;
	private ButtonGroup identificador;
	private JLabel logo;
	
	
	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		setBackground(new Color(255, 255, 224));
		setLayout(new MigLayout("", "[grow][165.00,sizegroup tamanhoigual][313.00,sizegroup tamanhoigual][grow]", "[][][][][][][][][][grow]"));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		
		logo = new JLabel("");
		add(logo, "cell 1 0 2 1,alignx center,aligny center");
		
		ImageIcon iconLogo = new ImageIcon(
		        Login.class.getResource("/imagens/Semblante.png")
		);

		Image imgLogo= iconLogo.getImage().getScaledInstance(
		        230,
		        230,
		        Image.SCALE_SMOOTH
		);
		logo.setIcon(new ImageIcon(imgLogo));
		
		
		JLabel lbCadastroUsuario = new JLabel("Cadastro de usuário");
		lbCadastroUsuario.setFont(new Font("Times New Roman", Font.BOLD, 35));
		add(lbCadastroUsuario, "cell 1 1 2 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome completo");
		lbNome.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNome, "cell 1 3");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUsuario, "cell 1 4,alignx left");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfUsuario.setColumns(10);
		add(tfUsuario, "cell 2 4,growx");
		
		JLabel lbCpf = new JLabel("CPF");
		lbCpf.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCpf, "cell 1 5,alignx left");
		
		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfCpf.setColumns(10);
		add(tfCpf, "cell 2 5,growx");
		
		tfCpf.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        // permite apenas números e backspace
		        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
		            e.consume();
		            return;
		        }

		        // conta apenas números reais (ignora espaços)
		        String cpf = tfCpf.getText().replace(" ", "");

		        // limite de 11 dígitos
		        if (Character.isDigit(c) && cpf.length() >= 11) {
		            e.consume();
		        }
		    }

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
				
		rbCliente = new JRadioButton("Sou cliente");
		rbCliente.setBackground(new Color(255, 255, 224));
		rbCliente.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(rbCliente, "cell 1 6,alignx left");
		
		rbAdm = new JRadioButton("Sou administrador");
		rbAdm.setBackground(new Color(255, 255, 224));
		rbAdm.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(rbAdm, "cell 2 6,alignx center");
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 1 8,grow");
		
		btVoltar = new JButton("Voltar");
		btVoltar.setBackground(new Color(95, 158, 160));
		btVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btVoltar);
		btVoltar.setBorderPainted(false);
		btVoltar.setContentAreaFilled(false);
		btVoltar.setFocusPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		add(panel_1, "cell 2 8,grow");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(95, 158, 160));
		btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
		btCadastrar.setContentAreaFilled(false);
		btCadastrar.setFocusPainted(false);
				
		identificador = new ButtonGroup();
		identificador.add(rbAdm);
		identificador.add(rbCliente);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
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
	
	public JRadioButton getRbCliente() {
		return rbCliente;
	}

	public void setRbCliente(JRadioButton rbCliente) {
		this.rbCliente = rbCliente;
	}

	public JRadioButton getRbAdm() {
		return rbAdm;
	}

	public void setRbAdm(JRadioButton rbAdm) {
		this.rbAdm = rbAdm;
	}
	
	public void limparSelecao() {
		identificador.clearSelection();
	}
	

	public void voltar(ActionListener actionListener) {
		this.btVoltar.addActionListener(actionListener);
		
	}
	public void cadastrar(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}
	
	
}