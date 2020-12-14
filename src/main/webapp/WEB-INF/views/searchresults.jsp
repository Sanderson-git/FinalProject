<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/Results</title>
<style type="text/css">
td {
	padding-right: 20px;
	padding-left: 10px;
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

</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
</head>
<body>
	<!-- Logo -->

	<a href="/"><img src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX" style=" padding-left: 35%"/></a>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/" style="font-size: 16px;">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/login">Login		
				</a></li>
				<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>

				<li class="nav-item" style="font-size: 16px;"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
      		<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/popular2019">Most
						popular of 2019</a></li>
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
		</div>
	</nav>

	<h2>Search Results</h2>
	
	<font size="7">
		<table>
			<thead>
				<tr>
					<th></th>
					<th style="color: #2a9fd6; font-size: 30px;">Games:</th>
					<th style="color: #2a9fd6; font-size: 30px;">Rating:</th>
					<th style="color: #2a9fd6; font-size: 30px;">Genres:</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="games" items="${ games }">
					<tr>
						<td style="width: 35%;"><a href="/details/${ games.getId()}"> <img src="${ games.getBackground_image() }"></a>
							alt="${games.getName()}" style="width: 600px; height: 350px; border: 5px solid #59A7FF"></td>
						<td><a class="buttonstyle" href="/details/${ games.getId()}">${ games.getName() }</a></td>
						<td style="width: 10;">${games.getRating()}/ 5</td>
						<td><c:forEach var="genre" items="${games.getGenres() }"><font size="5"><a class="tagstyle" href="/searchresults/${genre.getId() }">${genre.getName() }</a></font> </c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</font>

</body>
</html>