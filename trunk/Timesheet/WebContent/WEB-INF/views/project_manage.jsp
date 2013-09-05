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
	<div id='lien'>
	<c:if test="${canCreateProject}">
		<a href="project_add"><div>Ajouter un nouveau projet</div></a>
		</c:if>

	<c:forEach items="${projectList}" var="project">
		<a href="project?projectId=${project.id}"><div>${project.name}</div></a>
	</c:forEach>
	</div>
	</div>
</body>
</html>