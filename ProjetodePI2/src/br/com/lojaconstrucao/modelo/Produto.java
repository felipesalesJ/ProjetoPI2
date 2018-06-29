package br.com.lojaconstrucao.modelo;

public class Produto {
	private int id;
	private String Nome;
	private int quant;
	private double pre�o;
	
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
	public double getPre�o() {
		return pre�o;
	}
	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", Nome=" + Nome + ", pre�o=" + pre�o + "]";
	}
	
}
