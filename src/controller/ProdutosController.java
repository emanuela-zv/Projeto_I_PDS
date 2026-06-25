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

	public ProdutosController(Produtos produtos, InsumosDAO insumosDao,
			Navegador navegador, CadastroProdutos cadastroProdutos) {

		this.produtos = produtos;
		this.insumosDao = insumosDao;
		this.navegador = navegador;
		this.cadastroProdutos = cadastroProdutos;

		this.produtos.voltar(e -> {
			navegador.navegar("CADASTRO_PRODUTOS");
			produtos.setModoEdicao(false);
			produtos.setModoExclusao(false);
		});

		this.produtos.salvar(e -> {

			if (!produtos.isEditavel()) {
				JOptionPane.showMessageDialog(null,
						"Você não está no modo edição!");
				return;
			}

			try {

				DefaultTableModel modelo = produtos.getModelo();

				List<Insumos> listaBanco = insumosDao.listarInsumos();

				boolean houveAlteracao = false;

				for (int i = 0; i < modelo.getRowCount(); i++) {

					Insumos insBanco = listaBanco.get(i);

					String nome = modelo.getValueAt(i, 0).toString();
					String marca = modelo.getValueAt(i, 1).toString();
					String fornecedora = modelo.getValueAt(i, 2).toString();
					String codigoBarras = modelo.getValueAt(i, 3).toString();
					int quantidade = Integer.parseInt(
							modelo.getValueAt(i, 4).toString());
					float valor = Float.parseFloat(
							modelo.getValueAt(i, 5).toString().replace(",", "."));
					String descricao = modelo.getValueAt(i, 6).toString();

					if (!nome.equals(insBanco.getNome())
							|| !marca.equals(insBanco.getMarca())
							|| !fornecedora.equals(insBanco.getFornecedora())
							|| !codigoBarras.equals(insBanco.getCodigoBarras())
							|| quantidade != insBanco.getQuantidade()
							|| valor != insBanco.getValor()
							|| !descricao.equals(insBanco.getDescricao())) {

						houveAlteracao = true;

						String codigoAntigo = insBanco.getCodigoBarras();

						Insumos ins = new Insumos(
								nome,
								marca,
								fornecedora,
								descricao,
								valor,
								quantidade,
								codigoBarras);

						insumosDao.atualizar(ins, codigoAntigo);
					}
				}

				if (houveAlteracao) {
					JOptionPane.showMessageDialog(null,
							"Alterações salvas com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Nenhuma alteração foi feita.");
				}

				carregarTabela();

			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(null,
						"Erro de formato numérico na tabela!",
						"Erro",
						JOptionPane.ERROR_MESSAGE);

			} catch (Exception ex) {

				ex.printStackTrace();

				JOptionPane.showMessageDialog(null,
						"Erro ao salvar alterações!",
						"Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		this.produtos.excluir(e -> {

			try {

				int linha = produtos.getLinhaSelecionada();

				if (!produtos.ismodoExclusao()) {
					JOptionPane.showMessageDialog(null,
							"Você não está no modo de exclusão.");
					return;
				}

				if (linha == -1) {
					JOptionPane.showMessageDialog(null,
							"Selecione uma linha!");
					return;
				}

				String codigo = produtos.getModelo()
						.getValueAt(linha, 3)
						.toString();

				insumosDao.remover(codigo);

				produtos.setModoExclusao(false);

				carregarTabela();

				JOptionPane.showMessageDialog(null,
						"Excluído com sucesso!");

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

			produtos.getModelo().addRow(new Object[] {
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