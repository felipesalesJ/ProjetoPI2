package br.com.lojaconstrucao.bo;

import br.com.lojaconstrucao.dao.GerenteDao;

public class GerenteBo {
	GerenteDao gerenteDao = new GerenteDao();
	
	public boolean validarsenha(String senha){
		return gerenteDao.verificarSenha(senha);
	}
	
	public void alterarNome(String nome){
		gerenteDao.alterarNome(nome);
	}
	
	public void alterarSenha(String senha){
		 gerenteDao.alterarSenha(senha);
	}
	
	public String pegarNomeGerente(){
		return gerenteDao.pegarNomeGerente();
	}
}
