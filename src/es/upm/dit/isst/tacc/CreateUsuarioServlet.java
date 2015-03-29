package es.upm.dit.isst.tacc;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;


public class CreateUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		
	System.out.println("Creando nuevo usuario");
	
	int userId = 2;
	
	String nombre = "Juan Carlos";
	String primApellido = "Yelmo";
	String segApellido = "Garcia";
	TaccDAO dao = TaccDAOImpl.getInstance();
	dao.addUsuario(userId, nombre, primApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido);
	dao.addUsuario(1, nombre, primApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido, segApellido, segApellido,
			segApellido, segApellido, segApellido, segApellido);
	
	
	dao.addEvento(userId, primApellido, userId, userId, userId, userId, false, userId, userId, false, false, false, userId, userId, userId);
	
	resp.sendRedirect("/usuarios");
	}

}