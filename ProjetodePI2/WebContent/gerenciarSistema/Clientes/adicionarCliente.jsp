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
			<h1>Adicionar Cliente</h1>
			<hr>
				<form action="/ProjetodePI2/cliente" method="post">
						<input type="hidden" name="acao" value="cadastrarCliente">
						<input class="form-control" type="text" name="nome" placeholder="Digite o nome">
						<input class="form-control" type="text" name="telefone"placeholder="Digite o telefone">
						<input class="form-control" type="text" name="email"	placeholder="Digite o email">
						<button class="btn btn-primary" type="submit" name="Submit">Cadastrar</button>
				</form>
				<br/>
				<form action="/ProjetodePI2/vendas" method="post">
				<input type="hidden" name="acao" value="mostrarUmFuncionariopnome">
				<input type="hidden" name="id" value=<%=session.getAttribute("func")%>></input>	
						<button class="btn btn-primary" type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>