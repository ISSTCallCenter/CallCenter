package es.upm.dit.isst.tacc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.MessageType;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;

public class CreateAlertaServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private static final XMPPService xmppService =
	XMPPServiceFactory.getXMPPService();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		
	System.out.println("Creando nueva alerta");
	
	RequestDispatcher view = req.getRequestDispatcher("TaccInicio.jsp");
	RequestDispatcher v = req.getRequestDispatcher("TaccHistorial.jsp");

	view.forward(req, resp);
	v.forward(req, resp);


	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String areaMSG = checkNull(req.getParameter("description"));
		
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String fecha = sdf.format(date);
		
		JID chat = new JID("tacc-isst-2015@appspot.com");
		JID recipientJID = new JID("cuidadores-isst-2015@appspot.com");
		
		  Message response = new MessageBuilder()
		      .withMessageType(MessageType.CHAT)
		      .withRecipientJids(recipientJID)
		      .withFromJid(chat)
		      .withBody(areaMSG)
		      .build();

		  //Send the message
		  boolean messageSent = false;
		  SendResponse status = xmppService.sendMessage(response);
		  messageSent = (status.getStatusMap().get(recipientJID) == SendResponse.Status.SUCCESS);
		  
			TaccDAO dao = TaccDAOImpl.getInstance();
			dao.addMensaje(areaMSG, "Yo :", date.getTime(), fecha);
		  
		  resp.sendRedirect("/chat");
		
		}
	private String checkNull(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
}
