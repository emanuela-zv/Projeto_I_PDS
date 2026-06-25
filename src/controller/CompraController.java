package controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import model.Insumos;
import model.InsumosDAO;
import view.Carrinho;
import view.Compra;

public class CompraController {

	private Compra compra;
	private InsumosDAO insumosDao;

	private CarrinhoController carrinhoController;
	private Carrinho carrinho;
	private Navegador navegador;
	private LoginController loginController;

	public CompraController(Compra compra, Carrinho carrinho, Navegador navegador,
			InsumosDAO insumosDao, CarrinhoController carrinhoController, LoginController loginController) {
		this.compra = compra;
		this.carrinho = carrinho;

		this.navegador = navegador;
		this.insumosDao = insumosDao;
		this.carrinhoController = carrinhoController;
		this.loginController = loginController;
		
		this.compra.logout(e -> {
			loginController.logout();			
		});

		carregarProdutosDoEstoque();
		
		this.compra.getCbInsumos().addActionListener(e -> {
			atualizarLogicaPorProduto();
		});

		
		this.compra.spinnerQuant.addChangeListener(e -> {
			recalcularPrecoTotal();
		});

		
		this.compra.adicionar(e -> {
			
			try {
		        Insumos selecionado = (Insumos) compra.getCbInsumos().getSelectedItem();
		    int qtd = (int) compra.spinnerQuant.getValue();

		    if (selecionado == null) { return;}

		    carrinhoController.adicionarItem(
		            selecionado.getCodigoBarras(),
		            selecionado.getNome(),
		            qtd,
		            selecionado.getValor()
		    );
		    
		    int novaQuantidade = selecionado.getQuantidade() - qtd;
		    selecionado.setQuantidade(novaQuantidade);
		    compra.configurarLimiteEstoque(novaQuantidade);
		    		    
		    compra.getCbInsumos().setSelectedIndex(0);
		    compra.spinnerQuant.setValue(1);
		    compra.atualizarValorTotal(0);
		    compra.getCbInsumos().requestFocus();

		    JOptionPane.showMessageDialog(compra, "Adicionado ao carrinho!");
		    
		    selecionado.setQuantidade(novaQuantidade);

		    
		    } catch (Exception ex) {

		        JOptionPane.showMessageDialog(compra,
		                "Erro ao adicionar produto: " + ex.getMessage(),
		                "Erro",
		                JOptionPane.ERROR_MESSAGE);
		    }
		    
		});

		this.compra.carrinho(e -> {
			navegador.navegar("CARRINHO");
			
		});
		
		this.compra.detalhes(e -> {
			mostrarDetalhes();
		});		
		
		atualizarLogicaPorProduto();
	}

	public void carregarProdutosDoEstoque() {
		List<Insumos> lista = insumosDao.listarInsumos();
		compra.getCbInsumos().removeAllItems();
		for (Insumos i : lista) {
			compra.getCbInsumos().addItem(i);
		}
	}

	private void atualizarLogicaPorProduto() {
		Insumos selecionado = (Insumos) compra.getCbInsumos().getSelectedItem();
		if (selecionado != null) {
			// Define o máximo do Spinner com base no estoque real do banco
			compra.configurarLimiteEstoque(selecionado.getQuantidade());
			// Calcula o preço inicial (para 1 unidade)
			recalcularPrecoTotal();
		}
	}

	private void recalcularPrecoTotal() {
		Insumos selecionado = (Insumos) compra.getCbInsumos().getSelectedItem();
		if (selecionado != null && selecionado.getQuantidade() > 0) {
			int qtd = (int) compra.spinnerQuant.getValue();
			double total = selecionado.getValor() * qtd;
			compra.atualizarValorTotal(total);
		}
	}

	private void mostrarDetalhes() {
		Insumos insumo = (Insumos) compra.getCbInsumos().getSelectedItem();
		if (insumo != null) {
			String mensagem = "Nome: " + insumo.getNome() + "\nMarca: " + insumo.getMarca() + "\nPreço: R$ "
					+ insumo.getValor() + "\nDescrição: " + insumo.getDescricao() + "\nCódigo de Barras: "
					+ insumo.getCodigoBarras();

			JOptionPane.showMessageDialog(null, mensagem, "Detalhes do produto", 1);
		}
	}
	
}