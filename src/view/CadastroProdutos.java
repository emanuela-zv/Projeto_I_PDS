package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btVisualizar;
	private JButton btEditar;
	private JButton btCadastrar;
	private JButton btRemover;
	private boolean modoExclusao = false;

	/**
	 * Create the panel.
	 */
	public CadastroProdutos() {
		
		setBackground(new Color(255, 255, 224));
		setLayout(new MigLayout("", "[42.00,grow][grow][grow]", "[grow][][][][][][][grow]"));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		
		JLabel lbGerenciarProdutos = new JLabel("Gerência de Produtos");
		lbGerenciarProdutos.setFont(new Font("Times New Roman", Font.BOLD, 35));
		add(lbGerenciarProdutos, "cell 1 1,alignx center,aligny center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 1 3,grow");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(95, 158, 160));
		btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		add(panel_1, "cell 1 4,grow");
		
		btVisualizar = new JButton("Visualizar");
		btVisualizar.setBackground(new Color(95, 158, 160));
		btVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(btVisualizar);
		btVisualizar.setBorderPainted(false);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(95, 158, 160));
		add(panel_1_1, "cell 1 5,grow");
		
		btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btEditar.setBorderPainted(false);
		btEditar.setBackground(new Color(95, 158, 160));
		panel_1_1.add(btEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		add(panel_2, "cell 1 6,grow");
		
		btRemover = new JButton("Remover");
		btRemover.setBackground(new Color(95, 158, 160));
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_2.add(btRemover);
		btRemover.setBorderPainted(false);		

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

}