package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Insumos;
import model.InsumosDAO;
import view.CadastroProdutos;
import view.Produtos;

public class ProdutosController {

    private Produtos produtos;
    private InsumosDAO insumosDao;
    private Navegador navegador;
    private CadastroProdutos cadastroProdutos;

    public ProdutosController(Produtos produtos,
                              InsumosDAO insumosDao,
                              Navegador navegador,
                              CadastroProdutos cadastroProdutos) {

        this.produtos = produtos;
        this.insumosDao = insumosDao;
        this.navegador = navegador;
        this.cadastroProdutos = cadastroProdutos;

        
        this.produtos.voltar(e -> {
            navegador.navegar("CADASTRO_PRODUTOS");
        });

        
        this.produtos.salvar(e -> {

            try {
                DefaultTableModel modelo = produtos.getModelo();

                for (int i = 0; i < modelo.getRowCount(); i++) {

                    Insumos ins = new Insumos(null, null, null, null, i, i, i);

                    ins.setNome(modelo.getValueAt(i, 0).toString());
                    ins.setMarca(modelo.getValueAt(i, 1).toString());
                    ins.setFornecedora(modelo.getValueAt(i, 2).toString());
                    ins.setCodigoBarras(Integer.parseInt(modelo.getValueAt(i, 3).toString()));
                    ins.setQuantidade(Integer.parseInt(modelo.getValueAt(i, 4).toString()));
                    ins.setValor(Float.parseFloat(modelo.getValueAt(i, 5).toString()));
                    ins.setDescricao(modelo.getValueAt(i, 6).toString());

                    insumosDao.atualizar(ins);
                }

                produtos.setModoEdicao(false);

                JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");

                carregarTabela();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar alterações!");
            }
        });

        this.produtos.excluir(e -> {

            try {
            	
                int linha = produtos.getLinhaSelecionada();

                if (linha == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha!");
                    return;
                }

                int codigo = Integer.parseInt(
                        produtos.getModelo().getValueAt(linha, 3).toString()
                );

                insumosDao.remover(codigo);

                produtos.setModoExclusao(false);
                carregarTabela();

                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
                produtos.setModoExclusao(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        carregarTabela();
    }

    
    public void carregarTabela() {

        produtos.limparTabela();

        List<Insumos> lista = insumosDao.listarInsumos();

        for (Insumos ins : lista) {

            produtos.getModelo().addRow(new Object[]{
                ins.getNome(),
                ins.getMarca(),
                ins.getFornecedora(),
                ins.getCodigoBarras(),
                ins.getQuantidade(),
                ins.getValor(),
                ins.getDescricao()
            });
        }
    }
}