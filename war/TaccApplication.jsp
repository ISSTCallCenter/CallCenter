<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />

<title> Call Center </title>
<script type="text/javascript" src="script.js">
//&& user.nickname=='test@example.com'
</script>

<style type="text/css">
body{

	background: url(medicina.jpg) no-repeat fixed center; 

}
</style>
<!-- hoja de estilo -->

      <link rel="stylesheet" type="text/css" href="style.css" media="screen" />

<!-- favicon -->

        <link rel="shortcut icon" type="image/x-icon" href="/imagenes/firefox-ico.ico"/>
        <link rel="icon" type="image/x-icon" href="imagenes/firefox-ico.ico"/>


</head>
<body>


<c:if test="${user == null}">
<div class="container">
    <div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
            	<a href="<c:url value="${url}"/>">
            	<button class="btn btn-info btn-block login" >Login</button></a>
            </div>
        </div> 
</div>

</c:if>

<c:if test="${user != null}">
<div class="container">
    <div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
            		<c:if test="${user != null}">
            		Usuario <c:out value="${user.nickname}"/>
            		</c:if>
            	<a href="<c:url value="${url}"/>">
            	<button class="btn btn-info btn-block login" >Entrar en la web</button></a>
            </div>
        </div> 
</div>
</c:if>
</body>
</html>