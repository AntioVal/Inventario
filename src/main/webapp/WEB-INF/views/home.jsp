<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<c:url value="/usuario/" var="url" />
<c:url value="/nuevoUsuario" var="urlNuevo" />
<h1>
	Bienvenido  
</h1>

<P>  <c:out value="${usuario.nombreU}"></c:out> </P>

Menu: <ul>
		<li>
		<a href="${url}${usuarioSession.idUsuario}">Mi cuenta</a>
		</li>
		<li>
		<a href="${urlNuevo}">Nuevo usuario</a>
		</li>		
		</ul>
</body>
</html>
