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
	<h1>${project.name}</h1>
	
	<h2>T�ches du projet</h2>
	<c:forEach items="${TaskList}" var="task">
		<h3>description</h3>
		<div>${task.description}</div>
		<h3>user assign�s � la t�che</h3>
		<c:forEach items="${task.assignedUsers}" var="user">
			<div>${user.key.userName}</div>
		</c:forEach>
	</c:forEach>
	
	<a href="task_add?projectId=${project.id}"><h3>ajouter une t�che</h3></a>
	
	<h2>users assign�s au projet</h2>
	<c:forEach items="${project.assignedUsers}" var="user">
		<div>${user.key.userName}</div>
		<div>${user.value}</div>
	</c:forEach>

</body>
</html>