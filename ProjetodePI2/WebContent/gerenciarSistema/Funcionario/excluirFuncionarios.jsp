<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../../resource/css/bootstrap.min.css"/>
<title>Comercial Diniz</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Excluir Funcionários</h1>
				<form action="/ProjetodePI2/funcionario" method="post">
						<input type="hidden" name="acao" value="removerFuncionario">
			<table class="table table-hover">
		<thead class = "thead-dark">
			<tr>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
				<th>SALARIO</th>
				<th>SELECIONAR</th>
			</tr>
		</thead>
		<% for(Funcionario funcionario: (List<Funcionario>) session.getAttribute("func")){ %>
		<tbody>
			<tr>
				<td><%=funcionario.getNome()%></td>
				<td><%=funcionario.getTelefone()%></td>
				<td><%=funcionario.getEmail()%></td>
				<td><%=funcionario.getSalario()%></td>
				<td><input type="radio" name = "id" value=<%=funcionario.getId()%> /></td>
			</tr>
		</tbody>
		<%}%>
	</table>
			
		
			<button class ="btn btn-primary" type="submit" name="Submit">Excluir</button>
				</form>
			<br/>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">			
						<button class="btn btn-primary" type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>