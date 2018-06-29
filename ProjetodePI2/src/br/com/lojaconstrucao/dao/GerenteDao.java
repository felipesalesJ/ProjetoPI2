package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaconstrucao.modelo.Gerente;

public class GerenteDao {
		Gerente gerente = new Gerente();
	public Boolean verificarSenha(String senha){
		String query = "select * from gerente";
	     Connection con = new Conexao().obterConexao();
	     String sen = null;
	     try{
	         PreparedStatement ps = con.prepareStatement(query);
	         ResultSet rs = ps.executeQuery();
	         while (rs.next()) {
	         sen = rs.getString("senha");
	         	}
		} catch(SQLException e) {
     		e.printStackTrace();
     	}
	     
	     if(senha.equals(sen)){
	    	 return true;
	     }else{
	    	 return false;
	     }
	
	}
	
	public void alterarNome(String nome){
		String query = "update gerente set nome = ?";
        Connection con = new Conexao().obterConexao();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void alterarSenha(String senha){
		String query = "update gerente set senha = ?";
        Connection con = new Conexao().obterConexao();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, senha);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public String pegarNomeGerente(){
		String query = "select nome from gerente";
		Connection con = new Conexao().obterConexao();
		String g = null;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				g = rs.getString("nome");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return g;
	}
}
