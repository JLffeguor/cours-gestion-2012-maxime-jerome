<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add user</title>
</head>
<body>
<form action="project_submit">
	<label for="projectName">name : </label> <input type="text" name="projectName"/><br/>
	<label for="description">description : </label> <input type="text" name="description"/>
	<label for="projectManagerUserName">projectManager userName : </label> <input type="text" name="projectManagerUserName"/>
	<input type="submit" value="add project" />
</form>
</body>
</html>