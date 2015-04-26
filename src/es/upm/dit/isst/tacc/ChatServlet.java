package es.upm.dit.isst.tacc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tacc.model.Alerta;
import es.upm.dit.isst.tacc.model.Chat;
import es.upm.dit.isst.tacc.model.Evento;
import es.upm.dit.isst.tacc.model.Usuario;
import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;

public class ChatServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
	System.out.println("Llega chat");
		
		TaccDAO dao = TaccDAOImpl.getInstance();
		List<Alerta> alertas = new ArrayList<Alerta>();
		
		
		
		String geturl = req.getRequestURI();
		System.out.println(geturl);
	
		
		alertas = dao.listAlertas();
		
		List<Chat> chats = new ArrayList<Chat>();
		chats = dao.listChats();

		List<Evento> eventos = new ArrayList<Evento>();
		
		eventos = dao.listEventos(2);
		
		req.getSession().setAttribute("alertas", new ArrayList<Alerta>(alertas));
		req.getSession().setAttribute("eventos", new ArrayList<Evento>(eventos));
		req.getSession().setAttribute("chats", new ArrayList<Chat>(chats));

		RequestDispatcher view = req.getRequestDispatcher("TaccChat.jsp");
		view.forward(req, resp);
	}
}
