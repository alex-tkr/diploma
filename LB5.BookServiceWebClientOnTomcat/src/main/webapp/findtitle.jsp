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
 	<div>
 		<form class="vertical-container" action="findtitle" method="get">
 			<label for="pattern">Title: </label>
 			<input class="textarea" type="text" name="pattern" />
 			<input type="submit" class="btn-grad" value="Find" />
 		</form>
 	</div>
</body>
</html>