<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project_manage</title>
</head>
<body>
<div id='wrapper'>
<div id='lien'>
<c:if test="${admin}">
	<a href="user_add"><div>Creer un nouvel utilisateur</div></a>
	<c:forEach items="${usersList}" var="user">
		${user.userName}
	</c:forEach>
	</c:if>
	</div>
</div>
</body>
</html>