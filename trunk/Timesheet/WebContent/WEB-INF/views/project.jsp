<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
<%} %>
<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="errors">${notification.text}</div>
</c:forEach>
<%} %>
<div id='wrapper'>
	<h1>${project.name}</h1>
	
	<h2>T�ches du projet</h2>
	<div id = 'tacheProject'>
		
		<c:forEach items="${TaskList}" var="task">
		<p>Description :  ${task.description}<p>
		<p>Et�t :  ${task.state.name}<p>
		<div></div>
		
		<p>User assign�s :<p>
		<c:forEach items="${task.assignedUsers}" var="user">
				<div id='usernameTP'>${user.key.userName}</div>
			</c:forEach>-------------
		</c:forEach>
	</div>
	<a href="task_add?projectId=${project.id}"><h3>ajouter une t�che</h3></a>
	
	<h2>users assign�s au projet</h2>
	<div id='formu'>
	<form action="project_assigne_user">
		<input type="hidden" value="${project.id}" name="projectId"/>
		<label for="userNameList">assigner d'autre utlisateurs (s�par� par des virgules)  : </label> <input type="text" name="userNameList"/>
		<input type="submit" value="assigne user" />
	</form>
	</div>
	<c:forEach items="${project.assignedUsers}" var="user">
		<div>UserName : ${user.key.userName}</div>
		<div>Role : ${user.value}</div>--------
	</c:forEach>
</div>
</body>
</html>