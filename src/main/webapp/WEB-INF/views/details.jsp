  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/Details</title>
<style type="text/css">
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
.padded {
  margin-top: 10px;
  margin-bottom: 15px;
}
.centered {
  text-align: center;
}
.left {
	text-align: left;
}
.right {
	text-align: right;
}	
.sidepad{
	margin-right: 10px;
}
.xtrapad{
	margin-right: 15px;
}
.footer{ 
       position: fixed;     
       text-align: left;    
       bottom: 0px; 
       width: 100%;
} 
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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

<div class="container">
		<div class="row">
			<div class="col-lg-12 buttonstyle padded"><h1>${rawgDetails.getName() }</h1></div>
		</div>
	</div>
			
	<font size="6">
		<div class="container">
			<div class="row">
					<div class="col-lg-3 centered" style="color: #2a9fd6;"></div>
					<div class="col-lg-1 centered" style="color: #2a9fd6;">Rating</div>
					<div class="col-lg-2 centered" style="color: #2a9fd6;">Genres</div>
					<div class="col-lg-2 centered" style="color: #2a9fd6;">Average Playtime:</div>
					<div class="col-lg-1 centered sidepad" style="color: #2a9fd6;">Retail ($/hr):</div>
					<div class="col-lg-1 centered xtrapad" style="color: #2a9fd6;">ESRB:</div>
					<div class="col-lg-1 centered" style="color: #2a9fd6;">Released:</div>

				</div>
			</div>
		</font>
	<font size="6">
		<div class="container">
			<div class="row">
					<div class="col-lg-3 centered"><img src="${rawgDetails.getBackground_image() }"
						style="width: 100%; height: auto; border: 5px solid #59A7FF"></div>
					<div class="col-lg-1 centered">${rawgDetails.getRating()}/5</div>
					<div class="col-lg-2 centered"><c:forEach var="genre" items="${rawgDetails.getGenres() }"><font size="5"><a class="tagstyle" href="/searchresults/${genre.getId() }" data-toggle="tooltip" data-placement="right" title="Search for ${genre.getName() } games">${genre.getName() }</a></font> </c:forEach></div>
					<div class="col-lg-2 centered">${rawgDetails.getPlaytime() }hrs.</div>
					<div class="col-lg-1 centered sidepad">$${pricephour }  </div>
					<div class="col-lg-1 centered xtrapad">  ${rawgDetails.getEsrb_rating().getName() }</div>
					<div class="col-lg-1 centered">${releaseDate}</div>

				</div>
			</div>
		</font>
	<br />

	<font size="7">
		<div class="container">
			<div class="row">
				<div class="col-lg-1 centered" style="color: #2a9fd6;"></div>
				<div class="col-lg-5" style="color: #2a9fd6;">Store:</div>
				<div class="col-lg-2 centered" style="color: #2a9fd6;">Pricing</div>
				<div class="col-lg-3 centered" style="color: #2a9fd6;"></div>
				<div class="col-lg-1 centered" style="color: #2a9fd6;"></div>
			</div>
		</div>
	</font>
	<font size="7">
	<c:forEach var="deal" items="${deals }">
		<div class="container">
			<div class="row">
				<div class="col-lg-1 centered"></div>
				<div class="col-lg-5">${deal.getStoreName() }</div>
				<div class="col-lg-2 centered">$${deal.getPrice() }</div>
				<div class="col-lg-3 centered"><a class="buttonstyletwo" href="https://www.cheapshark.com/redirect?dealID=${deal.getDealID() }" target="_blank" data-toggle="tooltip" data-placement="right" title="Buy now for ${deal.getSavings() }% off">Purchase</a></td></div>
				<div class="col-lg-1 centered"></div>
			</div>
		</div>
		</c:forEach>
	</font>
	<br />

	<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8 centered">
					<font size="7">
						<a class="buttonstylethree" href="/add/${rawgDetails.getId() }/${steamid}/${sharkgame.getGameId()}">Add game to Wishlist
						</a>
					</font>
				</div>
				<div class="col-lg-2"></div>
			</div>
		</div>
		

	<br />
	<br />
<div class="container">
			<div class="row">
				<div class="col-lg-12 dropdown centered">
				<button onclick="myFunction()" class="btn btn-outline-secondary"><h3>View Game Description</h3></button>
    <div id="Demo" class="dropdown-menu tagstyle w3-animate-zoom">
							<p><font size="4">${rawgDetails.getDescription_raw() }</font></p>
					</div>
					</div>
			</div>
		</div>


	<br />
	<br />
	<br />
	<br />
	<br />
		<div class="footer">Thanks to <a href= "https://rawg.io" data-toggle="tooltip" data-placement="top" title="Leave Crypt and go to RAWG website" target="_blank">RAWG.io</a> for the data</div>
</body>
</html>