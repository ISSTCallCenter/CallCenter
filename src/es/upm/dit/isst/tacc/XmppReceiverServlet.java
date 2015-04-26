package es.upm.dit.isst.tacc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.MessageType;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

import es.upm.dit.isst.tacc.dao.TaccDAO;
import es.upm.dit.isst.tacc.dao.TaccDAOImpl;
import es.upm.dit.isst.tacc.model.Alerta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handler class for all XMPP messages.
 */
public class XmppReceiverServlet extends HttpServlet {

  private static final XMPPService xmppService =
      XMPPServiceFactory.getXMPPService();

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
	  
    Message message = xmppService.parseMessage(req);

   // JID sender = message.getFromJid();
   // Question currentlyAnswering = questionService.getAnswering(sender);
    
	TaccDAO dao = TaccDAOImpl.getInstance();
	
	java.util.Date date = new java.util.Date();
	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
	
	String fecha = sdf.format(date);
	
	 JID sender = message.getFromJid();
	 JID correoAlerta = new JID("alerta@appspot.com");
	 JID procesadorEventos = new JID("dapaca-isst-2015@appspot.com");

System.out.println(message.getMessageType());
	 
	 
	 JID chat = new JID("cuidadores-isst-2015@appspot.com");
		 
		
	 
	 if ((message.getBody().charAt(0)=='e') && (message.getBody().charAt(1)=='v') && (message.getBody().charAt(2)=='e' )) {
		
		 //Para probar
		// evento(2;5;12;7;52;0;77.0;88.0;0;0;30;1;55)
		 
			double evento[] = gestionEvento(message.getBody());
			
			int userId = (int) evento[0];
			int ritmoCardiaco = (int) evento[1];
			
			int tensionArterialMax = (int) evento[2];
			int tensionArterialMin =  (int) evento[3];
			int nivelGlucosa = (int) evento[4];
			boolean acelerometro = VoF(evento[5]);
			boolean incrGas = VoF(evento[8]);
			
			boolean incrTemperatura = VoF(evento[9]);
			int nivelTemperatura = (int) evento[10];
			
			int nivelCO2 = (int) evento[11];
			int idEvento = (int) evento[12];
			
			dao.addEvento(userId, fecha, ritmoCardiaco, tensionArterialMax, tensionArterialMin, nivelGlucosa, acelerometro, evento[6], evento[7], incrGas, incrTemperatura, nivelTemperatura, nivelCO2, idEvento);
			

		
	} else if ((message.getBody().charAt(0)=='a')&& (message.getBody().charAt(1)=='l') && (message.getBody().charAt(2)=='a' )) {
		//Para Probar
		//alarma(2;1;2;50.5;69.8)
		double alarma[] = gestionEvento(message.getBody());
		
		int userId = (int) alarma[0];
		String tipo = verTipo(alarma[1]);
		int idEvento = (int) alarma[2];
		
		dao.addAlerta(userId,tipo, idEvento,alarma[3], alarma[4]);
	
	} else {
		
		dao.addMensaje(message.getBody(), "Cuidador :" , date.getTime() , fecha);
		
	}
	 
	
	//dao.addEvento(2,"hola",80,25,200,110,false,52.52,652.5,false,false,false,20,30,1);
	//PROBAR ESTO (2;80;25;770;110;0;52.52;652.5;0;0;0;20;30;1)
	
	

  }
  

  
  
  
  public double[] gestionEvento(String alerta){
	  
	  String acumulado = "";
	  double valor= 0;
	  int campo = 0;
	  double evento[] = new double[15];
	  
	  for (int i = 7; i < alerta.length(); i++) {
		  
		  if((alerta.charAt(i) == ';')||(alerta.charAt(i) == ')') ){
			  valor = Double.parseDouble(acumulado);
			 
			  evento[campo] = valor;
			  acumulado="";
			  campo++;
		  }else{
			  acumulado = acumulado+alerta.charAt(i);
		  }
		  
	}
	  return evento;
	  
  }
  
public double[] gestionAlarma(String alerta){
	  
	  String acumulado = "";
	  double valor= 0;
	  int campo = 0;
	  double evento[] = new double[5];
	  
	  for (int i = 7; i < alerta.length(); i++) {
		  
		  if((alerta.charAt(i) == ';')||(alerta.charAt(i) == ')') ){
			  valor = Double.parseDouble(acumulado);
			  
			  evento[campo] = valor;
			  acumulado="";
			  campo++;
		  }else{
			  acumulado = acumulado+alerta.charAt(i);
		  }
		  
	}
	  return evento;
	  
  }
  
  public boolean VoF(double valor){
	  boolean resultado = false;
	  
	  if(valor>=1){
		  resultado = true;
	  }
	  return resultado;
  }
  
  public String verTipo(double tipo){
	  
	  String tipoAlarma ="";
	  int nTipo = (int) tipo;

	switch (nTipo) {
	case 0:
		tipoAlarma = "la activación del botón de pánico";
		break;
	
	case 1:
		tipoAlarma = "un posible Desmayo";
		break;
	case 2:
		tipoAlarma = "un posible Infarto";
		break;
		
	case 3:
		tipoAlarma = "un posible Incendio";
	break;

	default:
		
		tipoAlarma = "un ERROR en la detección de la alarma";
		break;
	}
	  
	  
	  return tipoAlarma;
  }


}
