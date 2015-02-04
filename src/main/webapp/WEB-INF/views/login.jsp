<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onload="<c:if test="${msg ne null}">alert('${msg}')</c:if>">

	<c:url value="/Login" var="loginCheck" />

	<form name="formLogin" method="post" action="${loginCheck}">
		<div align="center">
			<table align="center" class="form-noindent">
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" class="Titulo" align="center">SISTEMA DE
						INVENTARIO</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td>
						<table align="center">
							<tr class="Subtitulo">
								<td>Usuario</td>
								<td align="left"><input type="text" name="usuario"
									style="width: 120px;" /></td>
							</tr>
							<tr class="Subtitulo">
								<td>Contraseña</td>
								<td align="left"><input type="password" name="contrasenna"
									style="width: 120px;" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" name="login"
						value="Acceder" /></td>
				</tr>

				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>