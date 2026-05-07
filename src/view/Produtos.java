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
    private JButton btExcluir;
    private boolean editavel = false;
    private boolean valor = false;
    private boolean modoExclusao = false;
    private int linhaSelecionada = -1;
    
    public Produtos() {

        setLayout(new MigLayout("", "[24.00,grow][184.00][230.00][137.00][239.00][grow]", "[grow][grow][][grow]"));
        setBackground(new Color(255, 255, 224));
        
        modelo = new DefaultTableModel(
            new Object[]{"Nome", "Marca", "Fornecedora", "Código", "Quantidade", "Valor", "Descrição"},
            0
        ) {
            public boolean isCellEditable(int row, int column) {
                return editavel;
            }
            
        };
               
        tabelaInsumos = new JTable(modelo);     

        JScrollPane scrollPane = new JScrollPane(tabelaInsumos);
        add(scrollPane, "cell 1 1 4 1,growx,aligny center");
        
        tabelaInsumos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tabelaInsumos.setRowHeight(28);
        tabelaInsumos.setSelectionBackground(new Color(128, 206, 209));
        tabelaInsumos.setSelectionForeground(Color.BLACK);
        
        tabelaInsumos.getTableHeader().setBackground(new Color(95, 158, 160));
        tabelaInsumos.getTableHeader().setForeground(Color.BLACK);
        tabelaInsumos.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 25));
        
                btVoltar = new JButton("Voltar");
                add(btVoltar, "cell 1 2,grow");
                btVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                btVoltar.setBorderPainted(false);
                btVoltar.setBackground(new Color(95, 158, 160));
        
        btSalvar = new JButton("Salvar edições");
        add(btSalvar, "cell 3 2,grow");
        btSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btSalvar.setBorderPainted(false);
        btSalvar.setBackground(new Color(95, 158, 160));

        tabelaInsumos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && modoExclusao) {
                linhaSelecionada = tabelaInsumos.getSelectedRow();
            }
        });
        
        tabelaInsumos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        btExcluir = new JButton("Excluir");
        add(btExcluir, "cell 4 2,grow");
        btExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        btExcluir.setBorderPainted(false);
        btExcluir.setBackground(new Color(95, 158, 160));
        tabelaInsumos.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabelaInsumos.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabelaInsumos.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabelaInsumos.getColumnModel().getColumn(3).setPreferredWidth(130);
        tabelaInsumos.getColumnModel().getColumn(4).setPreferredWidth(130);
        tabelaInsumos.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaInsumos.getColumnModel().getColumn(6).setPreferredWidth(144);
        
        tabelaInsumos.getTableHeader().setReorderingAllowed(false);
        tabelaInsumos.getTableHeader().setResizingAllowed(false);
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

    public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
	}

	public JButton getBtVoltar() {
		return btVoltar;
	}

	public void setBtVoltar(JButton btVoltar) {
		this.btVoltar = btVoltar;
	}

	public JButton getBtExcluir() {
		return btExcluir;
	}

	public void setBtExcluir(JButton btExcluir) {
		this.btExcluir = btExcluir;
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