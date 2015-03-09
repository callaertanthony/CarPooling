<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Gestion des membres</title>
</head>
<body>
	<form method="get" action="membre" class="form-search">
		<div class="input-append">
			<input type="text" name="id" placeholder="identifiant du membre" class="span2 search-query"/>
			<button type="submit" class="btn btn-primary btn-sm">Rechercher</button>
		</div>
	</form>
	<c:choose>
		<c:when test="${!empty getMembre}">
			<fieldset>
				<legend>Informations Membre</legend>
				<table class="table table-condensed">
					<tr>
						<th width="10%">Identifiant</th>
						<th width="10%">Nom</th>
						<th width="10%">Prenom</th>
					</tr>
					<tr>
						<td>${getMembre.getID()}</td>
						<td>${getMembre.getNomMembre()}</td>
						<td>${getMembre.getPrenomMembre()}</td>
					</tr>
				</table>
			</fieldset>
		</c:when>
		<c:when test="${!empty listMembres}">
			<fieldset>
				<legend>Liste des membres</legend>
				<table class="table table-condensed">
					<tr>
						<th width="80">IdMembre</th>
						<th width="80">NomMembre</th>
						<th width="80">PrenomMembre</th>
					</tr>
					<c:forEach items="${listMembres}" var="membre">
						<tr>
							<td>${membre.getID()}</td>
							<td>${membre.getNomMembre()}</td>
							<td>${membre.getPrenomMembre()}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>
		</c:when>
	</c:choose>
	<!-- - -->
	<legend>Nouveau membre</legend>
	<form:form method="POST" modelAttribute="membre" action="membres"
		class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="nomMembre">Nom</label>
				<div class="col-md-7">
					<form:input type="text" path="nomMembre" id="nomMembre"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="nomMembre" class="error" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="prenomMembre">Prenom</label>
				<div class="col-md-7">
					<form:input type="text" path="prenomMembre" id="prenomMembre"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="prenomMembre" class="error" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<div class="form-actions floatRight">
					<input type="submit" value="New" class="btn btn-primary btn-sm" />
				</div>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form:form>
</body>
</html>