package view;

import java.awt.Color;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Produtos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaInsumos;

	/**
	 * Create the panel.
	 */
	public Produtos() {
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		setBackground(new Color(211, 211, 211));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 1,grow");
		
		tabelaInsumos = new JTable();
		scrollPane.setViewportView(tabelaInsumos);
		
		String[] colunas = {"Nome", "Marca", "Fornecedora", "Código de Barras", "Quantidade", "Valor (unidade)", "Descrição"};
		
        TableModel modelo;
		
        
		
		

	}

}
