<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>TeleAsistencia Call Center</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
  <!--      <script type="text/javascript">
 
            var auto_refresh = setInterval(
            function ()
            {
                $('#load_me').load('/alertallega').fadeIn("slow");
            }, 10000); 
            
            $(function() { // when DOM is ready
   		    $("#botones").click(function(){ // when #showhidecomment is clicked
   		    	$('#load_me').load('/alertallega #load_me').fadeIn("slow");
   		    }); 
   		});
        </script>-->
        <script type="text/javascript">
        
   		 setInterval(ajaxCall, 20000); //300000 MS == 5 minutes

		function ajaxCall() {
    	//do your AJAX stuff here
			$('#load_me').load('/alertallega #load_me').fadeIn("slow");
		}
		</script>
	<div class="container" style="padding-top: 1em;">
     <nav role="navigation" class="navbar navbar-default navbar-fixed-top ">
     <div class="navbar-header">

            <ul class="nav navbar-nav">
                <li class="active"><a href="/inicio">Inicio</a></li>
                <li><a href="/usuarios">Usuarios</a></li>
                <li><a href="index.html">Logout</a></li>
                
            </ul>

        </div>
</div>
</head>
<body>
<br><br>
<form action="/nuevaAlerta" method="post" accept-charset="utf-8">
			    <ul>
			    <button class="btn btn-danger">Envio alerta</button> 
</form>
<div id="load_me">

		Tiene un total de ${fn:length(alertas)}
		Alertas.
	<c:forEach items="${alertas}" var="alerta">
	<div>
		<ul>
		   <a class="btn btn-danger" data-toggle="collapse" href="#<c:out value="${alerta.id}"/>" aria-expanded="false" aria-controls="<c:out value="${alerta.id}"/>">
		  Alerta de <c:out value="${alerta.tipo}" />
		    </a>
		    </ul>
			<div class="collapse" id="<c:out value="${alerta.id}"/>">
			  	<div class="well">
			     <c:out value="${alerta.subtipo}" /> 
			    <form action="/borrarAlerta?id=${alerta.id}" method="post" accept-charset="utf-8">
			    
			    <div id="botones">
				    <ul>
					    <button class="btn btn-danger" onClick="actualizarDatos()">Llamar a los bomberos</button> 
					    <button class="btn btn-warning">Llamar al usuario </button> 
					    <button class="btn btn-primary">Llamar a la persona de contacto</button>
				    </ul>
				</div>
			    </form>
		  		</div>
			</div>
	</div>
	</c:forEach>
</div>
</body>
</html>