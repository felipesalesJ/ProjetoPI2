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
		<h1>Gerenciamento do Sistema</h1>
		<h3>Alterar nome ou senha</h3>
			<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="alterarNome">
						<input type="text" class="form-control" name="nome" placeholder="Digite o novo nome">
						<button class="btn btn-primary" type="submit" name="Submit">Modificar nome</button>
				</form>
				<br />
				
			<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="alterarSenha">
						<input type="password" class="form-control" name="senha" placeholder="Digite o nova senha">
						<button class="btn btn-primary" type="submit" name="Submit">Modificar senha</button>
				</form>
				<br />
				<form action="/ProjetodePI2/gerenciarSistema/gerenciamentosistema.jsp" method="post">
					<button class="btn btn-primary" type="submit">Voltar</button>
				</form>
		</div>
	</div>
</body>
</html>