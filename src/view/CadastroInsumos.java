package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class CadastroInsumos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfMarca;
	private JTextField tfFornecedora;
	private JTextField tfCodigoBarras;
	private JTextField tfQuantidade;

	/**
	 * Create the panel.
	 */
	public CadastroInsumos() {
		setBackground(new Color(211, 211, 211));
		setLayout(new MigLayout("", "[grow][][306.00,grow][grow]", "[grow][][][][][][][][grow][][grow]"));
		
		JLabel lbCadastroProdutos = new JLabel("Cadastro de Produtos");
		lbCadastroProdutos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		add(lbCadastroProdutos, "cell 1 1 2 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbNome, "cell 1 3,alignx left");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbMarca, "cell 1 4,alignx left");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		tfMarca.setColumns(10);
		add(tfMarca, "cell 2 4,growx");
		
		JLabel lbFornecedora = new JLabel("Fornecedora");
		lbFornecedora.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbFornecedora, "cell 1 5,alignx left");
		
		tfFornecedora = new JTextField();
		tfFornecedora.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		tfFornecedora.setColumns(10);
		add(tfFornecedora, "cell 2 5,growx");
		
		JLabel lbCodigoBarras = new JLabel("Código de Barras");
		lbCodigoBarras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbCodigoBarras, "cell 1 6,alignx left");
		
		tfCodigoBarras = new JTextField();
		tfCodigoBarras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		tfCodigoBarras.setColumns(10);
		add(tfCodigoBarras, "cell 2 6,growx");
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbQuantidade, "cell 1 7,alignx left");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		tfQuantidade.setColumns(10);
		add(tfQuantidade, "cell 2 7,growx");
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		add(lbDescricao, "cell 1 8");
		
		JTextPane tpDescricao = new JTextPane();
		tpDescricao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		add(tpDescricao, "cell 2 8,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		add(panel_1, "cell 1 9,grow");
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBackground(new Color(178, 34, 34));
		btVoltar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_1.add(btVoltar);
		btVoltar.setBorderPainted(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		add(panel, "cell 2 9,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(178, 34, 34));
		btCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);

	}

}
