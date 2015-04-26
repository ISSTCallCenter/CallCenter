package es.upm.dit.isst.tacc.dao;

import java.util.List;

import es.upm.dit.isst.tacc.model.*;

public interface TaccDAO {
	//Usuarios
	public List<Usuario> listUsuarios();
	public void addUsuario(int userId, double latitud, double longitud, String nombre, String primerApellido, String segundoApellido,
			String sexo, String fecha, String DNI, String telefono, String via, String numeroEdificio,
			String provincia, String ciudad, String CP, String estadoCivil, String personaContacto1,
			String telefonoContacto1, String personaContacto2, String telefonoContacto2, String numSegSocial,
			String grupoSanguineo, String operaciones, String enfermPasadas, String enfermActuales);
	public List<Usuario> getUsuarios(String nombre);
	public void remove (long id);
	public List<String> getUsers();
	public void delete();
	
	//Alertas
	public List<Alerta> listAlertas();
	public void addAlerta(int userId, String tipo, int idEvento, double latitud,double longitud);
	public void removeAlerta(long id);
	
	//Chat
	public List<Chat> listChats();
	public void addMensaje(String mensaje, String id, long tiempo, String fecha);
	
	public void removeChat(long id);
	
	//Eventos
	public List<Evento> listEventos(int userId);
	public void addEvento(int userId, String fecha, int ritmoCardiaco, int tensionArterialMax,  int tensionArterialMin, int nivelGlucosa,
			boolean acelerometro, double latitud, double longitud, boolean incrGas,  boolean incrTemperatura,
			int nivelTemperatura,  int nivelCO2, int idEvento);
	public void removeEvento(long id);
	
}
