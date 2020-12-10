<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url(${rawgGame.background_image});
}
td {
	padding-right: 20px;
	padding-left: 10px;
}
.buttonstyle {
	display: block;
	background: #2a9fd6;
	padding: 15px;
	text-align: center;
	border-radius: 10px;
	color: white;
	font-weight: bold;
	line-height: 50px;
}
.buttonstyletwo {
	display: block;
	background: #2a9fd6;
	padding: 5px;
	text-align: center;
	border-radius: 10px;
	color: white;
	font-weight: bold;
	line-height: 40px;
}
.buttonstylethree {
	
	background: #2a9fd6;
	padding: 5px;
	text-align: center;
	border-radius: 10px;
	color: white;
	font-weight: bold;
	line-height: 40px;
}
.tagstyle {
	
	background: #d3d3d3 ;
	padding: 2px;
	text-align: center;
	border-radius: 5px;
	color: black;
	font-weight: bold;
	line-height: 20px;
}
.center {
	margin-left: auto;
	margin-right: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>Recommendations</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
</head>
<body>
	<!-- Logo -->
	<img
		src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX" />

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/">HOME</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/login">Login
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/recommendations">Recommendations</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/about">The Crypt Keepers</a>
				</li>
			</ul>
			<span class="navbar-brand">${ user.username }</span>
    		<a class="btn navbar-btn btn-default navbar-right pull-right" role="button" href="/logout">Logout</a>

			<!-- Search function -->
			<form class="form-inline my-2 my-lg-0" method="post"
				action="/searchresults">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					name="search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
			<!-- **** -->
		</div>
	</nav>
	
	<h1>Recommendations for you, ${user.getUsername() } </h1>
	
	<font size="7">
		<table>
			<thead>
				<tr>
					<th style="color: #2a9fd6;">Game:</th>
					<th style="color: #2a9fd6;">Rating:</th>
					<th></th>
					<th style="color: #2a9fd6;">Genres:</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="game" items="${ games }">
					<tr>
						<td><a class="buttonstyle" href="/details/${ game.getId()}">${ game.getName() }</a></td>
						<td style="width: 300px;">${game.getRating()}/ 5</td>
						<td><img src="${ game.getBackground_image() }"
							alt="${game.getName()}" style="width: 400px; height: auto; border: 5px solid #59A7FF"></td>
						<td><c:forEach var="genre" items="${game.getGenres() }"><font size="5"><a class="tagstyle" href="/searchresults/${genre.getId() }">${genre.getName() }</a></font> </c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</font>

</body>
</html>