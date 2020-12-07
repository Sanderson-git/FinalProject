<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<style>
td {
padding-right:20px;
padding-left:10px;
}
.buttonstyle {
display: block;
    background: #59A7FF;
    padding: 15px;
    text-align: center;
    border-radius: 10px;
    color: white;
    font-weight: bold;
    line-height: 50px;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css" integrity="sha384-nEnU7Ae+3lD52AK+RGNzgieBWMnEfgTbRHIwEvp1XXPdqdO6uLTd/NwXbzboqjc2" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>ALL YOUR GAMING NEEDS</h1>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="/">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/login">Login
          <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Wishlist</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Recommendations</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About US!</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" method="post" action="/searchresults">
		      <input class="form-control mr-sm-2" type="text" placeholder="Search" name="search" >
		      <button class="btn btn-secondary my-2 my-sm-0" type="submit" >Search</button>
		    </form>
  </div>
</nav>
	
	<h1>Discover</h1>
		<font size="7">
			<table>
				<thead>
					<tr>
						<th style="color: #59A7FF;">Game: </th>
						<th style="color: #59A7FF;">Rating: </th>
						<th></th>
						<th style="color: #59A7FF;">Genres: </th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="result" items="${ rawglist.getResults()}">
						<tr>
							<td><a class="buttonstyle" href="/details/${result.getId() }">${result.getName()}</a></td> 
							<td>${result.getRating()} / 5</td>  
							<td><img src="${result.getBackground_image() }" style="width:400px;height:auto;border: 5px solid #59A7FF" ></td> 
							<td><c:forEach var="genre" items="${result.getGenres() }">${genre.getName() }; </c:forEach></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</font>
</body>
</html>