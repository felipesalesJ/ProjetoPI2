package br.com.lojaconstrucao.modelo;

public class Vendas {
	private int idVenda;
	private String nomeCliente;
	private String nomeVendedor;
	private String nomeProduto;
	private int quantidade;
	private double precoUni;
	private double precoTotal;
//	private double precototalvenda;
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
//	public double getPrecototalvenda() {
//		return precototalvenda;
//	}
//	public void setPrecototalvenda(double precototalvenda) {
//		this.precototalvenda = precototalvenda;
//	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecoUni() {
		return precoUni;
	}
	public void setPrecoUni(double precoUni) {
		this.precoUni = precoUni;
	}
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
