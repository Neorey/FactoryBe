<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition</title>
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
	<h1>Editer un formateur</h1>
	<form:form action="save" method="get" modelAttribute="formateur">
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">
				<spring:message code="formateur.edit.id" />
			</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		</div>
		<div class="form-group">
			<form:label path="nom">
			<spring:message code="formateur.edit.name" />
			</form:label>
			<form:input path="nom" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="prenom">
			<spring:message code="formateur.edit.lastname" />
			</form:label>
			<form:input path="prenom" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="adresse">
			<spring:message code="formateur.edit.adresse" />
			</form:label>
			<form:input path="adresse" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="tel">
			<spring:message code="formateur.edit.tel" />
			</form:label>
			<form:input path="tel" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<button type="submit" class="btn btn-success">
				<spring:message code="formateur.edit.save" />
			</button>
			<a href="list" class="btn btn-warning"><spring:message
					code="formateur.edit.cancel" /></a>
		</div>

	</form:form>
</body>
</html>