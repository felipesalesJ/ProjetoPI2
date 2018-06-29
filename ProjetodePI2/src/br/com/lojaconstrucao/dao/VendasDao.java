package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaconstrucao.modelo.Produto;
import br.com.lojaconstrucao.modelo.Vendas;

public class VendasDao {
	public void cadastrarVenda(Vendas venda){
		String query = "INSERT INTO relatoriovendas(idVenda, nomeCliente,vendedor,nomeProduto, quantProduto,precoUNI, precoTOT) VALUES (?, ?, ?, ?,?,?,?)";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setInt(1, venda.getIdVenda());
			ps.setString(2, venda.getNomeCliente());
			ps.setString(3, venda.getNomeVendedor());
			ps.setString(4, venda.getNomeProduto());
			ps.setInt(5, venda.getQuantidade());
			ps.setDouble(6, venda.getPrecoUni());
			ps.setDouble(7, venda.getPrecoTotal());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Vendas> obterUltimaVenda(int idVenda){
		String query = "select * from relatoriovendas where idVenda = "+idVenda;
		Connection con = new Conexao().obterConexao();
		List<Vendas> vendas = new ArrayList<>();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Vendas venda = new Vendas();
				venda.setNomeCliente(rs.getString("nomeCliente"));
				venda.setNomeVendedor(rs.getString("vendedor"));
				venda.setNomeProduto(rs.getString("nomeProduto"));
				venda.setQuantidade(rs.getInt("quantProduto"));
				venda.setPrecoUni(rs.getDouble("precoUNI"));
				venda.setPrecoTotal(rs.getDouble("precoTOT"));
				vendas.add(venda);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return vendas;
	}
	
	public int pegarUltimoId(){
		String query = "select * from relatoriovendas";
		Connection con = new Conexao().obterConexao();
		int idVenda = 0;;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				idVenda = rs.getInt("idVenda");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return idVenda;
	}
	
	public int obterQuantidadePorId(int id){
		String query = "select * from produtos where id = "+id;
		Connection con = new Conexao().obterConexao();
		int quant = 0;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				quant = rs.getInt("quant");
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return quant;
	}
}	
