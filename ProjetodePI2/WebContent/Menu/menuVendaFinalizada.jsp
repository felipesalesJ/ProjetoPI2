<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="br.com.lojaconstrucao.util.*" %>
<%@ page import="java.util.*" %>
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
			<form action="/ProjetodePI2/vendas" method="post">
			<input type="hidden" name="acao" value="finalizarVenda">
			<input type="hidden"name="cliente" value=<%=session.getAttribute("cliente") %>>
			<input type="hidden"name="funcionario" value=<%=session.getAttribute("func") %>>
			<br/>
			<table class="table table-hover" >
		<thead class="thead-dark">
			<tr>
				<th>NOME DO PRODUTO</th>
				<th>QUANTIDADE DE PRODUTOS</th>
				<th>PREÇO UNITÁRIO</th>
				<th>PREÇO TOTAL</th>
			</tr>
		</thead>
		<% for(Vendas vendas: (List<Vendas>) session.getAttribute("venda")){ %>
			<input type="hidden"name="vendas" value=<%=session.getAttribute("venda")%>>
		<tbody>
			<tr>
				<td><%=vendas.getNomeProduto()%></td>
				<td><%=vendas.getQuantidade()%></td>
				<td><%=MoedaUtil.formatarMoeda(vendas.getPrecoUni())%></td>
				<td><%=MoedaUtil.formatarMoeda(vendas.getPrecoTotal())%></td>			
			</tr>
		</tbody>
		<%}%>	
		</form>
		</table>
				<h3>VALOR TOTAL:R$ <%=session.getAttribute("precototal")%></h3>
				<input type="hidden"name="valorTotal" value=<%=session.getAttribute("precototal")%>>
		<br/>
				<h2>Tipo de Pagamento</h2>
				<div>
					<div>
						<input type="radio" name="formaPagamento" value="credito"/> Crédito</>
							<select name="quantParcelas" >
								<option value = "1">1 vez</option>
								<option value = "2">2 vezes</option> 
								<option value = "3">3 vezes</option>
								<option value = "4">4 vezes</option> 
								<option value = "5">5 vezes</option>  
							</select>
					</div>
					<input type="radio" name="formaPagamento" value="debito"/> Débito<br />
				<div>
				<input type="radio" name="formaPagamento" value="dinheiro"/> Dinheiro<br />
				R$ <input type="text" name="valor" placeholder= "Valor Pago"/>
				</div>
				</div>
		<br/>
				<button class="btn btn-primary" type="submit" name="Submit">Finalizar Venda</button>
				</form>
		<br/>
		
		<br/>		
				<form action="../menu.jsp" method="post">
						<button class="btn btn-primary" type="submit" name="Submit">Cancelar Compra</button>
					</form>		
	</div>
</div>
</body>
</html>