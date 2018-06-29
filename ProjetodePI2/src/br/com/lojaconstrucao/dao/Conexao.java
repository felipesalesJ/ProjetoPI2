package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/comercialdiniz";
    private String user = "root";
    private String password = "1234";

    public Connection obterConexao(){
    	Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
