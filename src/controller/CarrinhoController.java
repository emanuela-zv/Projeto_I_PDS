package controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Insumos;
import model.InsumosDAO;
import model.Usuarios;
import view.CadastroInsumos;
import view.CadastroUsuario;
import view.Carrinho;
import view.Compra;

public class CarrinhoController {

	private Usuarios usuarios;
	private Carrinho carrinho;
	private InsumosDAO insumosDao;
	private Compra compra;
	private Navegador navegador;
	private LoginController loginController;
	private List<Object[]> itensCarrinho = new ArrayList<>();

	public CarrinhoController(Carrinho carrinho, InsumosDAO insumosDao, Compra compra, Navegador navegador) {
		super();
		this.carrinho = carrinho;
		this.insumosDao = insumosDao;
		this.compra = compra;
		this.navegador = navegador;

		this.carrinho.logout(e -> {
			if (loginController != null) {
				loginController.logout();
			}
		});

		this.carrinho.voltar(e -> {
			navegador.navegar("COMPRA");
		});

		this.carrinho.remover(e -> {

			int linha = carrinho.getLinhaSelecionada();

			if (linha == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um item!");
				return;
			}

			try {
				itensCarrinho.remove(linha);
				carrinho.getModelo().removeRow(linha);

				atualizarTotalCarrinho();
			} catch (IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Erro ao remover item do carrinho.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		});

		this.carrinho.finalizar(e -> {
			JOptionPane.showMessageDialog(null, "Compra finalizada!");
		});

		this.carrinho.notaFiscal(e -> {

			String listaProdutos = "";
			double total = 0;

			try {

				for (Object[] item : itensCarrinho) {
					String nome = (String) item[0]; // Posição do Nome
					double subtotal = (double) item[3]; // Posição do Valor

					listaProdutos += "• " + nome + "\n";
					total += subtotal;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao gerar nota fiscal.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String nomeCliente = "Não informado";
			String cpfCliente = "Não informado";

			if (usuarios != null) {
				nomeCliente = usuarios.getNome();
				cpfCliente = usuarios.getCpf();
			} else {
				JOptionPane.showMessageDialog(null, "Cliente ou CPF não está disponível.");
			}

			String nota = "Cliente: " + nomeCliente + "\nCPF: " + cpfCliente + "\nProdutos:\n" + listaProdutos
					+ "\nTotal: R$ " + String.format("%.2f", total);

			JOptionPane.showMessageDialog(null, nota, "Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);

		});

	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public void limparCarrinho() {
		itensCarrinho.clear();
		carrinho.limparTabela();
		carrinho.setLbTotal("Total: R$ 0,00");
	}

	public void adicionarItem(String produto, int qtd, double valorUnitario) {

		try {

			double subtotal = qtd * valorUnitario;

			Object[] linha = { produto, qtd, valorUnitario, subtotal };

			itensCarrinho.add(linha);

			carrinho.adicionarLinha(linha);

			atualizarTotalCarrinho();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar item.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void atualizarTotalCarrinho() {

		double total = 0;

		try {
			for (Object[] item : itensCarrinho) {
				total += (double) item[3];
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao calcular total.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		carrinho.setLbTotal("Total: " + nf.format(total));
	}

	public void carregarTabela() {

		carrinho.limparTabela();

		for (Object[] item : itensCarrinho) {
			carrinho.getModelo().addRow(item);
		}

		atualizarTotalCarrinho();
	}

	public void setUsuario(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}
