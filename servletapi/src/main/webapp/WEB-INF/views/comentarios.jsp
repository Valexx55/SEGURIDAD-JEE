<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>COMENTARIOS</h1>
	<form action="publica" method="post">
		<input type="text" name="comentario">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		${pageContext.session.id}
		${sessionScope.nombre}
		<input type="submit" name="DALE">
	</form>
</body>
</html>