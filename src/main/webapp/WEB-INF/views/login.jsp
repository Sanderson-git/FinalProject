<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/Login</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
<style>
.login {
	position: fixed; /* or absolute */
	padding-top: 10px;
	left: 40%;
	font-size: 20px;
}

li {
	font-size: 20px;
}
</style>
</head>
<body>
<!-- Logo -->
	<img
		src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX"
		style="padding-left: 35%" />
	
<!-- Nav Bar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  	left: 40%;
  	font-size: 20px;
  }
  
  .centered {
  text-align: center;
  padding: 15px;
}	
</style>
</head>
<body>
	<!-- Logo -->
	<a href="/"><img src="https://drive.google.com/uc?id=1BmbUr80SogYS3LZdkH3hqBuqZbyyiSkX" style=" padding-left: 35%"/></a>
	
	<h1></h1>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/popular2019">Most
						popular of 2019</a></li>
				<li class="nav-item active"><a class="nav-link" href="/login">Login
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
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
	
	<div class="login">
		<h4>Login:</h4>
		<form method="post" action="/profile">
			Username: <input type="text" name="username" /><br /> <br />
			Password: <input type="password" name="password" /><br /> <br /> <input
				type="submit" />
		</form>

		<br /><br />
		<h4>
			No login?<br /> Register below:<br /> <br />
		</h4>

		<form method="post" action="/register">
			Choose Username: <input type="text" name="username" /><br /> <br />
			Choose Password: <input type="password" name="password" /><br /> <br />
			<input type="submit" value="Register" />
		</form>
	</div>

</body>
</html>