package es.upm.dit.isst.tacc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;
import es.upm.dit.isst.tacc.model.Alerta;
import es.upm.dit.isst.tacc.model.Evento;
import es.upm.dit.isst.tacc.model.Usuario;

public class HistorialServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Evento> eventos = new ArrayList<Evento>();
		List<Alerta> alertas = new ArrayList<Alerta>();
		alertas = dao.listAlertas();
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));
	
		eventos = dao.listEventos(userId);
		int usuario = userId;

		req.getSession().setAttribute("eventos", new ArrayList<Evento>(eventos));
		req.getSession().setAttribute("usuario", usuario);

		RequestDispatcher view = req.getRequestDispatcher("TaccHistorial.jsp");
		view.forward(req, resp);
		System.out.println("Historial Servlet");
		
		
		
	}
	
	
}