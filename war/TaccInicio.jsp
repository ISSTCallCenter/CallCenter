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
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
	
<style type="text/css">
.modal .modal-body {
    max-height: 450px;
}
</style>
<link rel="stylesheet" type="text/css" href="hoja-estilo.css"
	media="screen" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="gmaps.js"></script>


<!-- This is what you need -->
<script src="dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="dist/sweetalert.css">
<!--.......................-->

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>



<script type="text/javascript">
    
        setInterval(ajaxAutoload, 10000); //300000 MS == 5 minutes
        
   	
   		
		function ajaxAutoload() {
    	//do your AJAX stuff here
			$('#load_me').load('/alertallega #load_me').fadeIn("slow");
    		
		}
		
		function pause(millis) 
   		{
   		        var date = new Date();
   		        var curDate = null;
   		        do { curDate = new Date(); } 
   		        while(curDate-date < millis)
   		}
   		 
   		function actualizarAlarmas() {
   			$('#botones_alarmas').load('/alertallega #botones_alarmas').fadeIn("slow");
   		}
   		
   		function imprimeResta(){
   			var element = document.getElementById("botones_alarmas");
   			var botones = element.children.length;
   			var alarmas = ${fn:length(alertas)};
   			var resta = alarmas - botones;
   		}
   		
   		function llamadaCogida(a){
   			pause(4000);
   			document.getElementById(a).style.display = "block";
   			swal('El usuario ha cogido la llamada', 'Haga click para terminar de atender la alerta', 'success');
   		}
   		
   		function llamadaCogidaMal(a){
   			pause(4000);
   			document.getElementById(a).style.display = "block";
   			swal({
   				title: "El usuario ha cogido la llamada y se encuentra mal",
   				text: "Haga click para llamar a la persona de contacto o a las emergencias",
   				type: 'warning',
   				showCancelButton: true,
   				cancelButtonText: 'Llamar a persona de contacto',
   				confirmButtonColor: '#DD6B55',
   				confirmButtonText: 'Llamar a emergencias',
   				closeOnConfirm: false,
   				closeOnCancel: false
   			},
   			function(isConfirm){ 
   				if (isConfirm) { 
   					pause(4000);
   					swal({
   		   				title: "Las emergencias están en camino",
   		   				text: "Quiere llamar también a la persona de contacto?",
   		   				type: 'success',
   		   				showCancelButton: true,
   		   				cancelButtonText: 'No',
   		   				confirmButtonColor: '#DD6B55',
   		   				confirmButtonText: 'Llamar a persona de contacto',
   		   				closeOnConfirm: false,
   		   				closeOnCancel: false
   		   			},
   		   			function(isConfirm){ 
   		   				if (isConfirm) { 
   		   					pause(4000);
   		   					swal('La persona de contacto está en camino', 'Haga click para terminar de atender la alerta', 'success'); 
   		   					} else {  
   		   					swal('De acuerdo', 'Haga click para terminar de atender la alerta', "success");   
   		   					}
   		   				}); 
   					} else {  
   					pause(4000);
   					swal({
   		   				title: "La persona de contacto está en camino",
   		   				text: "Quiere llamar también a las emergencias?",
   		   				type: 'success',
   		   				showCancelButton: true,
   		   				cancelButtonText: 'No',
   		   				confirmButtonColor: '#DD6B55',
   		   				confirmButtonText: 'Llamar a emergencias',
   		   				closeOnConfirm: false,
   		   				closeOnCancel: false
   		   			},
   		   			function(isConfirm){ 
   		   				if (isConfirm) { 
   		   					pause(4000);
   		   					swal('Las emergencias están en camino', 'Haga click para terminar de atender la alerta', 'success'); 
   		   					} else {  
   		   					swal('De acuerdo', 'Haga click para terminar de atender la alerta', "success");   
   		   					}
   		   				});   
   					}
   				});
   		}
   		
   		function llamando(){
   			pause(4000);
   			swal('El usuario ha cogido la llamada', 'Haga click para terminar de atender la alerta', 'success');
   		}
   		
   		function llamadaNoCogida(a){
   			pause(4000);
   			document.getElementById(a).style.display = "block";
   			swal({
   				title: "El usuario no ha cogido la llamada",
   				text: "Haga click para llamar a la persona de contacto o a las emergencias",
   				type: 'warning',
   				showCancelButton: true,
   				cancelButtonText: 'Llamar a persona de contacto',
   				confirmButtonColor: '#DD6B55',
   				confirmButtonText: 'Llamar a emergencias',
   				closeOnConfirm: false,
   				closeOnCancel: false
   			},
   			function(isConfirm){ 
   				if (isConfirm) { 
   					pause(4000);
   					swal({
   		   				title: "Las emergencias están en camino",
   		   				text: "Quiere llamar también a la persona de contacto?",
   		   				type: 'success',
   		   				showCancelButton: true,
   		   				cancelButtonText: 'No',
   		   				confirmButtonColor: '#DD6B55',
   		   				confirmButtonText: 'Llamar a persona de contacto',
   		   				closeOnConfirm: false,
   		   				closeOnCancel: false
   		   			},
   		   			function(isConfirm){ 
   		   				if (isConfirm) { 
   		   					pause(4000);
   		   					swal('La persona de contacto está en camino', 'Haga click para terminar de atender la alerta', 'success'); 
   		   					} else {  
   		   					swal('De acuerdo', 'Haga click para terminar de atender la alerta', "success");   
   		   					}
   		   				}); 
   					} else {  
   					pause(4000);
   					swal({
   		   				title: "La persona de contacto está en camino",
   		   				text: "Quiere llamar también a las emergencias?",
   		   				type: 'success',
   		   				showCancelButton: true,
   		   				cancelButtonText: 'No',
   		   				confirmButtonColor: '#DD6B55',
   		   				confirmButtonText: 'Llamar a emergencias',
   		   				closeOnConfirm: false,
   		   				closeOnCancel: false
   		   			},
   		   			function(isConfirm){ 
   		   				if (isConfirm) { 
   		   					pause(4000);
   		   					swal('Las emergencias están en camino', 'Haga click para terminar de atender la alerta', 'success'); 
   		   					} else {  
   		   					swal('De acuerdo', 'Haga click para terminar de atender la alerta', "success");   
   		   					}
   		   				});   
   					}
   				});
		}
   		
   		$("#botones_alarmas").ready(function(){
   			imprimeResta();
   		});
    		
   		function mostrarMapa(a, latitud, longitud) {
   			
  		  var mapOptions = {
  		    zoom: 17,
  		    center: new google.maps.LatLng(latitud, longitud)
  		  };
  		  var map = new google.maps.Map(document.getElementById(a),
  		      mapOptions);
  		var marker = new google.maps.Marker({
  		    position: new google.maps.LatLng(latitud, longitud),
  		    map: map,
  		    title:"Usuario"
  		});
  		document.getElementById(a).style.display = "block";
  		document.getElementById(a).style.height = "200px";
  		}

</script>





<div class="container" style="padding-top: 1em;">
	<nav role="navigation" class="navbar navbar-default navbar-fixed-top ">
	<div class="navbar-header">

		<ul class="nav navbar-nav">
			<li class="active"><a href="/inicio">Inicio</a></li>
			<li><a href="/usuarios">Usuarios</a></li>
			<li><a href="<c:url value="${url}"/>">Logout</a></li>

		</ul>

	</div>
	
</div>

</head>


<body>
	<br>
	<br>
	<div id="load_me" style="position: fixed; right: 1%">

		<p style="text-align: center">ALERTAS POR ATENDER:
			${fn:length(alertas)}</p>
		<button class="btn btn-danger" onClick=actualizarAlarmas()>Actualizar
			alarmas</button>

	</div>
	<div id="botones_alarmas">

		<p>ALERTAS POR ATENDER: ${fn:length(alertas)}</p>

		<c:forEach items="${alertas}" var="alerta">

			<div>
				<!--<ul>
		   <a class="btn btn-danger" data-toggle="collapse" href="#<c:out value="${alerta.id}"/>" aria-expanded="false" aria-controls="<c:out value="${alerta.id}"/>">
		  Alerta de <c:out value="${alerta.tipo}" />
		    </a>
		    </ul>-->


				<!-- Botón de apertura -->
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal"
					data-target="#myModal<c:out value="${alerta.id}"/>">
					Atender alerta sobre
					<c:out value="${alerta.tipo}" />
				</button>

				<!-- Ventana Modal -->
				<div class="modal fade" id="myModal<c:out value="${alerta.id}"/>"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Atender alarma</h4>
							</div>
							<div class="modal-body">
								<div>
									<table class="table">
										<tbody>
											<tr>
												<td class="span2"><strong>Tipo:</strong> <c:out
														value="${alerta.tipo}" /></td>
											</tr>

											<c:forEach items="${usuarios}" var="usuario">
												<c:choose>
													<c:when test="${usuario.userId == alerta.userId}">

														<tr>
															<td class="span2"><strong>Usuario <c:out value="${alerta.userId}" />:
															</strong> <c:out value="${usuario.primerApellido}" /> <c:out
																	value="${usuario.segundoApellido}" />, <c:out
																	value="${usuario.nombre}" /></td>
														</tr>
														<tr>
															<td class="span2"><strong>Telefono:</strong> <c:out value="${usuario.telefono}" /></td>
														</tr>
														<c:choose>
															<c:when
																test="${(usuario.latitud == alerta.latitud) && (usuario.longitud == alerta.longitud)}">
																<tr>
																	<td class="span2"><strong>En casa:</strong> Sí</td>
																</tr>
															</c:when>
															<c:otherwise>
																<tr>
																	<td class="span2"><strong>En casa:</strong> No</td>
																</tr>
															</c:otherwise>
														</c:choose>
													</c:when>
												</c:choose>
											</c:forEach>
										</tbody>
									</table>
									<div>
										<button type="button"
											onClick="mostrarMapa('map-canvas<c:out value="${alerta.id}"/>', <c:out value="${alerta.latitud}"/>, <c:out value="${alerta.longitud}"/>)"
											class="btn btn-info btn-lg">Mostrar mapa</button>
									</div>

									<div id="map-canvas<c:out value="${alerta.id}"/>"
										style="display: block"></div>

								</div>

								<div>
									<c:choose>
										<c:when test="${alerta.userId == 1}">
											<div class="messageno">
												<button type="button" onClick=llamadaNoCogida("finalizar<c:out value="${alerta.id}"/>") class="btn btn-warning btn-lg">Llamar
													al usuario</button>
											</div>
										</c:when>
										<c:otherwise>
											<c:if test="${alerta.userId == 2}">
												<div class="messagesi">
													<button type="button" onClick=llamadaCogida("finalizar<c:out value="${alerta.id}"/>") class="btn btn-warning btn-lg">Llamar
														al usuario</button>
												</div>
											</c:if>
											<c:if test="${alerta.userId == 3}">
												<div class="messagesi">
													<button type="button" onClick=llamadaCogidaMal("finalizar<c:out value="${alerta.id}"/>") class="btn btn-warning btn-lg">Llamar
														al usuario</button>
												</div>
											</c:if>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
						</div>

						<div class="modal-footer">
							<form action="/borrarAlerta?id=${alerta.id}" method="post"
								accept-charset="utf-8">

								<input type="submit" value="Finalizar" class="btn btn-info"
									id="finalizar<c:out value="${alerta.id}"/>"
									style="display: none" />

							</form>
						</div>
					</div>
				</div>


			</div>
			<p></p>
		</c:forEach>
	</div>





</body>
</html>