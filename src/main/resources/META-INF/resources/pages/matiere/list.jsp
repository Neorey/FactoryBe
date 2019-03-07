<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matières</title>
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
	
	<h1>Liste des matières</h1>
	<a href="add" class="btn btn-link">Ajouter une matière</a>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Titre</th>
			<th>Durée</th>
			<th>Objectifs</th>
			<th>Prérequis</th>
			<th>Contenu</th>
			<th>Niveau</th>
			<th>Module Id</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="matiere" items="${listeMatiere}">
			<tr>
				<td>${matiere.id}</td>
				<td>${matiere.titre}</td>
				<td>${matiere.duree}</td>
				<td>${matiere.objectifs}</td>
				<td>${matiere.prerequis}</td>
				<td>${matiere.contenu }</td>
				<td>${matiere.niveau}</td>
				<td>${matiere.module.id }</td>

				<td><a href="edit?id=${matiere.id}" class="btn btn-info">Modifier</a></td>
				<td><!--  sec:authorize access="hasRole('ROLE_GESTIONNAIRE')"-->
						<a href="delete?id=${matiere.id}" class="btn btn-danger">Supprimer</a>
					<!-- /sec:authorize--></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>