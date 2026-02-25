package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setBackground(new Color(175, 238, 238));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][][][][grow]"));
		
		JLabel lbCadastroProduto = new JLabel("Cadastro de Produtos");
		lbCadastroProduto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		add(lbCadastroProduto, "cell 1 1");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		add(panel, "cell 1 5,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(64, 128, 128));
		btCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel.add(btCadastrar);
		btCadastrar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		add(panel_1, "cell 2 5,grow");
		
		JButton btEditar = new JButton("Editar");
		btEditar.setBackground(new Color(64, 128, 128));
		btEditar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_1.add(btEditar);
		btEditar.setBorderPainted(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		add(panel_2, "cell 3 5,grow");
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setBackground(new Color(64, 128, 128));
		btExcluir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		panel_2.add(btExcluir);
		btExcluir.setBorderPainted(false);

	}

}
