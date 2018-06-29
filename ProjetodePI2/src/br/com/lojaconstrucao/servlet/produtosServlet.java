package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.modelo.Produto;

public class produtosServlet extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produto produto = new Produto();
        ProdutoBo bo = new ProdutoBo();
		String acao = req.getParameter("acao");
        
		if(acao.equals("cadastrarProduto")){       	
			if(req.getParameter("nome") == "" || req.getParameter("Quantidade") == "" || req.getParameter("Preço") == "" ){
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/produtoInvalido.jsp");
			}else{
				produto.setNome(req.getParameter("nome"));
	            produto.setQuant(Integer.parseInt(req.getParameter("Quantidade")));
	            produto.setPreço(Double.parseDouble(req.getParameter("Preço")));
	            
	            bo.cadastrarProduto(produto);
	            resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/produtoAdicionado.jsp");
			}       
		}
		
		if(acao.equals("alterarProduto")){
			if(req.getParameter("id") == "" || req.getParameter("nome") == "" || req.getParameter("quantidade") == "" || req.getParameter("valor") == ""){
				req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/alterarProdutoErro.jsp");
			}else{
				produto.setId(Integer.parseInt(req.getParameter("id")));
				produto.setNome(req.getParameter("nome"));
				produto.setQuant(Integer.parseInt(req.getParameter("quantidade")));
				produto.setPreço(Double.parseDouble(req.getParameter("valor")));
				
				bo.alterarProduto(produto);
				req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/alterarProdutoSucesso.jsp");
			
			}
		}
		
		if(acao.equals("removerProduto")){
			System.out.println("AKI 1");
			if(req.getParameter("id") == null){
				System.out.println("AKI 2");
				req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutosErro.jsp");
			}else{
				bo.removerProduto(Integer.parseInt(req.getParameter("id")));
				req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutosSucesso.jsp");
			}
		}
		
		if(acao.equals("listarAlteraProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/alterarProdutos.jsp");
		}
		
		if(acao.equals("listarConsultarProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/consultarProdutos.jsp");
		}	
		
		if(acao.equals("listarExcluirProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutos.jsp");
			
		}
	}
}

 