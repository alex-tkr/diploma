<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of medicines</title>
<link href="css/style.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Pontano Sans' rel='stylesheet'>
</head>
<body>

<jsp:include page="jspf/head.jspf"></jsp:include>
	<jsp:include page="errorCatcher.jsp"></jsp:include>
 	<div class="wrapper">
 		<form action="add" method="post" class="vertical-container" enctype="multipart/form-data">
			<ul>
				<li><label for="header">Header: </label>
					<input type="text" name="header" /></li>
				<li><label for="text">Text: </label>
					<textarea name="text"></textarea></li>
				<li><label for="pharmacist">Teacher: </label>
					<input type="text" name="pharmacist" /></li>
				<li><label for="type">Type: </label>
					<select name="type" id="type" form="type">
						<option value="LIQUID">LESSON</option>
						<option value="TABLETS">CONSULTATION</option>
						<option value="MIXTURE" selected>SESSION</option>
					</select></li>
			</ul>

 			<input class="btn-grad" type="submit" value="Add" />
 		</form>
 	</div>
</body>
</html>