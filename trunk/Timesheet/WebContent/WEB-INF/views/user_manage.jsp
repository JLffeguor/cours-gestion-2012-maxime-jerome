<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project_manage</title>
</head>
<body>
<a href="add_user"><div>ajouter user</div></a>
<c:forEach items="${usersList}" var="user">
	${user.userName}
</c:forEach>
</body>
</html>