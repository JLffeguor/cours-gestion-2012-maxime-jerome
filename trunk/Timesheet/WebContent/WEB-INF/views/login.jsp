<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">

<meta charset="ISO-8859-1">

<title>Login</title>
</head>
<body>
<div id='wrapper'>
<div id="loginpanel" >
<h3>Application Time Sheet</h3>
	<form action="loginsubmit" >
		<p><label for="identifier" >login : </label> <input type="text" name="identifier"/></p>
		<p><label for="paswword">password : </label> <input type="password" name="password"/></p>
		<p><input type="submit" value="login" /></p>
	</form>
	</div>
</div>
</body>
</html>