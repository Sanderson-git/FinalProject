<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About the Cryptkeepers</title>

<style type="text/css">

	
.padded {
  padding-top: 10px;
   float: right;
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

.centered {
  text-align: center;
  padding: 15px;
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
				<li class="nav-item"><a class="nav-link" href="/recommendations">Recommendations</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="/about">The Crypt Keepers
				<span class="sr-only">(current)</span>
				</a></li>
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
		
		
		
<div class="container">
			<div class="row">

				<div class="col-lg-3"><img class="img1 padded" src="https://media-exp1.licdn.com/dms/image/C4E03AQEvY6jYIOUNhg/profile-displayphoto-shrink_800_800/0/1602263500660?e=1613001600&v=beta&t=Z2vECuXIdDQ8dwksz70wod7aF6aNFCcAHa2opdAFm3U" width="100%"/></div>
				<div class="col-lg-3"><img class="img1 padded" src="https://media-exp1.licdn.com/dms/image/C4E35AQG6XMXDx7x2Hg/profile-framedphoto-shrink_800_800/0/1604064742009?e=1607706000&v=beta&t=ZZ_OsBwRnCq4r5L5KSQEYdgyXBdvU4wNOAI8VDbhR1M" width="100%"/></div>
				<div class="col-lg-3"><img class="img1 padded" src="https://media-exp1.licdn.com/dms/image/C4E03AQGhJY4HELmlog/profile-displayphoto-shrink_800_800/0/1606831490520?e=1613001600&v=beta&t=w_eQ92QBk2DDl_pcPehp1jBP-0tF5jaeN_8QGJGZuRA" width="100%" /></div>
				<div class="col-lg-3"><img class="img1 padded" src="https://media-exp1.licdn.com/dms/image/C4D03AQF0zfpIBjTadQ/profile-displayphoto-shrink_200_200/0/1607627453802?e=1613001600&v=beta&t=zfODTeM_EwIl8Y8Wfw8P8N0KPul0B6IwSbyBqyLhlsc" width="100%" /></div>
			</div>
		</div>
<font size="5">
	<div class="container">
			<div class="row">
				<div class="col-lg-3 centered"><a href="https://www.linkedin.com/in/schuyler-bishop/" target="_blank" data-toggle="tooltip" data-placement="right" title="Connect on LinkedIn">Skye B</a><br/><a href="https://github.com/skyebishop" target="_blank"  data-toggle="tooltip" data-placement="right" title="More Code on GitHub">Developer</a><br /></div>
				<div class="col-lg-3 centered"><a href="https://www.linkedin.com/in/sean-anderson-2b5b9b1b9/" target="_blank" data-toggle="tooltip" data-placement="right" title="Connect on LinkedIn">Sean A</a><br/><a href="https://github.com/Sanderson-git" target="_blank" data-toggle="tooltip" data-placement="right" title="More Code on GitHub">Developer</a></div>
				<div class="col-lg-3 centered"><a href="https://www.linkedin.com/in/jayme-ipema-b5846619/" target="_blank" data-toggle="tooltip" data-placement="right" title="Connect on LinkedIn">Jayme I</a><br/><a href="https://github.com/teacuptrex" target="_blank" data-toggle="tooltip" data-placement="right" title="More Code on GitHub">Developer</a></div>
				<div class="col-lg-3 centered"><a href="https://www.linkedin.com/in/michaelmedling/" target="_blank" data-toggle="tooltip" data-placement="right" title="Connect on LinkedIn">Michael M</a><br/><a href="https://github.com/mikeymedling31" target="_blank" data-toggle="tooltip" data-placement="right" title="More Code on GitHub">Developer</a></div>
			</div>
		</div>
</font>
<font size="5">
	<div class="container">
			<div class="row">
				<div class="col-lg-3 centered"><p>It's a feature not a bug.</p><br /></div>
				<div class="col-lg-3 centered"><p>"The only time I set the bar low<br />is for limbo." <br />-Michael Scott</p></div>
				<div class="col-lg-3 centered"><p>My flogic is lawless.</p></div>
				<div class="col-lg-3 centered"><p>Steam? never heard of it...</p></div>
			</div>
		</div>
</font>
	<div class="container">
			<div class="row">
		<div class="col-lg-12 centered">
			<p>We are just a few broke game players looking to save a buck and continue on gaming, so we made Crypt to help everyone game-on while being on a budget!<br />Hurray for the nerds!</p>
			<img src="https://i.imgflip.com/4puq2v.jpg" />
		</div>
			</div>
	</div>
		<br /><br /><br /><br /><br /><br />
</body>
</html>