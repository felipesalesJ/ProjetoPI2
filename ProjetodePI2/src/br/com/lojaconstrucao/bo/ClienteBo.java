package br.com.lojaconstrucao.bo;

import java.util.List;

import br.com.lojaconstrucao.dao.ClienteDao;
import br.com.lojaconstrucao.modelo.Cliente;

public class ClienteBo {
	ClienteDao dao = new ClienteDao();
	
	public List<Cliente> listarClientes(){
		return dao.obterTodosClientes();
	}

	public void alterarCliente(Cliente cliente) {
		dao.alterarCliente(cliente);
	}
	
	public void removerCliente(int id){
		dao.removerCliente(id);
	}
	
	public void adicionarCliente(Cliente cliente){
		dao.adicionarCliente(cliente);
	}
	
	public String obterClienteId(int id){
		return dao.obterCLienteId(id);
	}
}
