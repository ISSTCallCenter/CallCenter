package es.upm.dit.isst.tacc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;






import es.upm.dit.isst.tacc.model.*;




public class TaccDAOImpl implements TaccDAO {

	private static TaccDAOImpl instance;
	private TaccDAOImpl(){
	}
	
	public static TaccDAOImpl getInstance(){
		if (instance == null)
			instance = new TaccDAOImpl();
		return instance;
	}
	
	@Override
	public List<Usuario> listUsuarios() {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select m from Usuario m order by userId");
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}

	@Override
	public void addUsuario(int userId, double latitud, double longitud, String nombre, String primerApellido, String segundoApellido,
			String sexo, String fecha, String DNI, String telefono, String via, String numeroEdificio,
			String provincia, String ciudad, String CP, String estadoCivil, String personaContacto1,
			String telefonoContacto1, String personaContacto2, String telefonoContacto2, String numSegSocial,
			String grupoSanguineo, String operaciones, String enfermPasadas, String enfermActuales) {
		// TODO Auto-generated method stub
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Usuario usuario = new Usuario(userId, latitud, longitud, nombre, primerApellido, segundoApellido,
					sexo, fecha, DNI, telefono, via, numeroEdificio,
					provincia, ciudad, CP, estadoCivil, personaContacto1,
					telefonoContacto1, personaContacto2, telefonoContacto2, numSegSocial,
					grupoSanguineo, operaciones, enfermPasadas, enfermActuales);
			em.persist(usuario);
			em.close();
		}
	}

	@Override
	public List<Usuario> getUsuarios(String nombre) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from Usuario t where t.nombre =:nombre");
		q.setParameter("nombre", nombre);
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
		} finally {
			em.close();
		}
	}
	
	@Override
	public void delete(){
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("DELETE FROM Usuario m");
		q.executeUpdate();
		Query q1 = em.createQuery("DELETE FROM Alerta a");
		q1.executeUpdate();
		Query q2 = em.createQuery("DELETE FROM Evento e");
		q2.executeUpdate();
		Query q3 = em.createQuery("DELETE FROM Chat c");
		q3.executeUpdate();
	}

	@Override
	public List<String> getUsers() {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select distinct t.author from Usuario t");
		List<String> users = q.getResultList();
		return users;
	}
	@Override
	public List<Alerta> listAlertas(){
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select a from Alerta a order by tipo");
		List<Alerta> alertas = q.getResultList();
		return alertas;
	}
	
	@Override
	public void addAlerta(int userId, String tipo, int idEvento, double latitud,double longitud){
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Alerta alerta = new Alerta(userId, tipo, idEvento, latitud, longitud);
			em.persist(alerta);
			em.close();
		}
		
	}
	
	@Override
	public void removeAlerta(long id){
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Alerta alerta = em.find(Alerta.class, id);
			em.remove(alerta);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Evento> listEventos(int userId) {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select e from Evento e where e.userId =:userId order by fecha DESC");
		q.setParameter("userId", userId);
		List<Evento> eventos = q.getResultList();
		return eventos;
	}

	@Override
	public void addEvento(int userId, String fecha, int ritmoCardiaco, 
			int tensionArterialMax,  int tensionArterialMin, int nivelGlucosa, boolean acelerometro,
			double latitud, double longitud, boolean incrGas, boolean incrTemperatura, 
			int nivelTemperatura, int nivelCO2, int idEvento) {
		
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Evento evento = new Evento(userId, fecha, ritmoCardiaco, 
			tensionArterialMax, tensionArterialMin, nivelGlucosa, acelerometro,
			latitud, longitud, incrGas, incrTemperatura, nivelTemperatura, nivelCO2, idEvento);
			em.persist(evento);
			em.close();
		}
		
	}

	@Override
	public void removeEvento(long id) {
		
	}
	
	@Override
	public void addMensaje(String mensaje, String id, long tiempo, String fecha){
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Chat chat = new Chat(mensaje, id, tiempo,fecha);
			em.persist(chat);
			em.close();
		}
		
	}
	

	
	@Override
	public void removeChat(long id){
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Chat chat = em.find(Chat.class, id);
			em.remove(chat);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Chat> listChats() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select a from Chat a order by tiempo DESC");
		List<Chat> chats = q.getResultList();
		return chats;
	}

}
