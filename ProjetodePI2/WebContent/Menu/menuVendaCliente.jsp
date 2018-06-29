<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../resource/css/bootstrap.min.css"/>
<title>Realizar Vendas</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Vendedor <%=session.getAttribute("func")%></h1>
			<h3>O cliente ja tem cadastro?</h3>
				<form action="/ProjetodePI2/vendas" method="post">
				<input type="hidden" name="acao" value="mostrarCliente">		
			<table class="table table-hover">
		<thead class = "thead-dark">
			<tr>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
				<th>SELECIONAR</th>
				
			</tr>
		</thead>
		<% for(Cliente clientes: (List<Cliente>) session.getAttribute("clientes")){ %>
		
		<tbody>
			<tr>
				<td><%=clientes.getNome()%></td>
				<td><%=clientes.getTelefone()%></td>
				<td><%=clientes.getEmail()%></td>
				<td><input type="radio" name = "id" value=<%=clientes.getId()%> /></td>
			</tr>
		</tbody>
		<%}%>
		
			</table>
						<button class="btn btn-primary" type="submit" name="Submit">Entrar</button><br />
						</form>
				<br />
			<hr>
			<h3>Não?</h3>
				
				<form action="/ProjetodePI2/gerenciarSistema/Clientes/adicionarCliente.jsp" method="post">
				<button class="btn btn-primary" type="submit" name="Submit">Cadastrar Cliente</button>
				</form>
				<br/>
				<form action="/ProjetodePI2/vendas" method="post">
				<input type="hidden" name="acao" value="listarVoltar">
				<button class="btn btn-primary" type="submit" name="Submit">Voltar</button>
				</form>
				<br />
		</div>
	</div>
</body>
</html>