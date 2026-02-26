package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CadastroProdutos() {
		setBackground(new Color(211, 211, 211));
		setLayout(new MigLayout("", "[42.00,grow][grow][grow]", "[grow][][][][][][][grow]"));
		
		JLabel lbGerenciarProdutos = new JLabel("Gerência de Produtos");
		lbGerenciarProdutos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		add(lbGerenciarProdutos, "cell 1 1,alignx center,aligny center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		add(panel, "cell 1 3,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(178, 34, 34));
		btCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		add(panel_1, "cell 1 4,grow");
		
		JButton btVisualizar = new JButton("Visualizar");
		btVisualizar.setBackground(new Color(178, 34, 34));
		btVisualizar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_1.add(btVisualizar);
		btVisualizar.setBorderPainted(false);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(178, 34, 34));
		add(panel_1_1, "cell 1 5,grow");
		
		JButton btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		btEditar.setBorderPainted(false);
		btEditar.setBackground(new Color(178, 34, 34));
		panel_1_1.add(btEditar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		add(panel_2, "cell 1 6,grow");
		
		JButton btRemover = new JButton("Remover");
		btRemover.setBackground(new Color(178, 34, 34));
		btRemover.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_2.add(btRemover);
		btRemover.setBorderPainted(false);

	}

}
