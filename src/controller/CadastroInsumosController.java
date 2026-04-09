package controller;

import model.Insumos;
import model.InsumosDAO;
import view.CadastroInsumos;

public class CadastroInsumosController {

	private CadastroInsumos cadastroInsumos;
	private Navegador navegador;
	private InsumosDAO insumosDao;
	private Insumos novo;

	public CadastroInsumosController(CadastroInsumos cadastroInsumos, Navegador navegador, InsumosDAO insumosDao) {
		super();
		this.cadastroInsumos = cadastroInsumos;
		this.navegador = navegador;
		this.insumosDao = insumosDao;
		
		this.cadastroInsumos.cadastrar(e -> {
			
            try {
            	
                Insumos novo = new Insumos(
                		
                    
                    cadastroInsumos.getTfNome().getText(),
                    cadastroInsumos.getTfMarca().getText(),
                    cadastroInsumos.getTfFornecedora().getText(),
                    cadastroInsumos.getTfDescricao().getText(),
                    cadastroInsumos.getTfValor().getText()),
                    cadastroInsumos.getTfQuantidade().getText(),
                    cadastroInsumos.getTfCodigoBarras().getText()
                );

               
				insumosDao.adicionarInsumo(novo);

                tabelaInsumos.atualizarTabela(insumosDao.listarInsumos());

                // Navegar para a tabela
                navegador.navegar("TABELA_INSUMOS");

                // limpar campos
                cadastroInsumos.getTfCodigoBarras().setText("");
                cadastroInsumos.getTfNome().setText("");
                cadastroInsumos.getTfMarca().setText("");
                cadastroInsumos.getTfFornecedora().setText("");
                cadastroInsumos.getTfQuantidade().setText("");
                cadastroInsumos.getTfValor().setText("");

            } catch (NumberFormatException ex) {
                System.out.println("Erro: Campos quantidade ou valor inválidos!");
            }
        });
        
    	this.cadastroInsumos.voltar(e->{this.navegador.navegar("CADASTRO_PRODUTOS");});}

}
