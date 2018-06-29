package br.com.lojaconstrucao.bo;

import java.util.List;

import br.com.lojaconstrucao.dao.funcionarioDao;
import br.com.lojaconstrucao.modelo.Funcionario;

public class funcionarioBo {
	funcionarioDao dao = new funcionarioDao();
	
	public void adicionarFuncionario(Funcionario funcionario){
		dao.adicionarFuncionario(funcionario);
	}
	
	public List<Funcionario> obterTodosFuncionarios(){
		return dao.obterTodosFuncionarios();
	}
	
	public void modificarFuncionario(Funcionario func){
		dao.modificarFuncionario(func);
	}
	
	public void removerFuncionario(int id){
		dao.removerFuncionario(id);
	}
	
	public String obterFuncionarioId(int id){
		 return dao.obterFuncionarioId(id);
	}
}
