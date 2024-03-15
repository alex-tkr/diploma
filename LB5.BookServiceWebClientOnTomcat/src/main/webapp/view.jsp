<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View a medicine</title>
<link href="css/style.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Pontano Sans' rel='stylesheet'>
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
	<jsp:include page="errorCatcher.jsp"></jsp:include>
 	<c:choose>
 	<c:when test="${not empty errorMsg }">
		<h2>${errorMsg }</h2>
 	</c:when>
	<c:otherwise>

		<div class="vertical-container">
			<ul>
				<li><a href="view?id=${medicine.id}"><h1>${medicine.header}</h1></a></li>
				<li><span>${medicine.text}</span></li>
				<li><b>Created by @${medicine.createdBy.username}</b></li>
				<li><i>Created at ${medicine.date}</i></li>
				<i>${medicine.type}</i>
			</ul>


			<div>
				<c:forEach var="description" items="${medicine.descriptions.description }">
					<div class="vertical-container">
						<span>${description.text}</span>
						<i>Created at ${description.date}</i>
						<b>Created by @${description.createdBy.username}</b>
					</div>
				</c:forEach>
			</div>
			<form action="delete" method="post">
				<input type="hidden" name="id" value="${medicine.id }">
				<input class="btn-grad" type="submit" value="Delete">
				<a class="btn-small" href="update?id=${medicine.id}">Edit</a>
			</form>

		</div>
	</c:otherwise>
	</c:choose>
	
	<% session.removeAttribute("medicine"); %>
</body>
</html>