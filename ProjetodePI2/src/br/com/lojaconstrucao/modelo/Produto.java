package br.com.lojaconstrucao.modelo;

public class Produto {
	private int id;
	private String Nome;
	private int quant;
	private double preço;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", Nome=" + Nome + ", preço=" + preço + "]";
	}
	
}
