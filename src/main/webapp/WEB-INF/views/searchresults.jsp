<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Crypt</title>
<style type="text/css">
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
</head>
<body>
	<!-- Logo -->
	<img
		src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX" />

	<h1>ALL YOUR GAMING NEEDS</h1>
	<!--********************  Begin Nav Bar ********************-->
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
				<li class="nav-item"><a class="nav-link" href="#">Wishlist</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Recommendations</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">About US!</a>
				</li>
			</ul>

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
	<!--******************** End Nav Bar  ********************-->

	<h2>Search Results</h2>
	<c:forEach var="games" items="${ games }">
		<a href="/details/${ games.getId()} }">${ games.getName() } <br />
		<img src=" ${ games.getBackground_image() }"
			alt="${games.getName()} image " width=20% height="auto" /><br />
		<br /></a>
	</c:forEach>

</body>
</html>