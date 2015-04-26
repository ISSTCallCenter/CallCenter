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

import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;
import es.upm.dit.isst.tacc.model.*;

public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
		System.out.println("Inicio servlet");
		
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Alerta> alertas = new ArrayList<Alerta>();
		
		
		String geturl = req.getRequestURI();
		System.out.println(geturl);
		
		alertas = dao.listAlertas();

		List<Evento> eventos = new ArrayList<Evento>();
	
		eventos = dao.listEventos(2);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios = dao.listUsuarios();

		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLogoutURL(req.getRequestURI());
		User user = userService.getCurrentUser();
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));
		req.getSession().setAttribute("eventos", new ArrayList<Evento>(eventos));
		req.getSession().setAttribute("usuarios", new ArrayList<Usuario>(usuarios));
		
		if (user == null){
			url = "/index";
			req.getSession().setAttribute("url", url);
			RequestDispatcher view = req.getRequestDispatcher("TaccApplication.jsp"); 
			view.forward(req, resp);
		}else{
			req.getSession().setAttribute("url", url);
			RequestDispatcher view = req.getRequestDispatcher("TaccInicio.jsp");
			view.forward(req, resp);
		}
		
	
		
		
		
		
	}
	
	
}
