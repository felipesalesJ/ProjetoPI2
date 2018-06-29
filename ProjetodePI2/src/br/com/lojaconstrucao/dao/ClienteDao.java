package br.com.lojaconstrucao.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.lojaconstrucao.modelo.Produto;


import br.com.lojaconstrucao.modelo.Cliente;
import br.com.lojaconstrucao.modelo.Funcionario;

public class ClienteDao {
	Cliente cliente = new Cliente();
	
	public void adicionarCliente(Cliente cliente){
		String query = "INSERT INTO clientes(nome,telefone,email) VALUES (?, ?, ?)";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1,cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Cliente> obterTodosClientes(){
		String query = "select * from clientes ORDER BY nome";
		Connection con = new Conexao().obterConexao();
		List<Cliente> clientes = new ArrayList<>();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				clientes.add(cliente);
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return clientes;
	}

	public void alterarCliente(Cliente cliente) {
		String query = "update clientes set nome = ?, telefone = ?, email = ? where id = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4,cliente.getId());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void removerCliente(int id){
		String query = "delete from clientes where id = ?";
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
	
	public String obterCLienteId(int id){
		String query = "select * from clientes where id = "+id;
		Connection con = new Conexao().obterConexao();
		String c = null;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c = rs.getString("nome");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
}
