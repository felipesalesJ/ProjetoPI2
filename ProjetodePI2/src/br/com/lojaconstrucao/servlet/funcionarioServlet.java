package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ClienteBo;
import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.bo.funcionarioBo;
import br.com.lojaconstrucao.modelo.Funcionario;
import br.com.lojaconstrucao.modelo.Produto;

public class funcionarioServlet extends HttpServlet{

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
        Funcionario func = new Funcionario();
        funcionarioBo bo = new funcionarioBo();
		String acao = req.getParameter("acao");

		if(acao.equals("cadastrarFuncionario")){       	
			if(req.getParameter("nome") == "" || req.getParameter("telefone") == "" || req.getParameter("email") == ""){
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/adicionarFuncionarioErro.jsp");
			}else{
				func.setNome(req.getParameter("nome"));
				func.setTelefone(req.getParameter("telefone"));
				func.setEmail(req.getParameter("email"));
				func.setSalario(Double.parseDouble(req.getParameter("salario")));
				
				bo.adicionarFuncionario(func);
				
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/adicionarFuncionarioSucesso.jsp");
				
			}
		}
		
		if(acao.equals("alterarFuncionario")){
			if(req.getParameter("nome") == "" || req.getParameter("telefone") == "" || req.getParameter("salario") == "" || req.getParameter("email") ==""){
				req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/modificarFuncionarioErro.jsp");
			}else{
				func.setId(Integer.parseInt(req.getParameter("id")));
				func.setNome(req.getParameter("nome"));
				func.setTelefone(req.getParameter("telefone"));
				func.setEmail(req.getParameter("email"));
				func.setSalario(Double.parseDouble(req.getParameter("salario")));
				
				bo.modificarFuncionario(func);
				req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/modificarFuncionarioSucesso.jsp");
				
			}
		}
		
		if(acao.equals("removerFuncionario")){
			if(req.getParameter("id") == "" || req.getParameter("id") == null){
				req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/excluirFuncionariosErro.jsp");
			}else{
				bo.removerFuncionario(Integer.parseInt(req.getParameter("id")));
				req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/excluirFuncionariosSucesso.jsp");				
			}
			
		}	
		
		if(acao.equals("listarConsultarFuncionario")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/consultarFuncionario.jsp");
		}
		
		if(acao.equals("listarAlterarFuncionarios")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/modificarFuncionario.jsp");
		}
		
		if(acao.equals("listarRemoverFuncionario")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/excluirFuncionarios.jsp");
		}
		
		if(acao.equals("listarEscolherfunc")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVenda.jsp");
		}
		
	}
} 