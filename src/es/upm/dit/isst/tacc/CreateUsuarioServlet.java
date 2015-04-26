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
	
	
	//CREACION USUARIO 1 - YELMO
	int userIdJCY = 1;
	double latitudJCY = 40.488468;
	double longitudJCY = -3.885330;
	String nombreJCY = "Juan Carlos";
	String primerApellidoJCY = "Yelmo";
	String segundoApellidoJCY = "Garcia";
	String DNIJCY = "12345678A";
	String numSegSocialJCY = "1234567A";
	
	//CREACION USUARIO 2 - DUEÑAS
	int userIdJCD = 2;
	double latitudJCD = 40.488892;
	double longitudJCD = -3.884992;
	String nombreJCD = "Juan Carlos";
	String primerApellidoJCD = "Dueñas";
	String segundoApellidoJCD = "Lopez";
	String DNIJCD = "12345678B";
	String numSegSocialJCD = "1234567B";
	
	//CREACION USUARIO 3 - DEL ALAMO
	int userIdJMDA = 3;
	double latitudJMDA = 40.488892;
	double longitudJMDA = -3.884992;
	String nombreJMDA = "Jose Maria";
	String primerApellidoJMDA = "del Alamo";
	String segundoApellidoJMDA = "Ramiro";
	String DNIJMDA = "12345678C";
	String numSegSocialJMDA = "1234567C";

	//DATOS COMUNES
	String sexo = "Masculino";
	String fecha = "01/01/1901";
	String telefono = "123456789";
	String via = "Calle Málaga";
	String numeroEdificio = "123";
	String provincia = "Madrid";
	String ciudad = "Las Rozas";
	String CP = "28231";
	String estadoCivil = "Casado";
	String personaContacto1 = "Pepito";
	String telefonoContacto1 = "987654321";
	String personaContacto2 = "";
	String telefonoContacto2 = "";
	
	String grupoSanguineo = "A positivo";
	String operaciones = "";
	String enfermPasadas = "";
	String enfermActuales = "Diabetes";
	

	//AÑADIMOS USUARIO 1
	TaccDAO dao = TaccDAOImpl.getInstance();
	dao.addUsuario(userIdJCY, latitudJCY, longitudJCY, nombreJCY, primerApellidoJCY, segundoApellidoJCY, sexo, fecha, DNIJCY, telefono,
			via, numeroEdificio, provincia, ciudad, CP, estadoCivil, personaContacto1, telefonoContacto1,
			personaContacto2, telefonoContacto2, numSegSocialJCY, grupoSanguineo, operaciones, enfermPasadas, enfermActuales);
	
	//AÑADIMOS USUARIO 2
	dao.addUsuario(userIdJCD, latitudJCD, longitudJCD, nombreJCD, primerApellidoJCD, segundoApellidoJCD, sexo, fecha, DNIJCD, telefono,
				via, numeroEdificio, provincia, ciudad, CP, estadoCivil, personaContacto1, telefonoContacto1,
				personaContacto2, telefonoContacto2, numSegSocialJCD, grupoSanguineo, operaciones, enfermPasadas, enfermActuales);
	
	//AÑADIMOS USUARIO 3
	dao.addUsuario(userIdJMDA, latitudJMDA, longitudJMDA, nombreJMDA, primerApellidoJMDA, segundoApellidoJMDA, sexo, fecha, DNIJMDA, telefono,
					via, numeroEdificio, provincia, ciudad, CP, estadoCivil, personaContacto1, telefonoContacto1,
					personaContacto2, telefonoContacto2, numSegSocialJMDA, grupoSanguineo, operaciones, enfermPasadas, enfermActuales);
		
	
	resp.sendRedirect("/usuarios");
	}

}