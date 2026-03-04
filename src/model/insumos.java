package model;

public class insumos {
	
	private String nome;
	private String marca;
	private String fornecedora;
	private String descricao;
	private float valor;
	private int quantidade;
	private int codigoBarras;
	
	
	public insumos(String nome, String marca, String fornecedora, String descricao, float valor, int quantidade,
			int codigoBarras) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.fornecedora = fornecedora;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.codigoBarras = codigoBarras;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFornecedora() {
		return fornecedora;
	}
	public void setFornecedora(String fornecedora) {
		this.fornecedora = fornecedora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	

}
