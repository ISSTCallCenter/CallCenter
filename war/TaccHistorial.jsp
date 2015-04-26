<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="hoja-estilo.css" media="screen" />
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Dropdown userlist plus administration (V2.3) - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
      	
    <style type="text/css">
        //Reusing bootstrap 3 panel CSS
.panel {
    background-color: #FFFFFF;
    border: 1px solid rgba(0, 0, 0, 0);
    border-radius: 4px 4px 4px 4px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
    margin-bottom: 20px;
}   

.panel-primary {
    border-color: #428BCA;
}   

.panel-primary > .panel-heading {
    background-color: #428BCA;
    border-color: #428BCA;
    color: #FFFFFF;
}   

.panel-heading {
    border-bottom: 1px solid rgba(0, 0, 0, 0);
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
    padding: 10px 15px;
}   

.panel-title {
    font-size: 16px;
    margin-bottom: 0;
    margin-top: 0;
}   

.panel-body:before, .panel-body:after {
    content: " ";
    display: table;
}   

.panel-body:before, .panel-body:after {
    content: " ";
    display: table;
}   

.panel-body:after {
    clear: both;
}   

.panel-body {
    padding: 15px;
}   

.panel-footer {
    background-color: #F5F5F5;
    border-bottom-left-radius: 3px;
    border-bottom-right-radius: 3px;
    border-top: 1px solid #DDDDDD;
    padding: 10px 15px;
}

//CSS from v3 snipp
.user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}


.datagrid table { border-collapse: collapse; text-align: left; width: 100%; } .datagrid {font: normal 12px/150% Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 1px solid #006699; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px; }.datagrid table td, .datagrid table th { padding: 3px 10px; }.datagrid table thead th {background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #006699), color-stop(1, #008ED4) );background:-moz-linear-gradient( center top, #006699 5%, #008ED4 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', endColorstr='#008ED4');background-color:#006699; color:#FFFFFF; font-size: 13px; font-weight: bold; border-left: 1px solid #0070A8; } .datagrid table thead th:first-child { border: none; }.datagrid table tbody td { color: #2C5EE8; border-left: 1px solid #E1EEF4;font-size: 12px;font-weight: normal; }.datagrid table tbody .alt td { background: #E1EEf4; color: #00557F; }.datagrid table tbody td:first-child { border-left: none; }.datagrid table tbody tr:last-child td { border-bottom: none; }.datagrid table tfoot td div { border-top: 1px solid #006699;background: #E1EEf4;} .datagrid table tfoot td { padding: 0; font-size: 12px } .datagrid table tfoot td div{ padding: 2px; }.datagrid table tfoot td ul { margin: 0; padding:0; list-style: none; text-align: right; }.datagrid table tfoot  li { display: inline; }.datagrid table tfoot li a { text-decoration: none; display: inline-block;  padding: 2px 8px; margin: 1px;color: #FFFFFF;border: 1px solid #006699;background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #006699), color-stop(1, #00557F) );background:-moz-linear-gradient( center top, #006699 5%, #00557F 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', endColorstr='#00557F');background-color:#006699; }.datagrid table tfoot ul.active, .datagrid table tfoot ul a:hover { text-decoration: none;border-color: #4FCF36; color: #FFFFFF; background: none; background-color:#76FF62;}div.dhtmlx_window_active, div.dhx_modal_cover_dv { position: fixed !important; }

    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

    
    <script type="text/javascript">

		//setInterval(ajaxAutoload, 3000); //300000 MS == 5 minutes
   		
		function ajaxAutoload() {
    	//do your AJAX stuff here
    	var historialid = document.getElementById("usuariop").textContent;
		$('#autoload').load('/historial?userId=' + historialid + ' #autoload').fadeIn("slow");
		}
	</script>
	<script>
    setInterval(ajaxAutoload2, 10000); //300000 MS == 5 minutes
        
   	
   		
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
                <li class="active"><a href="/usuarios">Usuarios</a></li>
                <li ><a href="/index">Logout</a></li>
            </ul>

        </div>
 </nav>
 <br><br>
 <div style="display:none">
 <p id="usuariop"><c:out value="${usuario}" /></p>
 </div>
 <div id="load_me" style="position:fixed;right:1%">
				    
				    <p style="text-align:center"> ALERTAS POR ATENDER: ${fn:length(alertas)}</p>
				    <button class="btn btn-danger" onClick=actualizarAlarmas()>Actualizar alarmas</button> 
				   
</div>
<div id="autoload">
<div class="bs-example" data-example-id="table-within-panel">
    <div class="panel panel-default">
      <!-- Default panel contents -->
	
      <!-- Table -->
      <table class="table table-bordered table-striped">
        <thead>
          <tr>
          	<th>Alarma Asociada</th>
	        <th>Id Usuario</th>
	        <th>Fecha</th>
	        <th>Ritmo Cardíaco</th>
        	<th>Tension arterial Max</th>
        	<th>Tensión arterial Min</th>
	        <th>Nivel glucosa</th>
	        <th>Acelerómetro</th>
	        <th>Latitud</th>
	        <th>Longitud</th>
	        <th>Incremento gas</th>
	        <th>Incremento temperatura</th>
	        <th>Nivel temperatura</th>
	        <th>Nivel CO</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${eventos}" var="evento">
          
          <c:forEach items="${alertas}" var="alerta">
		  <c:choose>
			<c:when test="${alerta.idEvento == evento.idEvento}">
			 <tr>
			 <td style="background-color:orange">Sí</td>
		      <td style="background-color:orange"><c:out value="${evento.userId}" /></td>
			  <td style="background-color:orange"><c:out value="${evento.fecha}" /></td>
		      <td style="background-color:orange"><c:out value="${evento.ritmoCardiaco}" /></td>
		      <td style="background-color:orange"><c:out value="${evento.tensionArterialMax}" /></td>
		      <td style="background-color:orange"><c:out value="${evento.tensionArterialMin}" /></td>
		      <td style="background-color:orange"><c:out value="${evento.nivelGlucosa}" /></td>
		      <td style="background-color:orange"><c:out value="${evento.acelerometro}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.latitud}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.longitud}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.incrGas}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.incrTemperatura}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.nivelTemperatura}" /></td>
		       <td style="background-color:orange"><c:out value="${evento.nivelCO2}" /></td>
   			 </tr>						                              
			</c:when>
			<c:otherwise>
			 <tr>
			 <td>No</td>
		      <td><c:out value="${evento.userId}" /></td>
			  <td><c:out value="${evento.fecha}" /></td>
		      <td><c:out value="${evento.ritmoCardiaco}" /></td>
		      <td><c:out value="${evento.tensionArterialMax}" /></td>
		      <td><c:out value="${evento.tensionArterialMin}" /></td>
		      <td><c:out value="${evento.nivelGlucosa}" /></td>
		      <td><c:out value="${evento.acelerometro}" /></td>
		       <td><c:out value="${evento.latitud}" /></td>
		       <td><c:out value="${evento.longitud}" /></td>
		       <td><c:out value="${evento.incrGas}" /></td>
		       <td><c:out value="${evento.incrTemperatura}" /></td>
		       <td><c:out value="${evento.nivelTemperatura}" /></td>
		       <td><c:out value="${evento.nivelCO2}" /></td>
    		</tr>
			</c:otherwise>
		</c:choose>
		</c:forEach>
          
          
          
   
</c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  
 
</div>
</div>



<script type="text/javascript">
$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="icon-chevron-up text-muted"></i>');
            }
            else
            {
                currentButton.html('<i class="icon-chevron-down text-muted"></i>');
            }
        })
    });


    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
        alert("This is a demo.\n :-)");
    });
});

</script>



</body>
</html>