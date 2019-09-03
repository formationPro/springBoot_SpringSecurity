<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un employé</title>
</head>
<body>

<c:choose>
	<c:when test="${not empty login }">
		<%@ include file="menuLogged.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="menu.jsp" %>
	</c:otherwise>
</c:choose>

<div class="container">
	<h3>Ajouter un employé</h3>
	
	<form:form  action="add" method="post" modelAttribute="employee">
		<label>Nom de l'employé</label> <br>
		<form:input  path="firstName" placeholder="Nom" /> <br>
		<label>Prénom de l'employé</label> <br>
		<form:input  path="lastName" placeholder="Prénom"/> <br>
		<label>Titre de l'employé</label> <br>
		<form:input  path="title" placeholder="Titre"/> <br>
		<label>Date d'embauche</label> <br>
		<form:input  path="startDate" placeholder="aaaa-mm-jj"/> 
		<form:errors path="startDate" cssClass="errormsg" /><br><br>
		<input type="submit" class="btn btn-success" value="Envoyer">
	</form:form>
</div>

</body>
</html>