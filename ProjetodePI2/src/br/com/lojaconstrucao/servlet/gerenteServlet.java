package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.GerenteBo;
import br.com.lojaconstrucao.modelo.Gerente;


public class gerenteServlet extends HttpServlet{

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
		Gerente gerente = new Gerente();
        String acao = req.getParameter("acao");
        GerenteBo gerenteBo = new GerenteBo();
		
        if(acao.equals("validarsenha")){
        	if(gerenteBo.validarsenha(req.getParameter("senha")) == true){
					resp.sendRedirect("/ProjetodePI2/gerenciarSistema/gerenciamentosistema.jsp");
				}else{
					resp.sendRedirect("menusenhaincorreta.jsp");
					}
        		}		
		
        if(acao.equals("alterarNome")){
			if(req.getParameter("nome") == ""){
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Gerente/nomeInvalido.jsp");
			}else{
				gerenteBo.alterarNome(req.getParameter("nome"));
				resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Gerente/nomeAlterado.jsp");	
			}	
		}
        
        if(acao.equals("alterarSenha")){
        	if(req.getParameter("senha") == "" || req.getParameter("senha").length() > 6){
        		resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Gerente/senhaInvalida.jsp");
        	}else{
        	gerenteBo.alterarSenha(req.getParameter("senha")) ;
        		resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Gerente/senhaAlterada.jsp");
        		}
        }
    }
}

 