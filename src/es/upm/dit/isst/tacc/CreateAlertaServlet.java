package es.upm.dit.isst.tacc;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;

public class CreateAlertaServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		
	System.out.println("Creando nueva alerta");
	
	String tipo = "Seguridad";
	String subtipo = "Incendio";
	TaccDAO dao = TaccDAOImpl.getInstance();
	dao.addAlerta(tipo, subtipo);
	//dao.deleteAlerta();
	resp.sendRedirect("/inicio");

	}
}
