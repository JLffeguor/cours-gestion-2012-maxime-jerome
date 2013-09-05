<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="be.util.NotificationUtil" %>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add user</title>
</head>
<body>
<% if (session.getAttribute("errors") != null) {%>
<c:forEach items="${sessionScope['errors']}" var="error">
	<div class="errors">${error.text}</div>
</c:forEach>
<%}%>

<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="errors">${notification.text}</div>
</c:forEach>
<%} NotificationUtil.reset();%>
<a href="dashboard" id="dashboardLink">retourner à l'accueil</a>
<div id='wrapper'>
<div id='formu'>
	<form action="task_submit">
		<input type="hidden" value="${projectId}" name="projectId"/>
		<label for="description">description : </label> <input type="text" name="description"/>
		<label for="plannedHours">heures prévues : </label> <input type="number" name="plannedHours"/>
		<label for="userNameList">utilisateurs assignés (séparé par des virgules)  : </label> <input type="text" name="userNameList"/>
		<p><input type="submit" value="add task" /></p>
	</form>
	</div>
</div>
</body>
</html>