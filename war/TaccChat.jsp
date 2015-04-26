<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <!--  -->
    <title>TeleAsistencia Call Center</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="hoja-estilo.css" media="screen" />
     <link rel="stylesheet" type="text/css" href="hoja-estilo-chat.css" media="screen" />
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    
  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	<script src="javascript.js" type="text/javascript"></script>
	
	<style>
	/*----------------------------------ACCESO-----------------------------------*/

#acceso {
    background: none repeat scroll 0 0 #FFF;
    margin: 0;
    text-align: center;
}
#page_container {
    margin-left: auto;
    margin-right: auto;
   
    top: -32px;
    width: 550px;
    position: fixed;
    right: 1%;
    margin-top: 50px;
}
#header {
    background: url("images/header.png") no-repeat scroll center center #3F3F3F;
    border-bottom: 1px solid #4A4A4A;
    height: 80px;
    margin-left: auto;
    margin-right: auto;
    position: relative;
    width: 550px;
}
#header h1 {
    color: white;
    display: none;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 40px;
    font-weight: bold;
    position: relative;
    top: 30px;
}
#header h2 {
    color: #7E7E7E;
    display: none;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 16px;
    font-weight: bold;
}
hr#header_stripe {
    background-color: #191919;
    border: medium none;
    color: #191919;
    height: 12px;
    position: relative;
    top: -7px;
}
.panel_button {
    background: url("images/panel_button.png") repeat scroll 0 0 ;
    cursor: pointer;
    height: 54px;
    margin-left: auto;
    margin-right: auto;
    position: relative;
    top: 30px;
    width: 173px;
    z-index: 20;
}
.panel_button img {
    border: medium none;
    position: relative;
    top: 10px;
}
.panel_button a {
    color: #545454;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 20px;
    font-weight: bold;
    left: 10px;
    position: relative;
    text-decoration: none;
    top: 5px;
}
.panel_button a:hover {
    color: #999999;
}
#wrapper {
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    width: 545px;
}
#toppanel {
    left: 0;
    position: absolute;
    text-align: center;
    width: 545px;
    z-index: 25;
    margin-top: -9px;
}
#panel {
    height: 0;
    margin-left: auto;
    margin-right: auto;
    overflow: hidden;
    position: relative;
    text-align: left;
    top: 32px;
    width: 550px;
    z-index: 10;
}
#panel_contents {
    background: none repeat scroll 0px 0px #FFD264;
    height: 100%;
    position: absolute;
    width: 550px;
    z-index: -1;
}
#panel h1 {
    color: white;
    font-family: Geneva,Arial,Helvetica,sans-serif;
    font-weight: normal;
    left: 275px;
    line-height: 35px;
    position: absolute;
    text-align: center;
    top: 10px;
}
#panel h2 {
    color: #447C6F;
    font-family: Geneva,Arial,Helvetica,sans-serif;
    font-size: 16px;
    left: 350px;
    line-height: 25px;
    position: absolute;
    text-align: center;
    top: 60px;
}
#content {
    color: #545454;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 12px;
    margin-left: auto;
    margin-right: auto;
    padding-bottom: 30px;
    position: relative;
    text-align: left;
    top: 90px;
    width: 540px;
}
.border {
    border: 15px solid #1D1D1D;
}
img.border {
    float: left;
    margin-bottom: 8px;
    margin-right: 15px;
}
img.border_pic {
    border: 15px solid #1D1D1D;
    float: left;
    height: 150px;
    margin-left: 0px;
    position: relative;
    top: 20px;
    width: 250px;
    z-index: 30;
}
div#login {
    background: none repeat scroll 0 0 #46392F;
    height: 150px;
    padding-left: 10px;
    position: relative;
    float: right;
    text-align: left;
    bottom: 159px;
    width: 240px;
}
div#login p {
    color: #CCCCCC;
    font-family: Century Gothic,Georgia,"Times New Roman",Times,serif;
    line-height: 25px;
}
div#login input#password {
    position: relative;
    right: 10px;
}
div#login input#login_btn {
    border: 1px solid #899690;
    cursor: pointer;
    left: 86px;
    position: relative;
    top: 30px;
}
#footer p {
    color: #333333;
    font-family: Arial,Helvetica,sans-serif;
    font-size: 13px;
    position: relative;
    top: 60px;
}

	
	</style>
        
   
        
      	<script type="text/javascript">

		setInterval(ajaxAutoload, 3000); //300000 MS == 5 minutes
		setInterval(ajaxAutoload2, 10000); //300000 MS == 5 minutes
   		
		function ajaxAutoload() {
    	//do your AJAX stuff here
			$('#chat').load('/chat #chat').fadeIn("slow");
		}
		
		function ajaxAutoload2() {
	    	//do your AJAX stuff here
				$('#load_me').load('/alertallega #load_me').fadeIn("slow");
	    		
		}
</script>

   
		
	</head>
	
	
<body>







<div class="container" style="padding-top: 1em;">
	     <nav role="navigation" class="navbar navbar-default navbar-fixed-top ">
	     <div class="navbar-header">
	
	            <ul class="nav navbar-nav">
	            	<li><a href="/inicio">Inicio</a></li>
	                <li><a href="/usuarios">Usuarios</a></li>
	                <li class="active"><a href="/chat">Chat</a></li>
	                <li><a href="index.html">Logout</a></li>
	                
	            </ul>
	
	        </div>
</div>

<br><br>
<br><br>
<div id="load_me" style="position:fixed;right:1%">
				    
				    <p style="text-align:center"> ALERTAS POR ATENDER: ${fn:length(alertas)}</p>
				    <button class="btn btn-danger" onClick=actualizarAlarmas()>Actualizar alarmas</button> 
				   
</div>

<div id="chat">

	<div id="header-chat">
		Chat con cuidador
	</div>
	<div id="mensajes">
	
	 <c:forEach items="${chats}" var="chat">
		 			
		
	 
	<c:if test="${chat.id == 'Yo :'}">
		<div class="mensaje-autor">
			<img src="avata.gif" Style="height: 50px; width: 50px;" alt="" class="foto">
			<div class="flecha-izquierda"></div>
			<div class="contenido">
				<c:out value="${chat.mensaje}" />
			</div>
			<div class="fecha">Enviado <c:out value="${chat.fecha}" /></div>
		</div>
		
	</c:if>

	<c:if test="${chat.id == 'Cuidador :'}">
			<div class="mensaje-amigo">
				<div class="contenido">
					<c:out value="${chat.mensaje}" />
				</div>
				<div class="flecha-derecha"></div>
				<img src="yelmo.jpg" Style="height: 50px; width: 50px;"alt="" class="foto">
				<div class="fecha">Enviado <c:out value="${chat.fecha}" /></div>
			</div>
	</c:if>
	
	</c:forEach>
		</div>
	
</div>

<div id="caja-mensaje">
<form action="/nuevaAlerta" method="post" accept-charset="utf-8" style="margin-left: 5px;
margin-top: 4px;
margin-bottom: 5px;">
			    
			    <table>	
							
			    			<tr>
								<td valign="description"><label for="description">Contenido del mensaje</label></td>
								<td><textarea rows="4" cols="50" name="description"
										id="description" placeholder="agregar un mensaje"></textarea></td>
							</tr>
			    </table>
			    <button class="btn btn-primary">Enviar mensaje</button> 
</form>		
</div>





</body>
</html>