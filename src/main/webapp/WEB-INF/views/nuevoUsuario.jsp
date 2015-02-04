<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informaci&oacuten de usuario</title>
</head>
<body>
	<p>Crear nuevo usuario</p>
	<c:url value="/nuevoUsuario?validar=true" var="urlGuardar" />
	<form:form action="${urlGuardar}" commandName="usuario">
	<P> <form:errors path="*"/> <P>
<%-- 		<input type="hidden" value="${requestScope.usuario.idUsuario}" name="idUsuario" /> --%>
		<form:hidden  path="idUsuario" />
		Usuario: 
<%-- 		<input type="text" name="nombreU" value="${requestScope.usuario.nombreU}" /> --%>
		<form:input  path="nombreU" />
		<br> Contraseña: 
<%-- 		<input type="text" name="contrasena" value="${requestScope.usuario.contrasena}" />  --%>
		<form:input  path="contrasena" />
		<br> Nombres: 
<%-- 		<input type="text" name="nombreP" value="${requestScope.usuario.nombreP}" />  --%>
		<form:input  path="nombreP" />
		<br> Apellido Paterno: 
<%-- 		<input type="text" name="apellidoPP" value="${requestScope.usuario.apellidoPP}" />  --%>
		<form:input  path="apellidoPP" />
		<br> Apellido Materno: 
<%-- 		<input type="text" name="apellidoMP" value="${requestScope.usuario.apellidoMP}" />  --%>
		<form:input  path="apellidoMP" />
		<br> Privilegio: 
<%-- 		<input type="text" name="privilegio" value="${requestScope.usuario.privilegio}" />  --%>
		<form:input  path="privilegio" />
		<br> Fecha de creaci&oacute;n:
<%-- 		<input type="text" name="fechaCreacion" value="${requestScope.usuario.fechaCreacion}" />  --%>
		<form:input path="fechaCreacion"/>
		<br> Correo: 
<%-- 		<input type="text" name="correo" value="${requestScope.usuario.correo}" />  --%>
		<form:input  path="correo" />
		<br> Estatus: 
<%-- 		<input type="text" name="estado" value="${requestScope.usuario.estado}" /> --%>
		<form:input  path="estado" />
		<br> <input type="submit" value="Modificar" />
	</form:form>

</body>
</html>