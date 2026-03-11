package model;

public class Insumos {
	
	private String nome;
	private String marca;
	private String fornecedora;
	private int quantidade;
	private String descricao;
	private float valor;
	
	public Insumos(String nome, String marca, String fornecedora, int quantidade, String descricao, float valor) {
		
		super();
		this.nome = nome;
		this.marca = marca;
		this.fornecedora = fornecedora;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.valor = valor;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
	
	
	

}
