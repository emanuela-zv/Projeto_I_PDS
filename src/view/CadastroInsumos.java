package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class CadastroInsumos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfMarca;
	private JTextField tfFornecedora;
	private JTextField tfCodigoBarras;
	private JTextField tfQuantidade;
	private JTextField tfValor;
	private JButton btVoltar;
	private JButton btCadastrar;
	private JTextField tfDescricao;

	/**
	 * Create the panel.
	 */
	public CadastroInsumos() {
		setBackground(new Color(255, 255, 224));
		setLayout(new MigLayout("", "[143.00,grow][][387.00][grow]", "[grow][][][][][][][][][][][grow]"));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		
		JLabel lbCadastroProdutos = new JLabel("Cadastro de Produtos");
		lbCadastroProdutos.setFont(new Font("Eras Bold ITC", Font.PLAIN, 30));
		add(lbCadastroProdutos, "cell 1 1 2 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbNome, "cell 1 3,alignx left");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbMarca, "cell 1 4,alignx left");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		tfMarca.setColumns(10);
		add(tfMarca, "cell 2 4,growx");
		
		JLabel lbFornecedora = new JLabel("Fornecedora");
		lbFornecedora.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbFornecedora, "cell 1 5,alignx left");
		
		tfFornecedora = new JTextField();
		tfFornecedora.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		tfFornecedora.setColumns(10);
		add(tfFornecedora, "cell 2 5,growx");
		
		JLabel lbCodigoBarras = new JLabel("Código de Barras");
		lbCodigoBarras.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbCodigoBarras, "cell 1 6,alignx left");
		
		tfCodigoBarras = new JTextField();
		tfCodigoBarras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		tfCodigoBarras.setColumns(10);
		add(tfCodigoBarras, "cell 2 6,growx");
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbQuantidade, "cell 1 7,alignx left");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		tfQuantidade.setColumns(10);
		add(tfQuantidade, "cell 2 7,growx");
		
		JLabel lbValor = new JLabel("Valor (da unidade)");
		lbValor.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbValor, "cell 1 8,alignx trailing");
		
		tfValor = new JTextField();
		tfValor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		tfValor.setColumns(10);
		add(tfValor, "cell 2 8,growx");
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		add(lbDescricao, "cell 1 9,alignx left");
		
		tfDescricao = new JTextField();
		tfDescricao.setFont(new Font("Eras Medium ITC", Font.PLAIN, 22));
		add(tfDescricao, "cell 2 9,growx");
		tfDescricao.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		add(panel_1, "cell 1 10,grow");
		
		btVoltar = new JButton("Voltar");
		btVoltar.setBackground(new Color(95, 158, 160));
		btVoltar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		panel_1.add(btVoltar);
		btVoltar.setBorderPainted(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		add(panel, "cell 2 10,grow");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(95, 158, 160));
		btCadastrar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);

	}
	
	public void voltar(ActionListener actionListener) {
		this.btVoltar.addActionListener(actionListener);
	}

	public void cadastrar(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfMarca() {
		return tfMarca;
	}

	public void setTfMarca(JTextField tfMarca) {
		this.tfMarca = tfMarca;
	}

	public JTextField getTfFornecedora() {
		return tfFornecedora;
	}

	public void setTfFornecedora(JTextField tfFornecedora) {
		this.tfFornecedora = tfFornecedora;
	}

	public JTextField getTfCodigoBarras() {
		return tfCodigoBarras;
	}

	public void setTfCodigoBarras(JTextField tfCodigoBarras) {
		this.tfCodigoBarras = tfCodigoBarras;
	}

	public JTextField getTfQuantidade() {
		return tfQuantidade;
	}

	public void setTfQuantidade(JTextField tfQuantidade) {
		this.tfQuantidade = tfQuantidade;
	}

	public JTextField getTfValor() {
		return tfValor;
	}

	public void setTfValor(JTextField tfValor) {
		this.tfValor = tfValor;
	}

	public JTextField getTfDescricao() {
		return tfDescricao;
	}

	public void setTfDescricao(JTextField tfDescricao) {
		this.tfDescricao = tfDescricao;
	}
	
	
}
