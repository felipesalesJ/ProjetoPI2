<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<%@ page import="br.com.lojaconstrucao.util.*" %>
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
			<h1>Vendedor <%=session.getAttribute("func")%></h1>
			<h2>Cliente <%=session.getAttribute("cliente") %></h2>
			<br/>
			<h3>Relatório da Venda</h3>
			<table class="table table-hover" >
		<thead class="thead-dark">
			<tr>
				<th>PRODUTOS</th>
				<th>QUANTIDADE</th>
				<th>PREÇO UNITÁRIO</th>
				<th>PREÇO TOTAL</th>
			</tr>
		</thead>
		
				<%for(Vendas vendas: (List<Vendas>) session.getAttribute("venda")){ %>
		<tbody>
			<tr>
				<td><%=vendas.getNomeProduto()%></td>
				<td><%=vendas.getQuantidade()%></td>
				<td><%=MoedaUtil.formatarMoeda(vendas.getPrecoUni())%></td>
				<td><%=MoedaUtil.formatarMoeda(vendas.getPrecoTotal())%></td>
			</tr>
		</tbody>
			<%}%>
			<br/>
		</table>
		<table class="table table-hover" >
			<thead class="thead-dark">
			<tr>
				<th>TOTAL</th>
				<th>TIPO DE PAGAMENTO</th>
				<th>QUANTIDADE DE PARCELAS</th>
				<th>VALOR PAGO</th>
				<th>TROCO</th>
			</tr>	
		</thead>
			<th><%=session.getAttribute("valorTotal") %></th>
			<th><%=session.getAttribute("tipoDePagamento") %></th>
			<th><%=session.getAttribute("quantParcela") %></th>
			<th><%=session.getAttribute("valorPago") %></th>
			<th><%=session.getAttribute("troco") %></th>	
		</table>
			<button class="btn btn-primary" onclick="window.print();">Emitir Relatório de Venda</button>
		<br/>
		<br/>
				<form action="../menu.jsp" method="post">
					<button class="btn btn-primary" type="submit" name="Submit">Sair</button>
				</form>		
	</div>
</div>
</body>
</html>