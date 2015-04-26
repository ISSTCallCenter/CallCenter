package es.upm.dit.isst.tacc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.tacc.model.Alerta;
import es.upm.dit.isst.tacc.model.Usuario;
import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;

public class UsuariosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		usuarios = dao.listUsuarios();
		List<Alerta> alertas = new ArrayList<Alerta>();
		alertas = dao.listAlertas();
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));
		
		req.getSession().setAttribute("usuarios", new ArrayList<Usuario>(usuarios));
		
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLogoutURL(req.getRequestURI());
		User user = userService.getCurrentUser();
		req.getSession().setAttribute("user", user);
		
		if (user == null){
			url = "/index";
			req.getSession().setAttribute("url", url);
			RequestDispatcher view = req.getRequestDispatcher("TaccApplication.jsp"); 
			view.forward(req, resp);
		}else{
			req.getSession().setAttribute("url", url);
			RequestDispatcher view = req.getRequestDispatcher("TaccUsuarios.jsp");
			view.forward(req, resp);
		}
		
	}
}
