package controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Insumos;
import model.InsumosDAO;
import view.CadastroInsumos;
import view.CadastroUsuario;
import view.Carrinho;
import view.Compra;

public class CarrinhoController {
	
	private CadastroUsuario cadastroUsuario;
	private Carrinho carrinho;
	private InsumosDAO insumosDao;
	private Compra compra;
	private Navegador navegador;
	private List<Object[]> itensCarrinho = new ArrayList<>();
	
	public CarrinhoController(CadastroUsuario cadastroUsuario, Carrinho carrinho, InsumosDAO insumosDao,
			Compra compra, Navegador navegador) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.carrinho = carrinho;
		this.insumosDao = insumosDao;
		this.compra = compra;
		this.navegador = navegador;
		
		this.carrinho.voltar(e ->{
			navegador.navegar("COMPRA");
		});
		
		this.carrinho.remover(e -> {


            int linha = carrinho.getLinhaSelecionada();

            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um item!");
                return;
            }

            itensCarrinho.remove(linha);
            carrinho.getModelo().removeRow(linha);

            atualizarTotalCarrinho();
        });

		
		this.carrinho.finalizar(e ->{
			JOptionPane.showMessageDialog(null, "Compra finalizada!");
		});
		
		this.carrinho.notaFiscal(e -> {
			

		    String listaProdutos = "";
		    double total = 0;


		    for (Object[] item : itensCarrinho) {
		        String nome = (String) item[0];      // Posição do Nome
		        double subtotal = (double) item[3];  // Posição do Valor
		        
		        listaProdutos += "• " + nome + "\n";
		        total += subtotal;
		    }


		    String Nota = 
		        "Cliente: " + cadastroUsuario.getTfNome().getText() +
		        "\nCPF: " + cadastroUsuario.getTfCpf().getText() +
		        "\nProdutos:\n" + listaProdutos +
		        "\nTotal: R$ " + String.format("%.2f", total);


		    JOptionPane.showMessageDialog(null, Nota, "Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
			
		});
	}
	
    public void adicionarItem(String produto, int qtd, double valorUnitario) {

        double subtotal = qtd * valorUnitario;

        Object[] linha = {produto, qtd, valorUnitario, subtotal};

        itensCarrinho.add(linha);
        carrinho.adicionarLinha(linha);

        atualizarTotalCarrinho();
    }
	
    public void atualizarTotalCarrinho() {

        double total = 0;

        for (Object[] item : itensCarrinho) {
            total += (double) item[3];
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
	

}
