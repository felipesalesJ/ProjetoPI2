<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<h1>Gerenciarmento dos Clientes</h1>
				<hr>
				<form action="/ProjetodePI2/cliente" method="post">
						<input type="hidden" name="acao" value="listarAlterarCliente">
						<button class="btn btn-primary" type="submit">Modificar Cliente</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/cliente" method="post">
						<input type="hidden" name="acao" value="listarConsultarCliente">
						<button class="btn btn-primary" type="submit">Consultar Clientes</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/cliente" method="post">
						<input type="hidden" name="acao" value="listarRemoverCliente">
						<button class="btn btn-primary" type="submit">Excluir Clientes</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/gerenciamentosistema.jsp" method="post">
						<button class="btn btn-primary" type="submit">Voltar</button>
				</form>
				
				<br />
		</div>
	</div>
</body>
</html>