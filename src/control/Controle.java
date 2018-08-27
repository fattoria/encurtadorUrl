package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Url;
import persistence.UrlDao;


@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controle() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("gravar")) {
			gravar(request, response);
		}
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url_longa = request.getParameter("url_longa");
	
		String url_curta = request.getParameter("url_curta");
		
		
		
		try {
			Url	u = new Url(null, url_longa, (new EncurtarUrl().shortURL("url_curta")));
			UrlDao dao = new UrlDao();
			dao.create(u);
			request.setAttribute("msg", "Url Gravada!" + u.getUrl_curta());
		}catch (Exception ex) {
			request.setAttribute("msg", "Error : " + ex.getMessage());
		}finally {
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer cod = new Integer(request.getParameter("id"));
			new UrlDao().delete(cod);
			request.setAttribute("msg", "Dados Excluídos com sucesso");
		}catch (Exception ex) {
			request.setAttribute("msg", "Dados Excluídos com Sucesso");
		}finally {
			listar(request, response);
		}
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			List<Url> lista = new ArrayList<Url>();
			lista = new UrlDao().findAll();
			request.setAttribute("lista", lista);	
		}catch (Exception ex) {
			request.setAttribute("msg", "Error: " + ex.getMessage());
		}finally {
			request.getRequestDispatcher("consulta.jsp").forward(request, response);
		}	
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Url u = new Url();
			u.setId(new Integer(request.getParameter("id")));
			u.setUrl_longa(request.getParameter("url_longa"));
			u.setUrl_curta(request.getParameter("url_curta"));
			new UrlDao().update(u);
			request.setAttribute("msg", "Dados alterados com sucesso!");
		}catch (Exception ex) {
			request.setAttribute("msg", "Error : " + ex.getMessage());
		}finally {
			listar(request, response);
		}
	}
	
	protected void buscarCodigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Url url = new UrlDao().findByCode(new Integer(request.getParameter("id")));
			request.setAttribute("url", url);
		}catch (Exception ex) {
			request.setAttribute("msg", "Error : " + ex.getMessage());
		}finally {
			request.getRequestDispatcher("editar.jsp").forward(request, response);
		}
	}
}
