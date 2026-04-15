package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Compra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btAdicionar;
	private JButton btCarrinho;
	
	
	/**
	 * Create the panel.
	 */
	public Compra() {
		setLayout(new MigLayout("", "[grow][][247.00,grow][grow]", "[grow][][][][][][41.00][grow]"));
		setBackground(new Color(255, 255, 224));
		
		JLabel lbInsumo = new JLabel("Escolha o produto");
		lbInsumo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbInsumo, "cell 1 1,alignx left");
		
		JComboBox cbInsumos = new JComboBox();
		cbInsumos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(cbInsumos, "cell 2 1,growx");
		
		JLabel lbQuant = new JLabel("Escolha a quantidade");
		lbQuant.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuant, "cell 1 2");
		
		JSpinner spinnerQuant = new JSpinner();
		spinnerQuant.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(spinnerQuant, "cell 2 2");
		
		JLabel lbDescricao = new JLabel("Descrição:");
		lbDescricao.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDescricao, "cell 1 3");
		
		JLabel lbDescricaoInsumo = new JLabel(".");
		lbDescricaoInsumo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDescricaoInsumo, "cell 2 3");
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 1 4");
		
		JLabel lbValorInsumo = new JLabel("R$  ,");
		lbValorInsumo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorInsumo, "cell 2 4");
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		add(panel, "cell 1 6,alignx center,growy");
		
		btAdicionar = new JButton("Adicionar ao Carrinho");
		btAdicionar.setHorizontalAlignment(SwingConstants.RIGHT);
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btAdicionar.setBackground(new Color(95, 158, 160));
		panel.add(btAdicionar);
		btAdicionar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 224));
		add(panel_1, "cell 2 6,grow");
		
		btCarrinho = new JButton("Ir para o carrinho");
		btCarrinho.setHorizontalAlignment(SwingConstants.RIGHT);
		btCarrinho.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btCarrinho.setBorderPainted(false);
		btCarrinho.setBackground(new Color(95, 158, 160));
		panel_1.add(btCarrinho);
		

	}
	
	public void adicionar(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}
	public void carrinho(ActionListener actionListener) {
		this.btCarrinho.addActionListener(actionListener);;
	}
	

}
