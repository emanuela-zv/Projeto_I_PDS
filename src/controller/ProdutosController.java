package controller;

import java.util.List;

import model.Insumos;
import model.InsumosDAO;
import view.CadastroProdutos;
import view.Produtos;

public class ProdutosController {
	
	private Produtos produtos;
	private InsumosDAO insumosDao;
	private Navegador navegador;
	private CadastroProdutos cadastroProdutos;
	
	
	public ProdutosController(Produtos produtos, InsumosDAO insumosDao, Navegador navegador,
			CadastroProdutos cadastroProdutos) {
		super();
		this.produtos = produtos;
		this.insumosDao = insumosDao;
		this.navegador = navegador;
		this.cadastroProdutos = cadastroProdutos;
		
		this.produtos.voltar(e ->{
			this.navegador.navegar("CADASTRO_PRODUTOS");
		});
		
		carregarTabela();
		
	}
		
	    public void carregarTabela() {
	    	
	    	produtos.limparTabela();

	        List<Insumos> lista = insumosDao.listarInsumos();

	        for (Insumos novoInsumo : lista) {

	            produtos.getModelo().addRow(new Object[]{
	            		novoInsumo.getNome(),
	            		novoInsumo.getMarca(),
	            		novoInsumo.getFornecedora(),
	            		novoInsumo.getCodigoBarras(),
	            		novoInsumo.getQuantidade(),
	            		novoInsumo.getValor(),
	            		novoInsumo.getDescricao()
	            });
	        }
	    }
	}