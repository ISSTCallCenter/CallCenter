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

public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Alerta> alertas = new ArrayList<Alerta>();

		alertas = dao.listAlertas();
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));

		RequestDispatcher view = req.getRequestDispatcher("TaccInicio.jsp");
		view.forward(req, resp);
	}
	
}
