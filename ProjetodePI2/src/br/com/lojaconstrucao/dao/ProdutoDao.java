package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaconstrucao.modelo.Produto;

public class ProdutoDao {
	Produto produto = new Produto();
	
	public void cadastrarProduto(Produto produto){
		String query = "INSERT INTO produtos(nome,quant,preco) VALUES (?, ?, ?)";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1,produto.getNome());
			ps.setLong(2, produto.getQuant());
			ps.setDouble(3, produto.getPreço());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Produto> obterTodosProdutos(){
		String query = "select * from Produtos ORDER BY nome";
		Connection con = new Conexao().obterConexao();
		List<Produto> produtos = new ArrayList<>();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuant(rs.getInt("quant"));
				produto.setPreço(rs.getDouble("preco"));
				produtos.add(produto);
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return produtos;
	}
	
	public void alterarProduto(Produto produto){
		String query = "update produtos set nome = ?, quant = ?, preco = ? where id = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1, produto.getNome());
			ps.setInt(2, produto.getQuant());
			ps.setDouble(3, produto.getPreço());
			ps.setInt(4,produto.getId());
			ps.executeUpdate();
			ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void alterarQuantProduto(int id, String nome){
		String query = "update produtos set quant = ? where nome = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.executeUpdate();
			ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void removerProduto(int id){
		String query = "delete from produtos where id = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}

	public Produto obterPorId(int id) {
		String query = "select * from produtos where id = "+id;
		Connection con = new Conexao().obterConexao();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				produto.setNome(rs.getString("nome"));
				produto.setId(rs.getInt("id"));
				produto.setPreço(rs.getDouble("preco"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return produto;
	}
}
