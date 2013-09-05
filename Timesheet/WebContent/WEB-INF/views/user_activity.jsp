<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div id='listetache'>
	<h1>Liste des t�ches assign�es</h1>
	<c:forEach items="${taskList}" var="task">
		<h2>${task.description}</h2>
		<p>heures pr�vues: ${task.getPlannedHours()}
		<br/>heures d�j� prest�es: ${task.getWorkedHours()}
		<br/>�tat de la t�che: ${task.state.name}</p>
		<a href="prestation_add?taskId=${task.id}">prester pour cette t�che</a>
		<h3>liste des prestations d�j� effectu�es</h3>
		<c:forEach items="${task.getChildren()}" var="prestation">
			<div>${prestation.description}</div>
			<div>${prestation.getWorkedHours()}</div>
			<div>${prestation.startDate}</div>
			<div>${prestation.endDate}</div>
		</c:forEach>
	</c:forEach>
	</div>
</div>
</body>
</html>