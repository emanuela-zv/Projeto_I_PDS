package view;

import java.awt.Color;
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

    public Produtos() {

        setLayout(new MigLayout("", "[grow][][642.00][][grow]", "[grow][][][grow]"));
        setBackground(new Color(255, 255, 224));
        setPreferredSize(new Dimension(1020,640));
        setMinimumSize(new Dimension(1020, 640));   

        
        modelo = new DefaultTableModel(
            new Object[]{"Nome", "Marca", "Fornecedora", "Código", "Quantidade", "Valor", "Descrição"},
            0
        );

        
        tabelaInsumos = new JTable(modelo);

        JScrollPane scrollPane = new JScrollPane(tabelaInsumos);
        add(scrollPane, "cell 1 1 2 1,grow");

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(95, 158, 160));
        add(panel_1, "cell 1 2,grow");

        btVoltar = new JButton("Voltar");
        btVoltar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
        btVoltar.setBorderPainted(false);
        btVoltar.setBackground(new Color(95, 158, 160));
        panel_1.add(btVoltar);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(95, 158, 160));
        add(panel_1_1, "cell 2 2,grow");

        btSalvar = new JButton("Salvar");
        btSalvar.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
        btSalvar.setBorderPainted(false);
        btSalvar.setBackground(new Color(95, 158, 160));
        panel_1_1.add(btSalvar);
    }

    public DefaultTableModel getModelo() {
        return modelo;
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
}