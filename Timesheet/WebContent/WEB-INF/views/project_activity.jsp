<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="be.util.NotificationUtil" %>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user_activity</title>
</head>
<body>
<% if (session.getAttribute("errors") != null) {%>
<c:forEach items="${sessionScope['errors']}" var="error">
	<div class="errors">${error.text}</div>
</c:forEach>
<%}%>

<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="notifications">${notification.text}</div>
</c:forEach>
<%} NotificationUtil.reset();%>
<a href="dashboard" id="dashboardLink">retourner � l'accueil</a>
<div id='wrapper'>
	<h1>activit� des projets</h1>
	<h2>derni�re t�ches</h2>
	<c:forEach items="${TaskList}" var="task">
		<h3>${task.description}</h3>
		<p>heures pr�vues: ${task.getPlannedHours()}
		<br/>heures d�j� prest�es: ${task.getWorkedHours()}
		<br/>�tat de la t�che: ${task.state.name}</p>
		<h4>user assign�s � la t�che</h4>
		<c:forEach items="${task.assignedUsers}" var="user">
			<div>${user.key.userName}</div>
		</c:forEach>
	</c:forEach>
</div>
</body>
</html>