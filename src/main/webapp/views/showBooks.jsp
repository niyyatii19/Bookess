<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
p {
	color: white;
	background-color: black;
	padding: 10px;
}

.heading {
	padding: 40px;
	font-size: 45px;
	background-color: #c1c100;
	color: #6c0f0f;
	border: aliceblue;
	font-family: cursive;
	font-style: oblique;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Book Store</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="showBooks">Home</a></li>


					<%
						String id = (String) session.getAttribute("email");
					//
					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
						}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/user/likedBooks">Liked
							Books</a></li>
					<%
						}
					%>
				</ul>
			</div>


		</div>
	</nav>

	<h1 class='text-center heading'>Welcome to Bookess</h1>
	<div class="container overflow-hidden text-center">
		<div class="row gx-5 row-cols-3">

			<c:forEach items="${books}" var="book">
				<div class='col'>
					<div class='p-3'>
						<div class="card">
							<img src="${book.url }" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">${book.title }</h5>
								<p class="card-text">${book.description }</p>
								<%
									String id1 = (String) session.getAttribute("email");

								if (id1 != null) {
								%>
								<a
									href="/user/book/${book.id }"
									class="btn btn-primary">Like</a>

								<%
									}
								%>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>


</body>
</html>