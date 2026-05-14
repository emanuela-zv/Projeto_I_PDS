package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btVisualizar;
	private JButton btEditar;
	private JButton btCadastrar;
	private JButton btRemover;
	private boolean modoExclusao = false;
	private JButton btLogout;
	private JLabel logo;

	/**
	 * Create the panel.
	 */
	public CadastroProdutos() {
		
		setBackground(new Color(255, 255, 224));
		setLayout(new MigLayout("", "[][42.00,grow][grow][grow]", "[][grow][][][][][][][grow]"));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/imagens/Semblante.png")));
		add(logo, "cell 2 1,alignx center,aligny center");
		
		ImageIcon iconLogo = new ImageIcon(
		        Login.class.getResource("/imagens/Semblante.png")
		);

		Image imgInterrogacao = iconLogo.getImage().getScaledInstance(
		        230,
		        230,
		        Image.SCALE_SMOOTH
		);
		logo.setIcon(new ImageIcon(imgInterrogacao));
		
		JLabel lbGerenciarProdutos = new JLabel("Gerência de Produtos");
		lbGerenciarProdutos.setFont(new Font("Times New Roman", Font.BOLD, 35));
		add(lbGerenciarProdutos, "cell 2 2,alignx center,aligny center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 2 4,grow");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(95, 158, 160));
		btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		add(panel_1, "cell 2 5,grow");
		
		btVisualizar = new JButton("Visualizar");
		btVisualizar.setBackground(new Color(95, 158, 160));
		btVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(btVisualizar);
		btVisualizar.setBorderPainted(false);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(95, 158, 160));
		add(panel_1_1, "cell 2 6,grow");
		
		btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btEditar.setBorderPainted(false);
		btEditar.setBackground(new Color(95, 158, 160));
		panel_1_1.add(btEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		add(panel_2, "cell 2 7,grow");
		
		btRemover = new JButton("Remover");
		btRemover.setBackground(new Color(95, 158, 160));
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_2.add(btRemover);
		btRemover.setBorderPainted(false);		
		
		btLogout = new JButton("Sair");
		btLogout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btLogout.setBackground(new Color(95, 158, 160));  
		btLogout.setForeground(Color.black);
		btLogout.setBorderPainted(false);
		add(btLogout, "cell 0 0");

	}
	
	public void cadastrar(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}
	public void editar (ActionListener actionListener) {
		this.btEditar.addActionListener(actionListener);
	}
	public void visualizar(ActionListener actionListener) {
		this.btVisualizar.addActionListener(actionListener);
	}
	public void remover(ActionListener actionListener) {
		this.btRemover.addActionListener(actionListener);
	}
	public void logout(ActionListener actionListener) {
	    this.btLogout.addActionListener(actionListener);
	}

}