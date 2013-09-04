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
	<h1>liste des t�ches assign�es</h1>
	<c:forEach items="${taskList}" var="task">
		<h2>${task.description}</h2>
		<a href="prestation_add?taskId=${task.id}">prester pour cette t�che</a>
		<h3>liste des prestations d�j� effectu�es</h3>
		<c:forEach items="${task.getChildren()}" var="prestation">
		<div>${prestation.description}</div>
		<div>${prestation.startDate}</div>
		<div>${prestation.endDate}</div>
		</c:forEach>
	</c:forEach>
</body>
</html>