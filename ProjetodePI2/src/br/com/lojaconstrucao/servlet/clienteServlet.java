package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ClienteBo;
import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.bo.funcionarioBo;
import br.com.lojaconstrucao.modelo.Cliente;


public class clienteServlet extends HttpServlet{

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
		Cliente cliente = new Cliente();
		ClienteBo bo = new ClienteBo();
		String acao = req.getParameter("acao");
		
		if(acao.equals("cadastrarCliente")){       	
			if(req.getParameter("nome") == "" || req.getParameter("email") == "" || req.getParameter("telefone") == ""){
		            resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/adicionarClienteErro.jsp");
			}else{
				cliente.setNome(req.getParameter("nome"));
				cliente.setEmail(req.getParameter("email"));
				cliente.setTelefone(req.getParameter("telefone"));
				bo.adicionarCliente(cliente); 
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/adicionarClienteSucesso.jsp");
				
			}
		}
		
		if(acao.equals("removerCliente")){
			if(req.getParameter("id") == null || req.getParameter("id") == ""){
				req.getSession().setAttribute("clientes", bo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/removerClienteErro.jsp");
			}else{
				bo.removerCliente(Integer.parseInt(req.getParameter("id")));
				req.getSession().setAttribute("clientes", bo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/removerClienteSucesso.jsp");	
				}	
				
		}
		
		if(acao.equals("alterarCliente")){
			if(req.getParameter("id") == "" || req.getParameter("nome") == "" || req.getParameter("telefone") == "" || req.getParameter("email") == ""){
				req.getSession().setAttribute("clientes", bo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/modificarClienteErro.jsp");
			}else{
				
				cliente.setId(Integer.parseInt(req.getParameter("id")));
				cliente.setNome(req.getParameter("nome"));
				cliente.setTelefone(req.getParameter("telefone"));
				cliente.setEmail(req.getParameter("email"));
				
				bo.alterarCliente(cliente);
				req.getSession().setAttribute("clientes", bo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/modificarClienteSucesso.jsp");
			}
			}
			
        
		if(acao.equals("listarConsultarCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/consultarClientes.jsp");
		}

		if(acao.equals("listarAlterarCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/modificarCliente.jsp");
		}
		
		if(acao.equals("listarRemoverCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/removerCliente.jsp");
		}
		
	
		
		
		
		/*
		
		
		
		
		
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
			
		}*/
	}
}

 