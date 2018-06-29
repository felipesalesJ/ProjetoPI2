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
				<h1>Gerenciar Produtos</h1>
				<hr>
				<form action="adicionarProdutos.jsp" method="post">
						<input type="hidden" name="acao" value="validarsenha">
						<button class="btn btn-primary" type="submit">Adicionar Produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/produto" method="post">
						<input type="hidden" name="acao" value="listarAlteraProdutos">
						<button class="btn btn-primary" type="submit">Alterar Produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/produto" method="post">
						<input type="hidden" name="acao" value="listarExcluirProdutos">
						<button class="btn btn-primary" type="submit">Excluir produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/produto" method="post">
						<input type="hidden" name="acao" value="listarConsultarProdutos">
						<button class="btn btn-primary" type="submit">Vizualizar Produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/gerenciamentosistema.jsp" method="post">
					<button class="btn btn-primary" type="submit">Voltar</button>
				</form>
				
				</div>
	</div>
</body>
</html>