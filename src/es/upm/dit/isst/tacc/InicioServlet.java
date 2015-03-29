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
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
		System.out.println("Inicio servlet");
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Alerta> alertas = new ArrayList<Alerta>();
		
		String geturl = req.getRequestURI();
		System.out.println(geturl);
		String chat = "/alertallega";
		
	
		alertas = dao.listAlertas();

		/*if(geturl.equals(chat)){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wait hecho");
		}*/
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));
		
		RequestDispatcher view = req.getRequestDispatcher("TaccInicio.jsp");
		//resp.setHeader("REFRESH", "30");
		view.forward(req, resp);
		
		
		
	}
	
	
}
