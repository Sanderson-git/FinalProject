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
.padded {
  padding-top: 5px;
  padding-bottom: 5px;
   float: right;
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
				<li class="nav-item"><a class="nav-link" href="/login">Login		
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/popular2019">Most popular of 2019
					<span class="sr-only">(current)</span></a></li>
					
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
	<div class="container">
		<div class="row">
			<div class="col-lg-1">
			</div>
			<div class="col-lg-10 center">
				<h2>Most popular games of 2019!</h2>
			</div>
			<div class="col-lg-1">
			</div>
		</div>
	</div>
<font size="5">
		<div class="container">
			<div class="row">
				<div class="col-lg-1" style="color: #2a9fd6;"></div>
				<div class="col-lg-4" style="color: #2a9fd6;"></div>
				<div class="col-lg-4" style="color: #2a9fd6;">Game:</div>
				<div class="col-lg-1" style="color: #2a9fd6;">Rating:</div>
				<div class="col-lg-1" style="color: #2a9fd6;">Genres:</div>
				<div class="col-lg-1" style="color: #2a9fd6;"></div>
			</div>
				<c:forEach var="result" items="${ rawglist.getResults()}">
					<div class="row">
						<div class="col-lg-1" style="color: #2a9fd6;"></div>
						<div class="col-lg-4 padded" > <a href="/details/${result.getId() }" data-toggle="tooltip" data-placement="right" title="View Game Details"><img src="${result.getBackground_image() }"	style="width:100%; height:auto; border: 5px solid #59A7FF"></a></div>
						<div class="col-lg-4" style="color: #2a9fd6;"><a class="buttonstyle" href="/details/${result.getId() }" data-toggle="tooltip" data-placement="right" title="View Game Details">${result.getName()}</a></div>
						<div class="col-lg-1" >${result.getRating()}/5</div>
						<div class="col-lg-2" ><c:forEach var="genre" items="${result.getGenres() }"><font size="5"><a class="tagstyle" href="/searchresults/${genre.getId() }" data-toggle="tooltip" data-placement="right" title="Search for ${genre.getName() } games">${genre.getName() }</a></font> </c:forEach></div>
					</div>
				</c:forEach>
			</div>
	</font>

</body>
</html>