package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class Produtos extends JPanel {

    private JTable tabelaInsumos;
    private JButton btSalvar;
    private JButton btVoltar;
    private DefaultTableModel modelo;
    private JPanel panel_1_2;
    private JButton btExcluir;
    private boolean editavel = false;
    private boolean valor = false;
    private boolean modoExclusao = false;
    private int linhaSelecionada = -1;
    
    public Produtos() {

        setLayout(new MigLayout("", "[grow][137][230.00][137.00][137][grow]", "[grow][][][grow]"));
        setBackground(new Color(255, 255, 224));
        
        modelo = new DefaultTableModel(
            new Object[]{"Nome", "Marca", "Fornecedora", "Código", "Quantidade", "Valor", "Descrição"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return editavel;
            }
            
        };
               
        tabelaInsumos = new JTable(modelo);     

        JScrollPane scrollPane = new JScrollPane(tabelaInsumos);
        add(scrollPane, "cell 1 1 4 1,growx,aligny center");

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(95, 158, 160));
        add(panel_1, "cell 1 2,grow");
        
        tabelaInsumos.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
        tabelaInsumos.setRowHeight(28);
        tabelaInsumos.setSelectionBackground(new Color(128, 206, 209));
        tabelaInsumos.setSelectionForeground(Color.BLACK);
        
        tabelaInsumos.getTableHeader().setBackground(new Color(95, 158, 160));
        tabelaInsumos.getTableHeader().setForeground(Color.BLACK);
        tabelaInsumos.getTableHeader().setFont(new Font("Eras Demi ITC", Font.BOLD, 16));

        btVoltar = new JButton("Voltar");
        btVoltar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
        btVoltar.setBorderPainted(false);
        btVoltar.setBackground(new Color(95, 158, 160));
        panel_1.add(btVoltar);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(95, 158, 160));
        add(panel_1_1, "cell 3 2,grow");
                
        btSalvar = new JButton("Salvar");
        btSalvar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
        btSalvar.setBorderPainted(false);
        btSalvar.setBackground(new Color(95, 158, 160));
        panel_1_1.add(btSalvar);
        
        panel_1_2 = new JPanel();
        panel_1_2.setBackground(new Color(95, 158, 160));
        add(panel_1_2, "cell 4 2,grow");
        
        btExcluir = new JButton("Excluir");
        btExcluir.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
        btExcluir.setBorderPainted(false);
        btExcluir.setBackground(new Color(95, 158, 160));
        panel_1_2.add(btExcluir);

        tabelaInsumos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && modoExclusao) {
                linhaSelecionada = tabelaInsumos.getSelectedRow();
            }
        });
        
        for (int col = 0; col < tabelaInsumos.getColumnCount(); col++) {
            int maxWidth = 0;

            // Header
            Component comp = tabelaInsumos.getTableHeader()
                .getDefaultRenderer()
                .getTableCellRendererComponent(
                    tabelaInsumos,
                    tabelaInsumos.getColumnName(col),
                    false, false, 0, col
                );
            maxWidth = comp.getPreferredSize().width;

            // Linhas
            for (int row = 0; row < tabelaInsumos.getRowCount(); row++) {
                comp = tabelaInsumos.getCellRenderer(row, col)
                    .getTableCellRendererComponent(
                        tabelaInsumos,
                        tabelaInsumos.getValueAt(row, col),
                        false, false, row, col
                    );
                maxWidth = Math.max(maxWidth, comp.getPreferredSize().width);
            }

            tabelaInsumos.getColumnModel().getColumn(col).setPreferredWidth(maxWidth + 20);
        }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
    public JTable getTabelaInsumos() {
        return tabelaInsumos;
    }
    
    public int getLinhaSelecionada() {
        return linhaSelecionada;
    }

    public void voltar(ActionListener actionListener) {
        this.btVoltar.addActionListener(actionListener);
    }

    public void salvar(ActionListener actionListener) {
        this.btSalvar.addActionListener(actionListener);
    }

	public void limparTabela() {
		modelo.setRowCount(0);
	}
	public void setModoEdicao(boolean valor) {
	    this.editavel = valor;
	}
	
    public boolean isEditavel() {
		return editavel;
	}

	public void setEditavel(boolean editavel) {
		this.editavel = editavel;
	}

	public void setModoExclusao(boolean valor) {
        this.modoExclusao = valor;

            linhaSelecionada = -1;
            tabelaInsumos.clearSelection();
    }
	
	public boolean ismodoExclusao() {
		return modoExclusao;
	}
	
	public void excluir(ActionListener actionListener) {
		this.btExcluir.addActionListener(actionListener);
	}

}