<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update medicine</title>
<link href="css/style.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Pontano Sans' rel='stylesheet'>
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
	<jsp:include page="errorCatcher.jsp"></jsp:include>
 	<div class="wrapper">
 		<form action="update?id=${medicine.id}" method="post" class="vertical-container" enctype="multipart/form-data">
 			<ul>
				<label for="header">Name: </label>
				<li><input type="text" name="header" value="${medicine.header}"/></li>
				<li><label for="text">Description: </label>
					<textarea name="text">${medicine.text}</textarea></li>
				<li><label for="pharmacist">Teacher: </label>
					<input type="text" name="pharmacist" value="${medicine.createdBy.username}"/></li>
				<li><label for="type">Type of lesson: </label>
					<select name="type" id="type" form="type">
						<option value="LIQUID">LESSON</option>
						<option value="TABLETS">CONSULTATION</option>
						<option value="MIXTURE" selected>SESSION</option>
					</select></li>
			</ul>
 			<input class="btn-grad" type="submit" value="Update" />
 		</form>
 	</div>
</body>
</html>