<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script>

$(document).ready(function() {
	if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(success){
        	var location=success.coords;
        	$.ajax({
                type: "get",
                url: "home/getLocation?latitude="+location.latitude+"&longitude="+location.longitude,
                headers: {
                    'Content-Type':'application/json'
                },		
                success: function(msg){
                	console.log("-------",msg)
                }
            });
        },function(error){
        	alert("Sorry location is required!!!");
        });
    }
	else{
		alert("location is not supported");
	}
	
	
});
</script>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Scrolling Nav - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/scrolling-nav.css" />"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Start
			Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#about">Login</a></li>
				<li class="nav-item">
					 <a href="#page-top"><button class="btn btn-default" style="background-color: #337ab7;color: #fff;">Register</button></a>
				</li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#contact">Contact</a></li>
			</ul>
		</div>
	</div>
	</nav>

	
	<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				This is home page
		</div>
	</div>
	</div>
	</section>


	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2017</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	
	<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<!-- Plugin JavaScript -->
	<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="<c:url value="/resources/js/scrolling-nav.js" />"></script>

</body>

</html>
