<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

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
				<li class="nav-item"><a class="nav-link js-scroll-trigger" href="#about">Login</a></li>
				<li class="nav-item">
					 <a class="nav-link js-scroll-trigger" href="${contextPath}/registration"><button class="btn btn-default" style="background-color: #337ab7;color: #fff;">Register</button></a>
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
					<div style="text-align:center"><h2>Login</h2>
					<form:form action="${contextPath}/login" method="POST" modelAttribute="userLogin" class="form-vertical">
					<font color="red"><c:out value="${errorMessage}" /></font> 
						<div class="form-group row">
							<label class="control-label col-sm-2">Username</label>
							<div class="col-sm-5">
								<form:input path="username" placeholder="Enter username"
									class="form-control" />
								<form:errors path="username" />
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Password</label>
							<div class="col-sm-5">
								<form:input path="password" type="password"
									placeholder="Password" class="form-control" />
								<form:errors path="password" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default"
									style="background-color: #337ab7; color: #fff;">Login</button>
							</div>
						</div>
					</form:form>
				</div>
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
	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<!-- Plugin JavaScript -->
	<script
		src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="<c:url value="/resources/js/scrolling-nav.js" />"></script>

</body>

</html>
