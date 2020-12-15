<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/FailedLogin</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
<style>
	h2 {
	padding-top: 20px;
	text-align: center;
	}

	li {
	font-size: 20px;
	}
	
</style>
</head>
<body>
	<!-- Logo -->

	<a href="/"><img src="https://drive.google.com/uc?id=1fPjNndqQhYAMUy6HG5YUGc0MUmmhZncH" style=" padding-left: 35%"/></a>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/" style="font-size: 20px;">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active" style="font-size: 20px;"><a class="nav-link" href="/login">Login		
				</a></li>
				<li class="nav-item" style="font-size: 20px;"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>

				<li class="nav-item" style="font-size: 20px;"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item" style="font-size: 20px;"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
      		<li class="nav-item" style="font-size: 20px;"><a class="nav-link" href="/popular2019">Most
						popular of 2019</a></li>
			</ul>
				<span class="navbar-brand">${ user.username }</span>
    		<c:if test = "${user.username != null}">
    		<a class="btn navbar-btn btn-default navbar-right pull-right" role="button" href="/logout">Logout</a> 
			</c:if>

			<form class="form-inline my-2 my-lg-0" method="post"
				action="/searchresults">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					name="search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<h2>Sorry, your Email or Password was invalid.<br/>Please try again.</h2>


</body>
</html>