package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ClienteBo;
import br.com.lojaconstrucao.bo.GerenteBo;
import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.bo.VendasBo;
import br.com.lojaconstrucao.bo.funcionarioBo;
import br.com.lojaconstrucao.modelo.Cliente;
import br.com.lojaconstrucao.modelo.Funcionario;
import br.com.lojaconstrucao.modelo.Produto;
import br.com.lojaconstrucao.modelo.Vendas;
import br.com.lojaconstrucao.util.MoedaUtil;

public class vendasServlet extends HttpServlet {
	Cliente c = new Cliente();
	Funcionario f = new Funcionario();
	Produto p = new Produto();
	ClienteBo cbo = new ClienteBo();
	funcionarioBo fbo = new funcionarioBo();
	ProdutoBo pbo = new ProdutoBo();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] testes;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vendas venda = new Vendas();
		VendasBo bo = new VendasBo();
		String acao = req.getParameter("acao");
		GerenteBo gbo = new GerenteBo();
		
		if(acao.equals("finalizarVenda")){
			int idVenda = bo.pegarUltimoId();
			double valorTotal= Double.parseDouble(req.getParameter("valorTotal"));
			double troco = 0;
			
			if(req.getParameter("formaPagamento").equals("dinheiro")){
				double valorPago = Double.parseDouble(req.getParameter("valor"));
				if(valorPago < valorTotal){
					
					resp.sendRedirect("/ProjetodePI2/Menu/menuVendaFinalizada.jsp");
				}else{
					troco = valorPago - valorTotal;
					req.getSession().setAttribute("cliente", req.getParameter("cliente"));
					req.getSession().setAttribute("func", req.getParameter("funcionario"));
					req.getSession().setAttribute("tipoDePagamento", req.getParameter("formaPagamento"));
					req.getSession().setAttribute("valorPago", MoedaUtil.formatarMoeda(valorPago));
					req.getSession().setAttribute("valorTotal", MoedaUtil.formatarMoeda(valorTotal));
					req.getSession().setAttribute("troco", MoedaUtil.formatarMoeda(troco));
					req.getSession().setAttribute("venda",bo.obterUltimaVenda(idVenda));
					req.getSession().setAttribute("quantParcela", 0);
					resp.sendRedirect("/ProjetodePI2/Menu/menuRelatorioVenda.jsp");
				}
			}
			
			if(req.getParameter("formaPagamento").equals("credito")){
				int quantidadeParcela = Integer.parseInt(req.getParameter("quantParcelas"));
				req.getSession().setAttribute("quantParcela", req.getParameter("quantParcelas"));
				req.getSession().setAttribute("cliente", req.getParameter("cliente"));
				req.getSession().setAttribute("func", req.getParameter("funcionario"));
				req.getSession().setAttribute("tipoDePagamento", req.getParameter("formaPagamento"));
				req.getSession().setAttribute("valorPago", MoedaUtil.formatarMoeda(valorTotal/quantidadeParcela));
				req.getSession().setAttribute("valorTotal", MoedaUtil.formatarMoeda(valorTotal));
				req.getSession().setAttribute("troco", MoedaUtil.formatarMoeda(troco));
				req.getSession().setAttribute("venda",bo.obterUltimaVenda(idVenda));
				resp.sendRedirect("/ProjetodePI2/Menu/menuRelatorioVenda.jsp");
			}
			
			if(req.getParameter("formaPagamento").equals("debito")){
				req.getSession().setAttribute("cliente", req.getParameter("cliente"));
				req.getSession().setAttribute("func", req.getParameter("funcionario"));
				req.getSession().setAttribute("tipoDePagamento", req.getParameter("formaPagamento"));
				req.getSession().setAttribute("valorPago", MoedaUtil.formatarMoeda(valorTotal));
				req.getSession().setAttribute("valorTotal",MoedaUtil.formatarMoeda(valorTotal));
				req.getSession().setAttribute("troco", MoedaUtil.formatarMoeda(troco));
				req.getSession().setAttribute("venda",bo.obterUltimaVenda(idVenda));
				req.getSession().setAttribute("quantParcela", 0);
				resp.sendRedirect("/ProjetodePI2/Menu/menuRelatorioVenda.jsp");
			}
		}
		
		if(acao.equals("mostrarUmFuncionario")){
			if(req.getParameter("id") == "" || req.getParameter("id") == null){
				req.getSession().setAttribute("func", fbo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaErro.jsp");
			}else{
				
				req.getSession().setAttribute("func", fbo.obterFuncionarioId(Integer.parseInt(req.getParameter("id"))));
				req.getSession().setAttribute("clientes", cbo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaCliente.jsp");
			}
		}
		
		if(acao.equals("mostrarUmFuncionariopnome")){
			req.getSession().setAttribute("func", req.getParameter("id"));
			req.getSession().setAttribute("clientes", cbo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVendaCliente.jsp");
		}
		
		if(acao.equals("mostrarGerenteNome")){
			req.getSession().setAttribute("func", gbo.pegarNomeGerente() );
			req.getSession().setAttribute("clientes", cbo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVendaCliente.jsp");	
		}
		
		if(acao.equals("mostrarCliente")){
			if(req.getParameter("id") == "" || req.getParameter("id") == null){
				req.getSession().setAttribute("func", req.getParameter("id"));
				req.getSession().setAttribute("clientes", cbo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaClienteErro.jsp");
		}else{
			req.getSession().setAttribute("cliente",cbo.obterClienteId(Integer.parseInt(req.getParameter("id"))));
			req.getSession().setAttribute("produtos",pbo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/Menu/menuRealizarVenda.jsp");
			
			}
		}
		
		if(acao.equals("realizarVenda")){
			int idVenda = bo.pegarUltimoId() + 1;
			double precoTotal = 0;
			String[] quant = req.getParameterValues("quant");
			String[] id = req.getParameterValues("selecionado");
			List<String> escolhidos = new ArrayList<>();
			
			for(int i  = 0; i<quant.length;i++){
				String string = quant[i];
				if(string!=null && string!="" ){
					escolhidos.add(string);
				}
			}
			for(String s : quant){
				System.out.println(s);
			}
			
			for(int i = 0; i<escolhidos.size(); i++){
				if(Integer.parseInt(escolhidos.get(i)) > bo.obterQuantidadePorId(Integer.parseInt(id[i]))){
					req.getSession().setAttribute("nomecliente",req.getParameter("id"));
					req.getSession().setAttribute("nomevendedor",req.getParameter("id"));
					req.getSession().setAttribute("produtos",pbo.obterTodosProdutos());
					resp.sendRedirect("/ProjetodePI2/Menu/menuRealizarVendaErro.jsp");
					return;
				}
			}
			
			for(int i = 0; i<id.length; i++){
				p = pbo.obterPorId(Integer.parseInt(id[i]));
			
				venda.setIdVenda(idVenda);
				venda.setNomeProduto(p.getNome());
				venda.setNomeCliente(req.getParameter("nomecliente"));
				venda.setNomeVendedor(req.getParameter("nomevendedor"));
				venda.setQuantidade(Integer.parseInt(escolhidos.get(i)));
				venda.setPrecoUni(p.getPreço());
				venda.setPrecoTotal(p.getPreço()*Integer.parseInt(escolhidos.get(i)));
				precoTotal = precoTotal + venda.getPrecoTotal();
				int quantFinal = bo.obterQuantidadePorId(Integer.parseInt(id[i])) - Integer.parseInt(escolhidos.get(i));
				pbo.alterarQuantProduto(quantFinal, p.getNome());
				System.out.println("QUANTIDADE:"+quantFinal +"noem" + p.getNome());
				bo.cadastrarVenda(venda);
			}
			
			req.getSession().setAttribute("venda",bo.obterUltimaVenda(idVenda));
			req.getSession().setAttribute("precototal", precoTotal);
			req.getSession().setAttribute("func",req.getParameter("nomevendedor"));
			req.getSession().setAttribute("cliente",req.getParameter("nomecliente"));
			
			resp.sendRedirect("/ProjetodePI2/Menu/menuVendaFinalizada.jsp");
			
		}
		
		if(acao.equals("listarVoltar")){
			req.getSession().setAttribute("func", fbo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVenda.jsp");
		}
	}
}
