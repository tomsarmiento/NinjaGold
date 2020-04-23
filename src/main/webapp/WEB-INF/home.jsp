<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<link href="css/home.css" type="text/css" rel="stylesheet" />
		<script>
			$( document ).ready(function() {
				<c:forEach var="mensaje" items="${mensajes}">
					var msg = '<c:out value="${mensaje}"/>'
					if(msg.includes("lost")){
						$('.info').append("<h4 style='color:red;'>"+msg+"</h4>");
					}
					else{
						$('.info').append("<h4 style='color:green;'>"+msg+"</h4>");
					}
					
				</c:forEach>
			});
		</script>
	</head>
	<body>
		<div class="container">
			<h4>Your gold: <c:out value="${totalGold }"></c:out></h4>
			<div class="activities">
				<div>
					<h4>Farm</h4>
					<h4>(earns 10-20 gold)</h4>
					<form action="/farm" method="post">
						<input type="text" value="exampletext" name="farm" hidden=true>
						<input type="submit" value="Find gold!">
					</form>
				</div>
				<div>
					<h4>Cave</h4>
					<h4>(earns 5-10 gold)</h4>
					<form action="/cave" method="post">
						<input type="text" value="exampletext" name="cave" hidden=true>
						<input type="submit" value="Find gold!">
					</form>
				</div>	
				<div>
					<h4>House</h4>
					<h4>(earns 2-5 gold)</h4>
					<form action="/house" method="post">
						<input type="text" value="exampletext" name="house" hidden=true>
						<input type="submit" value="Find gold!">
					</form>
				</div>
				<div>
					<h4>Casino</h4>
					<h4>(earns/takes 0-50 gold)</h4>
					<form action="/casino" method="post">
						<input type="text" value="exampletext" name="casino" hidden=true>
						<input type="submit" value="Find gold!">
					</form>
				</div>
			</div>
			<h4>Activities: </h4>
			<div class="info">
				
			</div>
			<a href="/reset">Reset</a>
		</div>
	</body>
</html>