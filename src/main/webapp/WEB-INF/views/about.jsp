<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>

<style type="text/css">
body {
	background-image: url(${rawgGame.background_image});
}
.buttonstyle {
	
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
.center {
	margin-left: auto;
	margin-right: auto;
}

.img1 {
	border-radius: 45%;
	}

table {
	width: 100%;
}

td {
	text-align: center;
	font-weight: bold;
	font-family: Geneva;
}

.r1 {
	font-size: 30px;
	
	}
	
p {
	text-align: center;
	font-size: 20px;
	font-weight: bold;
}	
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">

</head>
<body>
	<!-- Logo -->
	<img src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX"/>

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
				<li class="nav-item"><a class="nav-link" href="/about">About US!</a>
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
		
		
		
		<table>
			<thead>
				<tr>
					<th style= "padding: 20px 0px 20px 70px; "><img class="img1" src="https://media-exp1.licdn.com/dms/image/C4E03AQEvY6jYIOUNhg/profile-displayphoto-shrink_800_800/0/1602263500660?e=1613001600&v=beta&t=Z2vECuXIdDQ8dwksz70wod7aF6aNFCcAHa2opdAFm3U" width="300px"/></th>
					<th style= "padding: 20px 0px 20px 70px;"><img class="img1" src="https://media-exp1.licdn.com/dms/image/C4E35AQG6XMXDx7x2Hg/profile-framedphoto-shrink_800_800/0/1604064742009?e=1607706000&v=beta&t=ZZ_OsBwRnCq4r5L5KSQEYdgyXBdvU4wNOAI8VDbhR1M" width="300px" /></th>
					<th style= "padding: 20px 0px 20px 70px;"><img class="img1" src="https://media-exp1.licdn.com/dms/image/C4E03AQGhJY4HELmlog/profile-displayphoto-shrink_800_800/0/1606831490520?e=1613001600&v=beta&t=w_eQ92QBk2DDl_pcPehp1jBP-0tF5jaeN_8QGJGZuRA" width="300px" /></th>
					<th style= "padding: 20px 0px 20px 70px;"><img class="img1" src="https://media-exp1.licdn.com/dms/image/C4D35AQGoL23Tk9E6xg/profile-framedphoto-shrink_200_200/0/1604066490107?e=1607706000&v=beta&t=VZ31uUZAoWKhDvOarsWIHZvK8tYbKD6CJ7cogbmUuog" width="300px" />
			</th>
				</tr>
			</thead>
			<tbody>
					<tr class="r1">
						<td class="r1"><a href="https://www.linkedin.com/in/schuyler-bishop/">Skye B</a><br/>Developer<br /></td>
						<td class="r1"><a href="https://www.linkedin.com/in/sean-anderson-2b5b9b1b9/">Sean A</a><br/>Developer<br /></td>
						<td class="r1"><a href="https://www.linkedin.com/in/jayme-ipema-b5846619/">Jayme I</a><br/>Developer<br /></td>
						<td class="r1"><a href="https://www.linkedin.com/in/michaelmedling/">Michael M</a><br/>Developer<br /></td>
					</tr>
					<tr >
						<td><p>Blah Blah Blah Blah</p></td><!-- Skye -->
						<td><p>Blah Blah Blah Blah</p></td><!-- Sean -->
						<td><p>Blah Blah Blah Blah</p></td><!-- Jayme -->
						<td><p>Steam? never heard of it...</p></td><!-- Mike -->
					</tr>
			</tbody>
		</table>
		<br />
		<div>
			<p>We are just a few broke game players looking to save a buck and continue on gamin, so we made Crypt to help everyone Game On while being on a budget!<br />Hurray for the nerds!</p>
			<img src="https://i.imgflip.com/4puq2v.jpg" style=" padding-left: 35%"/>
		</div>
</body>
</html>