<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crypt/Wishlist</title>

<style type="text/css">
td {
	padding-right: 20px;
	padding-left: 10px;
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
	background: #d3d3d3;
	padding: 2px;
	text-align: center;
	border-radius: 5px;
	color: white;
	font-weight: bold;
	line-height: 20px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}

.centered {
	text-align: center;
}
.padded {
  padding-top: 15px;
  padding-bottom: 15px;
}
.paddedsm {
  padding-top: 5px;
  padding-bottom: 5px;
}
.right {
	text-align: right;
}

.centerednopad {
  text-align: center;
}	

.footer{ 
       position: fixed;     
       text-align: left;    
       bottom: 0px; 
       width: 100%;
       font-size: 11px;
       font-family: font-family: Arial, Helvetica, sans-serif;
} 
.zoom {

  transition: transform .2s; /* Animation */

}

.zoom:hover {
  transform: scale(1.1); /* (110% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
  position:relative;
  z-index:2;
}
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css"
	integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
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
				<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/login">Login		
				</a></li>
				<li class="nav-item active" style="font-size: 16px;"><a class="nav-link" href="/wishlist">Wishlist</a>
				</li>

				<li class="nav-item" style="font-size: 16px;"><a class="nav-link"
					href="/recommendations">Recommendations</a></li>
				<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/about">The
						Crypt Keepers</a></li>
      		<li class="nav-item" style="font-size: 16px;"><a class="nav-link" href="/popular2019">Most
						popular of 2019</a></li>
			</ul>
				<span class="navbar-brand">${ user.username }</span>
    		<c:if test = "${user.username != null}">
    		<a class="btn navbar-btn btn-default navbar-right pull-right" role="button" href="/logout">Logout</a> 
			</c:if>
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
		<div class="col-lg-6 padded">
			<form method="post" action="/binpacking">
			Enter Budget: <input type="number" name="budget" /> 
			<input type="submit" name="submit" data-toggle="tooltip" data-placement="right" title="Generate Shopping List" />
			</form>
		</div>
		<div class="col-lg-6 right dropdown">
			<button onclick="myFunction()" class="btn btn-outline-secondary zoom zoom:hover">Get Share Link</button>
   				 <div id="Demo" class="dropdown-menu tagstyle w3-animate-zoom">
							<p><font size="2"><a href="/wishlist/${ user.id}/${user.username}">http://crypt-env.eba-96hebjqt.us-east-2.elasticbeanstalk.com/wishlist/${ user.id }/${user.username }</a></font></p>
					</div>
		</div>
	</div>
	
</div>
	<font size="5">
		<div class="container">
			<div class="row">
				<div class="col-lg-3" style="color: #2a9fd6;"></div>
				<div class="col-lg-3" style="color: #2a9fd6;"></div>
				<div class="col-lg-1" style="color: #2a9fd6;">Price:</div>
				<div class="col-lg-3" style="color: #2a9fd6;">Desired Price:</div>
				<div class="col-lg-2" style="color: #2a9fd6;"></div>
			</div>
		</div>
	</font>
	<font size="4">			
	<c:forEach var="games" items="${ games }">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 paddedsm"><a href="/details/${ games.getRawgId()}" data-toggle="tooltip" data-placement="right" title="View Game Details"><img src="${ games.getBackground_image() }" alt="${games.getName()}" style="width: 100%; height: auto; border: 5px solid #59A7FF"></a></div>
				<div class="col-lg-3 paddedsm"><a class="buttonstyle zoom zoom:hover" href="/details/${ games.getRawgId()}" data-toggle="tooltip" data-placement="right" title="View Game Details">${ games.getName() }</a><a href="/wishlistdelete/${ games.getWishlistid() }" style="font:normal" data-toggle="tooltip" data-placement="right" title="Remove from Wishlist">delete</a></div>
				<div class="col-lg-1" >$${games.getPrice() }</div>
				<div class="col-lg-3"><form method="post" action="/wishlist/setalert/${ games.getWishlistid() }">
								<input type="number" placeholder="$${ games.getDesiredprice() }" name="setalert" /> <input type="submit" name="submit" data-toggle="tooltip" data-placement="right" title="Get alerted at this price" />
							</form></div>
				<div class="col-lg-2" ><c:if test="${ games.getDesiredprice() >=  games.getPrice() }"><a href="https://www.cheapshark.com/redirect?dealID=${games.getDealId() }" class="buttonstyletwo" target="_blank" data-toggle="tooltip" data-placement="right" title="Open store link in new tab">Buy Now!</a>
							</c:if></div>
			</div>
		</div>

				</c:forEach>
	</font>
		<div class="footer"><font size="1.5" face="sans-serif"> Thanks to <a href= "https://rawg.io" data-toggle="tooltip" data-placement="top" title="Leave Crypt and go to RAWG website" target="_blank" style="color:#2a9fd6">RAWG.io</a> for the data</font></div>
</body>
</html>