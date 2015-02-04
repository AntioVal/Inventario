<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informaci&oacuten de usuario</title>
</head>
<body>
	<p>Informaci&oacuten de usuario</p>
	<c:url value="/guardar" var="urlGuardar" />
	<form:form action="${urlGuardar}">
		<input type="hidden" value="${usuario.idUsuario}" name="idUsuario" />
		Usuario: <input type="text" name="nombreU" value="${usuario.nombreU}" />
		<br> Contraseña: <input type="text" name="contrasena"
			value="${usuario.contrasena}" /> <br> Nombres: <input
			type="text" name="nombreP" value="${usuario.nombreP}" /> <br>
		Apellido Paterno: <input type="text" name="apellidoPP"
			value="${usuario.apellidoPP}" /> <br> Apellido Materno: <input
			type="text" name="apellidoMP" value="${usuario.apellidoMP}" /> <br>
		Privilegio: <input type="text" name="privilegio"
			value="${usuario.privilegio}" /> <br> Fecha de creaci&oacute;n:
		<input type="text" name="fechaCreacion"
			value="${usuario.fechaCreacion}" /> <br> Correo: <input
			type="text" name="correo" value="${usuario.correo}" /> <br>
		Estatus: <input type="text" name="estado" value="${usuario.estado}" />
		<br> <input type="submit" value="Modificar" />
	</form:form>

</body>
</html>