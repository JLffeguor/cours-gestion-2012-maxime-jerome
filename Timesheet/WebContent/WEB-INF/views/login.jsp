<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="be.util.NotificationUtil" %>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet type="text/css" href="/Timesheet/timesheet.css">

<meta charset="ISO-8859-1">

<title>Login</title>
</head>
<body>
<% if (session.getAttribute("errors") != null) {%>
<c:forEach items="${sessionScope['errors']}" var="error">
	<div class="errors">${error.text}</div>
</c:forEach>
<%}%>

<% if (session.getAttribute("notifications") != null) {%>
<c:forEach items="${sessionScope['notifications']}" var="notification">
	<div class="errors">${notification.text}</div>
</c:forEach>
<%} NotificationUtil.reset();%>
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