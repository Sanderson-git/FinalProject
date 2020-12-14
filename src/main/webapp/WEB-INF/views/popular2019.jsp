<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<style>
h2 {
	padding-top: 20px;
	text-align: center;
}

li {
	font-size: 20px;
}

th {
	padding-right: 20px;
	padding-left: 20px;
}

td {
	padding-right: 20px;
	padding-left: 20px;
	width: 25%;
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

.tagstyle {
	background: #d3d3d3;
	padding: 2px;
	text-align: center;
	border-radius: 5px;
	color: black;
	font-weight: bold;
	line-height: 20px;
}
</style>

<!-- Bootstrap link -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Crypt/Popular2019</title>
</head>

<body>
<!-- Logo -->
	<img
		src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX"
		style="padding-left: 35%" />
<!-- Nav Bar-->		
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/popular2019">Most popular of 2019</a></li>
				<li class="nav-item"><a class="nav-link" href="/login">Login
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
			</ul>
			<span class="navbar-brand">${ user.username }</span> <a
				class="btn navbar-btn btn-default navbar-right pull-right"
				role="button" href="/logout">Logout</a>

<!-- Search function -->
			<form class="form-inline my-2 my-lg-0" method="post"
				action="/searchresults">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					name="search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<h2>Most popular games of 2019!</h2>
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

				<c:forEach var="result" items="${ rawglist.getResults()}">
					<tr>
						<td style="width: 35%;"><img
							src="${result.getBackground_image() }"
							style="width: 600px; height: 350; border: 5px solid #59A7FF"></td>
						<td><a class="buttonstyle" href="/details/${result.getId() }">${result.getName()}</a></td>
						<td style="width: 10%;">${result.getRating()}/5</td>

						<td><c:forEach var="genre" items="${result.getGenres() }">
								<font size="5"><a class="tagstyle"
									href="/searchresults/${genre.getId() }">${genre.getName() }</a></font>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</font>
</body>
</html>