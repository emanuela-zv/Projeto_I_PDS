package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.List;

public class Carrinho extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tabelaCarrinho;
	private DefaultTableModel modelo;
	private JButton btNota;
	private JButton btVoltar;
	private JButton btRemover;
	private JButton btFinalizarCompra;
	private JLabel lbTotal;
	private int linhaSelecionada = -1;
	private JButton btLogout;

	public Carrinho() {

		setLayout(new MigLayout("", "[26.00][grow][][][][][][32.00,grow]", "[][grow][187.00][][42.00,grow]"));
		setBackground(new Color(255, 255, 225));

		modelo = new DefaultTableModel(new Object[] { "Produto", "Quantidade", "Valor unitário", "Subtotal" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;

		tabelaCarrinho = new JTable(modelo);

		tabelaCarrinho.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JTableHeader header = tabelaCarrinho.getTableHeader();
		header.setBackground(new Color(95, 158, 160));
		header.setForeground(new Color(0, 0, 0));
		header.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		tabelaCarrinho.getTableHeader().setReorderingAllowed(false);
		tabelaCarrinho.getTableHeader().setResizingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tabelaCarrinho);
		add(scrollPane, "cell 2 2 5 1,grow");

		tabelaCarrinho.getSelectionModel().addListSelectionListener(e -> {

			if (!e.getValueIsAdjusting()) {
				linhaSelecionada = tabelaCarrinho.getSelectedRow();
			}
		});

		btVoltar = new JButton("Voltar");
		btVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btVoltar.setBackground(new Color(95, 158, 160));
		btVoltar.setBorderPainted(false);
		btVoltar.setContentAreaFilled(false);
		btVoltar.setFocusPainted(false);
		add(btVoltar, "cell 2 3");

		btRemover = new JButton("Remover");
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btRemover.setBackground(new Color(95, 158, 160));
		btRemover.setBorderPainted(false);
		btRemover.setContentAreaFilled(false);
		btRemover.setFocusPainted(false);
		add(btRemover, "cell 3 3");

		btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btFinalizarCompra.setBackground(new Color(95, 158, 160));
		btFinalizarCompra.setBorderPainted(false);
		btFinalizarCompra.setContentAreaFilled(false);
		btFinalizarCompra.setFocusPainted(false);
		add(btFinalizarCompra, "cell 4 3");

		btNota = new JButton("Emitir nota fiscal");
		btNota.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btNota.setBackground(new Color(95, 158, 160));
		btNota.setBorderPainted(false);
		btNota.setContentAreaFilled(false);
		btNota.setFocusPainted(false);
		add(btNota, "cell 5 3");

		btLogout = new JButton("Sair");
		btLogout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btLogout.setBackground(new Color(95, 158, 160));
		btLogout.setForeground(Color.black);
		btLogout.setBorderPainted(false);
		btLogout.setContentAreaFilled(false);
		btLogout.setFocusPainted(false);
		add(btLogout, "cell 0 0");

		lbTotal = new JLabel("Total: R$ 0,00");
		lbTotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
		add(lbTotal, "cell 6 3");
	}

	public void notaFiscal(ActionListener actionListener) {
		this.btNota.addActionListener(actionListener);
	}

	public void finalizar(ActionListener actionListener) {
		this.btFinalizarCompra.addActionListener(actionListener);
	}

	public void remover(ActionListener actionListener) {
		this.btRemover.addActionListener(actionListener);
	}

	public void voltar(ActionListener actionListener) {
		this.btVoltar.addActionListener(actionListener);
	}

	public void logout(ActionListener actionListener) {
		this.btLogout.addActionListener(actionListener);
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void adicionarLinha(Object[] linha) {

		Object[] linhaFormatada = linha.clone();

		linhaFormatada[2] = String.format("R$ %.2f", ((double) linha[2])).replace(".", ",");
		linhaFormatada[3] = String.format("R$ %.2f", ((double) linha[3])).replace(".", ",");

		modelo.addRow(linhaFormatada);
	}

	public void setLbTotal(String texto) {
		lbTotal.setText(texto);
	}

	public void limparTabela() {
		modelo.setRowCount(0);
	}

	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

}