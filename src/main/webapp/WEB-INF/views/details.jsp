  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
.zoom {

  transition: transform .2s; /* Animation */

}

.zoom:hover {
  transform: scale(1.1); /* (125% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
  position:relative;
  z-index:2;
}

.zoomt {

  transition: transform .2s; /* Animation */

}

.zoomt:hover {
  transform: scale(1.05); /* (110% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
  position:relative;
  z-index:2;
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
.centerednopad {
  text-align: center;
}	

.footer{ 
       position: fixed;     
       text-align: left;    
       bottom: 0px; 
       width: 100%;
       font-size: 10px;
       font-family: font-family: Arial, Helvetica, sans-serif;
}


<!-- slideshow stuff starts here -->

* {box-sizing:border-box}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  z-index:1;
  margin: auto;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  -webkit-animation-fill-mode: forwards; 
  animation-name: fade;
  animation-duration: 1.5s;
  animation-fill-mode: forwards; 
}

@-webkit-keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}
</style>

</head>
<body>
	<!-- Logo -->

<div class="container">
	<div class="row">
		<div class="col-lg-12 centerednopad"><a href="/"><img src="https://drive.google.com/uc?id=1fPjNndqQhYAMUy6HG5YUGc0MUmmhZncH" /></a></div>
	</div>
</div>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/" style="font-size: 16px;">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
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
    		<c:choose>
    			<c:when test = "${user.username != null}">
    				<a class="navbar-brand" style="font-size: 16px;" href="/logout">Logout</a>
    			</c:when>
    			<c:otherwise>
    				<a class="navbar-brand" style="font-size: 16px;" href="/login">Login</a>
    			</c:otherwise>
    		</c:choose>
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
			<div class="col-lg-12 buttonstyle padded zoom zoom:hover"><button onclick="myFunction()" class="btn " data-toggle="tooltip" data-placement="right" title="Click to View Game Description"><h1>${rawgDetails.getName() }</h1></button>
				<div id="Demo" class="col-lg-12 dropdown-menu tagstyle w3-animate-zoom"><p><font size="4">${rawgDetails.getDescription_raw() }</font></p></div>
		</div>
		</div>
	</div>
	
				<div class="slideshow-container" >
					<div class="mySlides fade centered">
							<img src="${rawgDetails.getBackground_image() }"
						style="width: 80%; height: auto; border: 5px solid #59A7FF;">
					</div>
					
					<c:forEach var="screenshot" items="${gameScreenshots.getResults() }">
						<div class="mySlides fade centered">
						<img src="${screenshot.getImage() }"
							style="width: 80%; height: auto; border: 5px solid #59A7FF">
						</div>
					</c:forEach>
					<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  					<a class="next" onclick="plusSlides(1)">&#10095;</a>
				</div>
			
	<font size="5">
		<div class="container">
			<div class="row">
				
					<div class="col-lg-2 centered xtrapad" style="color: #2a9fd6;">Rating</div>
					<div class="col-lg-2 centered" style="color: #2a9fd6;">Genres</div>
					<div class="col-lg-2 centered" style="color: #2a9fd6;">Avg Playtime</div>
					<div class="col-lg-2 centered" style="color: #2a9fd6;">Retail ($/hr)</div>
					<div class="col-lg-2 centered xtrapad" style="color: #2a9fd6;">ESRB:</div>
					<div class="col-lg-1 right" style="color: #2a9fd6;">Released:</div>
					

				</div>
			</div>
		</font>
	<font size="5">
		<div class="container">
			<div class="row">
					
				
					<div class="col-lg-2 centered xtrapad">${rawgDetails.getRating()}/5</div>
					<div class="col-lg-2 centered zoomt zoomt:hover"><c:forEach var="genre" items="${rawgDetails.getGenres() }"><font size="5"><a class="tagstyle" href="/searchresults/${genre.getId() }" data-toggle="tooltip" data-placement="right" title="Search for ${genre.getName() } games">${genre.getName() }</a></font> </c:forEach></div>
					<div class="col-lg-2 centered">${rawgDetails.getPlaytime() }hrs.</div>
					<div class="col-lg-2 centered">$${pricephour }</div>
					<div class="col-lg-2 centered xtrapad">  ${rawgDetails.getEsrb_rating().getName() }</div>
					<div class="col-lg-1 right">${releaseDate}</div>


				</div>
			</div>
		</font>
	<br />
	<br />
		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8 zoom zoom:hover centered">
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
				<div class="col-lg-3 centered zoomt zoomt:hover"><a class="buttonstyletwo" href="https://www.cheapshark.com/redirect?dealID=${deal.getDealID() }" target="_blank" data-toggle="tooltip" data-placement="right" title="Buy now for ${deal.getSavings() }% off">Purchase</a></td></div>
				<div class="col-lg-1 centered"></div>
			</div>
		</div>
		</c:forEach>
	</font>
	<br />
	<script>
	function myFunction() {
		  var x = document.getElementById("Demo");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		  }
		}
	
	</script>

	<br />
	<br />
	<br />
	<br />
	<br />

		<div class="footer"><font size="1.5" face="sans-serif"> Thanks to <a href= "https://rawg.io" data-toggle="tooltip" data-placement="top" title="Leave Crypt and go to RAWG website" target="_blank" style="color:#2a9fd6">RAWG.io</a> for the data</font></div>
	
	
	<script>
	var slideIndex = 1;
	showSlides(slideIndex);

	// Next/previous controls
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}

	// Thumbnail image controls
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}

	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";
	  dots[slideIndex-1].className += " active";
	  }
	  if (n > slides.length) {slideIndex = 1}
	</script>
	

</body>
</html>