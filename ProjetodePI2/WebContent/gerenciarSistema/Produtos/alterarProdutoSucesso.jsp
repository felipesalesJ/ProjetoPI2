<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../../resource/css/bootstrap.min.css"/>
<title>Alterar Produto</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Alterar Produto</h1>
			<h3>Qual Produto Alterar?</h3>
				<form action="/ProjetodePI2/produto" method="post">
				<input type="hidden" name="acao" value="alterarProduto">
			<table class = "table table-hover">
		<thead class= "thead-dark">
			<tr>
				<th>NOME</th>
				<th>QUANTIDADE</th>
				<th>PREÇO</th>
				<th>SELECIONAR</th>
				
			</tr>
		</thead>
		<% for(Produto produto: (List<Produto>) session.getAttribute("produtos")){ %>
		<tbody>
			<tr>
				<td><%=produto.getNome()%></td>
				<td><%=produto.getQuant()%></td>
				<td><%=produto.getPreço()%></td>
				<td><input type="radio" name = "id" value=<%=produto.getId()%> /></td>
			</tr>
		</tbody>
				<%}%>
			</table>
						<input class="form-control" type="text" name="nome" placeholder="Digite o nome aqui">
						<input class="form-control" type="text" name="quantidade"placeholder="Digite a quantidade aqui">
						<input class="form-control" type="text" name="valor"	placeholder="Digite o novo valor">
						<h6 style="color:green;">Produto Alterado</h6>
						<button class="btn btn-primary" type="submit" name="Submit">Alterar</button>
						</form>
	<br/>
				<form action="/ProjetodePI2/gerenciarSistema/Produtos/gerenciarProdutos.jsp" method="post">			
						<button class="btn btn-primary" type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>