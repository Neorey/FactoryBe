<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
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
	<h1>Modification d'une matière</h1>
	<form:form action="save" method="get" modelAttribute="matiere">
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">id:</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		</div>
		<div class="form-group">
			<form:label path="titre">Titre :</form:label>
			<form:input path="titre" cssClass="form-control" />
			<!--<form:errors cssClass="alert alert-danger" path="titre"></form:errors>-->
		</div>
		<div class="form-group">
			<form:label path="niveau">Niveau :</form:label>
			<form:select path="niveau" items="${allNiveau}"
				cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="duree">Durée : </form:label>
			<form:input type="number" path="duree" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="objectifs">Objectifs : </form:label>
			<form:input path="objectifs" cssClass="form-control" />

		</div>
		<div class="form-group">
			<form:label path="prerequis">Prérequis : </form:label>
			<form:input path="prerequis" cssClass="form-control"/>

		</div>

		<div class="form-group">
			<form:label path="contenu">Contenu : </form:label>
			<form:input path="contenu" cssClass="form-control" />

		</div>
		<div class="form-group">
			<form:label path="module.id">Module :</form:label>
			<form:select path="module.id" cssClass="form-control">
				<form:options items="${allModules}" itemLabel="nomModule" itemValue="id" />
			</form:select>
			
		</div>
		
		
		
		<div class="form-group">
			<button type="submit" class="btn btn-success">Enregistrer</button>
			<a href="list" class="btn btn-warning">Annuler</a>
		</div>
	</form:form>
</body>
</html>