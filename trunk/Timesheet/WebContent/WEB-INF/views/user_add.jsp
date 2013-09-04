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
<form action="registersubmit">
	<label for="identifier">login : </label> <input type="text" name="identifier"/><br/>
	<label for="paswword">password : </label> <input type="password" name="password"/>
	<input type="submit" value="register" />
</form>
</body>
</html>