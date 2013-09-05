<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%} %>
<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="errors">${notification.text}</div>
</c:forEach>
<%} %>
<div id='wrapper'>
	<h1>activité des projets</h1>
	<h2>dernière tâches</h2>
	<c:forEach items="${TaskList}" var="task">
		<h3>description</h3>
		<div>${task.description}</div>
		<h3>date de création</h3>
		<div>${task.createdOn}</div>
		<h3>user assignés à la tâche</h3>
		<c:forEach items="${task.assignedUsers}" var="user">
			<div>${user.key.userName}</div>
		</c:forEach>
	</c:forEach>
</div>
</body>
</html>