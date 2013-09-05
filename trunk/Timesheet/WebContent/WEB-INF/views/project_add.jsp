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
<div id='wrapper'>
<div id='formu'>
<form action="project_submit">
	<label for="projectName">Name : </label> <input type="text" name="projectName"/><br/>
	<label for="description">Description : </label> <input type="text" name="description"/>
	<label for="projectManagerUserName">ProjectManager UserName : </label> <input type="text" name="projectManagerUserName"/>
	<p><input type="submit" value="add project" /></p>
</form>
</div>
</div>
</body>
</html>