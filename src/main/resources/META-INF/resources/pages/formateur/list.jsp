<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body class="container">
<c:import url="../include/log.jsp"></c:import>
<div>
<sec:authorize access="hasRole('ROLE_ADMIN')">Je suis ADMIN !</sec:authorize>
</div>
<div>
<sec:authorize access="hasRole('ROLE_USER')">Je suis USER !</sec:authorize>
</div>
	<h1>
		<spring:message code="formateur.list.title" />
	</h1>
	<a href="add" class="btn btn-link"><spring:message
			code="formateur.list.add" /></a>
	<table class="table">
		<tr>
			<th><spring:message code="formateur.list.header.id" /></th>
			<th><spring:message code="formateur.list.header.name" /></th>
			<th><spring:message code="formateur.list.header.lastname" /></th>
			<th><spring:message code="formateur.list.header.tel" /></th>
			<th><spring:message code="formateur.list.header.adresse" /></th>
			<th></th>
		</tr>
		<c:forEach var="formateur" items="${listeFormateur}">
			<tr>
				<td>${formateur.id}</td>
				<td>${formateur.nom}</td>
				<td>${formateur.prenom}</td>
				<td>${formateur.tel}</td>
				<td>${formateur.adresse}</td>
				<td><a href="edit?id=${formateur.id}" class="btn btn-info"><spring:message
							code="formateur.list.edit" /></a></td>
							
				<td><sec:authorize access="hasRole('ROLE_ADMIN')"><a href="delete?id=${formateur.id}" class="btn btn-danger"><spring:message
							code="formateur.list.delete" /></a></sec:authorize></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>