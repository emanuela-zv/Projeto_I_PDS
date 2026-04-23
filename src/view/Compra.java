package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import model.Insumos;

public class Compra extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btAdicionar;
	private JButton btCarrinho;
	private JButton btVerDetalhes;

	private JComboBox<Insumos> cbInsumos;
	public JSpinner spinnerQuant;
	private JLabel lbValorInsumo;
	private JButton btLogout;

	public Compra() {

		setLayout(new MigLayout("", "[][grow][][247.00][grow]", "[][grow][][][][][][41.00][grow]"));
		setBackground(new Color(255, 255, 224));
		
		btLogout = new JButton("Sair");
		btLogout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btLogout.setBackground(new Color(95, 158, 160));  
		btLogout.setForeground(Color.black);
		btLogout.setBorderPainted(false);
		add(btLogout, "cell 0 0");
		
		JLabel lbInsumo = new JLabel("Escolha o produto");
		lbInsumo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbInsumo, "cell 2 2");

		cbInsumos = new JComboBox<>();
		cbInsumos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(cbInsumos, "cell 3 2,growx");
		
		JLabel lbQuant = new JLabel("Escolha a quantidade");
		lbQuant.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuant, "cell 2 3");

		spinnerQuant = new JSpinner();
		spinnerQuant.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(spinnerQuant, "cell 3 3");
		
		JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinnerQuant.getEditor();
		editor.getTextField().setEditable(false);
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 2 4");

		lbValorInsumo = new JLabel("R$ 0,00");
		lbValorInsumo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorInsumo, "cell 3 4");

		btVerDetalhes = new JButton("Ver detalhes");
		btVerDetalhes.setForeground(new Color(128, 0, 0));
		btVerDetalhes.setHorizontalAlignment(SwingConstants.RIGHT);
		btVerDetalhes.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btVerDetalhes.setBorderPainted(false);
		btVerDetalhes.setBackground(new Color(255, 255, 224));
		add(btVerDetalhes, "cell 2 5,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 2 7,grow");

		btAdicionar = new JButton("Adicionar ao Carrinho");
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btAdicionar.setBackground(new Color(95, 158, 160));
		btAdicionar.setBorderPainted(false);
		panel.add(btAdicionar);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(95, 158, 160));
		add(panel2, "cell 3 7,grow");

		btCarrinho = new JButton("Ir para o carrinho");
		btCarrinho.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btCarrinho.setBackground(new Color(95, 158, 160));
		btCarrinho.setBorderPainted(false);
		panel2.add(btCarrinho);
		

	}

	public void configurarLimiteEstoque(int estoque) {
	    if (estoque > 0) {
	        // Inicial, Min, Max, Passo
	        spinnerQuant.setModel(new SpinnerNumberModel(1, 1, estoque, 1));
	        spinnerQuant.setEnabled(true);
	    } else {
	        spinnerQuant.setModel(new SpinnerNumberModel(0, 0, 0, 0));
	        spinnerQuant.setEnabled(false);
	        lbValorInsumo.setText("Sem estoque");
	    }
	}

	public void atualizarValorTotal(double valor) {
	    lbValorInsumo.setText(String.format("R$ %.2f", valor));
	}
	
	public JComboBox<Insumos> getCbInsumos() {
		return cbInsumos;
	}

	public void setCbInsumos(JComboBox<Insumos> cbInsumos) {
		this.cbInsumos = cbInsumos;
	}

	public void carrinho(ActionListener actionListener) {
		this.btCarrinho.addActionListener(actionListener);
	}
	public void adicionar(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}
	public void detalhes(ActionListener actionListener) {
		this.btVerDetalhes.addActionListener(actionListener);
	}
	public void logout(ActionListener actionListener) {
	    this.btLogout.addActionListener(actionListener);
	}
	
}