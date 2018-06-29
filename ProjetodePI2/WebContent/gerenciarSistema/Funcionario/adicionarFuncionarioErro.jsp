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
				<h1>Gerenciamento dos Funcionarios</h1>
				<h3>Adicionar Funcionário</h3>
				<form action="/ProjetodePI2/funcionario" method="post">
						<input type="hidden" name="acao" value="cadastrarFuncionario">
						<input class="form-control" type="text" name="nome" placeholder="nome do funcionário">
						<input class="form-control" type="text" name="telefone"placeholder="telefone do funcionário">
						<input class="form-control" type="text" name="email" placeholder="email do funcionário">
						<input class="form-control" type="text" name="salario" placeholder="salário do funcionário">
						<h6 style="color:red;">Funcionário com alguma das caracteristicas em branco</h6>
						<button class="btn btn-primary" type="submit" name="Submit">Cadastrar Funcionário</button>
				</form>
				<br/>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">
					<button class="btn btn-primary" type="submit">Voltar</button>		
				</form>
				
				</div>
	</div>
</body>
</html>