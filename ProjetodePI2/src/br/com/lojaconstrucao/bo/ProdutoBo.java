package br.com.lojaconstrucao.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.lojaconstrucao.dao.ProdutoDao;
import br.com.lojaconstrucao.modelo.Produto;

public class ProdutoBo {
	ProdutoDao p = new ProdutoDao();
	
	public void cadastrarProduto(Produto produto){
		p.cadastrarProduto(produto);
	}
	
	public List<Produto> obterTodosProdutos(){
		return p.obterTodosProdutos();
	}
	
	public void alterarProduto(Produto produto){
		p.alterarProduto(produto);
	}
	
	public void removerProduto(int id){
		p.removerProduto(id);
	}

	public Produto obterPorId(int id) {
		return p.obterPorId(id);
	}
	
	public void alterarQuantProduto(int id, String nome){
			p.alterarQuantProduto(id, nome);
	}
}
