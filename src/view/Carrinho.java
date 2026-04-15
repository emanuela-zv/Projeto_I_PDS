package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Carrinho extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaCarrinho;
	private DefaultTableModel modelo;
	private JButton btNota;
	private JButton btVoltar;
	private JButton btRemover;
	private JButton btFinalizarCompra;

	public Carrinho() {
		setLayout(new MigLayout("", "[][][][][]", "[][][211.00][][]"));
		
         modelo = new DefaultTableModel(
                new Object[]{"Produto", "Quantidade", "Valor unitário", "Subtotal"},
                0
            ) {                
            };
                   
            tabelaCarrinho = new JTable(modelo);   
            
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 2 3 1,grow");
		
		tabelaCarrinho = new JTable();
		tabelaCarrinho.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		scrollPane_1.setViewportView(tabelaCarrinho);
		
		btVoltar = new JButton("Voltar");
		add(btVoltar, "cell 1 3");
		btVoltar.setBackground(new Color(95, 158, 160));
		btVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btVoltar.setBorderPainted(false);
		
		btRemover = new JButton("Remover");
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btRemover.setBackground(new Color(95, 158, 160));
		add(btRemover, "cell 2 3");
		btRemover.setBorderPainted(false);
		
		btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btFinalizarCompra.setBackground(new Color(95, 158, 160));
		add(btFinalizarCompra, "cell 3 3");
		btFinalizarCompra.setBorderPainted(false);
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 4,grow");
		
		btNota = new JButton("Emitir nota fiscal");
		btNota.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btNota.setBackground(new Color(95, 158, 160));
		add(btNota, "cell 3 4");
		btNota.setBorderPainted(false);
		
	}
	
	public void voltar(ActionListener actionListener) {
		this.btVoltar.addActionListener(actionListener);
	}
	public void remover(ActionListener actionListener) {
		this.btRemover.addActionListener(actionListener);
	}
	public void finalizarCompra(ActionListener actionListener) {
		this.btFinalizarCompra.addActionListener(actionListener);
	}
	public void nota(ActionListener actionListener) {
		this.btNota.addActionListener(actionListener);
	}
	
	

}
