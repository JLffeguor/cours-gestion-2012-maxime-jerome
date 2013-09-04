<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add user</title>
</head>
<body>
	<form action="task_submit">
		<input type="hidden" value="${projectId}" name="projectId"/>
		<label for="description">description : </label> <input type="text" name="description"/>
		<label for="plannedHours">heures prévues : </label> <input type="number" name="plannedHours"/>
		<label for="userNameList">utilisateurs assignés (séparé par des virgules)  : </label> <input type="text" name="userNameList"/>
		<input type="submit" value="add task" />
	</form>
</body>
</html>