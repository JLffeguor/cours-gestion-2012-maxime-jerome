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
	<c:if test="${canCreateProject}">
		<a href="project_add"><div>ajouter projets</div></a>
	</c:if>

	<c:forEach items="${projectList}" var="project">
		${project.name}
	</c:forEach>
</body>
</html>