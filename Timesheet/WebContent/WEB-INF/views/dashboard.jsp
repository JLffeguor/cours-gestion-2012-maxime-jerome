<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dashBoard</title>
</head>
<body>
<% if (session.getAttribute("errors") != null) {%>
<c:forEach items="${sessionScope['errors']}" var="error">
	<div class="errors">${error.text}</div>
</c:forEach>
<%} %>
<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="errors">${notification.text}</div>
</c:forEach>
<%} %>
<div id='wrapper'>
	<div id="project_manage"><a href="project_manage">Gestion des projets Ajout/Suppression</a></div>
	<div id="project_activity"><a href="project_activity">Vérifier l'activité du projet</a></div>
	<div id="user_manage"><a href="user_manage">Gestion des utilisateur Ajout/Suppression</a></div>
	<div id="user_activity"><a href="user_activity">Gestion des prestation des User</a></div>
</div>
</body>
</html>