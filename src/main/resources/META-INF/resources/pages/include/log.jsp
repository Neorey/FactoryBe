<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal !=null}">
		<div>
			Bonjour ${pageContext.request.userPrincipal.name}&nbsp; <a
				href="../logout" class="btn btn-link"> se déconnecter</a>
		</div>
	</c:if>
</body>
</html>