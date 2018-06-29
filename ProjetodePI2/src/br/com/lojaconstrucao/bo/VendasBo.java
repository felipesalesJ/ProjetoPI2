package br.com.lojaconstrucao.bo;

import java.util.List;

import br.com.lojaconstrucao.dao.VendasDao;
import br.com.lojaconstrucao.modelo.Produto;
import br.com.lojaconstrucao.modelo.Vendas;

public class VendasBo {
	VendasDao dao = new VendasDao();
	public void cadastrarVenda(Vendas venda){
		dao.cadastrarVenda(venda);
	}
	
	public List<Vendas> obterUltimaVenda(int idVenda){
		return dao.obterUltimaVenda(idVenda);
	}
	
	public int pegarUltimoId(){
		
		return dao.pegarUltimoId();
	}
	
	public int obterQuantidadePorId(int id){
		return dao.obterQuantidadePorId(id);
	}
}
