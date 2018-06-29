<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../resource/css/bootstrap.min.css"/>
<title>Comercial Diniz</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
				<h1>Gerenciamento do Sistema</h1>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Gerente/gerenciarGerente.jsp" method="post">
						<button class="btn btn-primary" type="submit">Alterar Gerente</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Produtos/gerenciarProdutos.jsp" method="post">
						<button class="btn btn-primary" type="submit">Gerenciar Produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Clientes/gerenciarCliente.jsp" method="post">
						<button class="btn btn-primary" type="submit">Gerenciar Clientes</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">
						<button class="btn btn-primary" type="submit">Gerenciar Funcion�rios</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/vendas" method="post">
						<input type="hidden" name="acao" value="mostrarGerenteNome">
						<button class="btn btn-primary" type="submit">Realizar venda</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/menu.jsp" method="post">
						<button class="btn btn-primary" type="submit">Voltar</button>
				</form>
				
				<br />
		</div>
	</div>
</body>
</html>