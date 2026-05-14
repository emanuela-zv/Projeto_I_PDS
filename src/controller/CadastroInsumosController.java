package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Insumos;
import model.InsumosDAO;
import view.CadastroInsumos;
import view.Produtos;

public class CadastroInsumosController {

	private CadastroInsumos cadastroInsumos;
	private Navegador navegador;
	private InsumosDAO insumosDao;
	private Insumos novoInsumo;
	private Produtos produtos;
	private ProdutosController produtosController;

	public CadastroInsumosController(CadastroInsumos cadastroInsumos, Navegador navegador, InsumosDAO insumosDao,
			Produtos produtos, ProdutosController produtosController ) {
		super();
		this.cadastroInsumos = cadastroInsumos;
		this.navegador = navegador;
		this.insumosDao = insumosDao;
		this.produtos = produtos;
		this.produtosController = produtosController;
		
		this.cadastroInsumos.voltar(e -> {
			this.navegador.navegar("CADASTRO_PRODUTOS");
		});

		this.cadastroInsumos.cadastrar(e -> {
			
			try {
				if (cadastroInsumos.getTfCodigoBarras().getText().isEmpty()
						|| cadastroInsumos.getTfNome().getText().isEmpty()
						|| cadastroInsumos.getTfMarca().getText().isEmpty()
						|| cadastroInsumos.getTfValor().getText().isEmpty()
						|| cadastroInsumos.getTfQuantidade().getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Certifique-se de que os campos de nome, marca, "
							+ "valor, quantidade e código de barras estão preenchidos", "Atenção", 2);
					return;
				}
				
				if (!verificarCodigoBarras(cadastroInsumos.getTfCodigoBarras().getText())) {
					
					Insumos novoInsumo = new Insumos(
							cadastroInsumos.getTfNome().getText(), 
							cadastroInsumos.getTfMarca().getText(),
							cadastroInsumos.getTfFornecedora().getText(), 
							cadastroInsumos.getTfDescricao().getText(),
							Float.parseFloat(cadastroInsumos.getTfValor().getText().replace(",", ".")),
							Integer.parseInt(cadastroInsumos.getTfQuantidade().getText()),
							Integer.parseInt(cadastroInsumos.getTfCodigoBarras().getText()));

					insumosDao.adicionarInsumo(novoInsumo);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
					
					produtosController.carregarTabela();
					limparDados();
					
				} else {
					JOptionPane.showMessageDialog(null, "Código de barras já cadastrado! \n Caso queira utilizá-lo, você deve voltar e clicar em 'editar'", 
							"Atenção", 2);
				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Valores numéricos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}); 
	} 

	private boolean verificarCodigoBarras(String codigoBarrasDigitado) {
		List<Insumos> listaInsumos = insumosDao.listarInsumos();
		for (Insumos i : listaInsumos) {
			if (String.valueOf(i.getCodigoBarras()).equals(codigoBarrasDigitado)) {
				return true;
			}
		}
		return false;
		
	}

	public void limparDados() {
		cadastroInsumos.getTfCodigoBarras().setText("");
		cadastroInsumos.getTfNome().setText("");
		cadastroInsumos.getTfMarca().setText("");
		cadastroInsumos.getTfFornecedora().setText("");
		cadastroInsumos.getTfQuantidade().setText("");
		cadastroInsumos.getTfValor().setText("");
		cadastroInsumos.getTfDescricao().setText("");
	}
}