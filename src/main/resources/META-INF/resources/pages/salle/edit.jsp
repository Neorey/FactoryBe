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
	<h1>Editer une salle</h1>
	<form:form action="save" method="get" modelAttribute="salle">
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">
				<spring:message code="salle.edit.id" />
			</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		</div>
		<div class="form-group">
			<form:label path="nom">
				<spring:message code="salle.edit.nom" />
			</form:label>
			<form:input path="nom" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="code">
				<spring:message code="salle.edit.code" />
			</form:label>
			<form:input path="code" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="cout">
				<spring:message code="salle.edit.cout" />
			</form:label>
			<form:input path="cout" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="capacite">
				<spring:message code="salle.edit.capacite" />
			</form:label>
			<form:input path="capacite" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="disponibilite">
				<spring:message code="salle.edit.disponibilite" />
			</form:label>
		<form:select path="disponibilite">
			<form:option value="TRUE" label="Oui" />
			<form:option value="FALSE" label="Non" />
		</form:select>
		</div>

		<div class="form-group">
			<button type="submit" class="btn btn-success">
				<spring:message code="salle.edit.save" />
			</button>
			<a href="list" class="btn btn-warning"><spring:message
					code="salle.edit.cancel" /></a>
		</div>

	</form:form>
</body>
</html>