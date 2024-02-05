<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index | App</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
}

#submit {
	border: none;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">User</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
				</ul>
				<div class="collapse navbar-collapse position-absolute end-0">
					<button id="loginBtn" class="btn btn-success me-1">Login</button>
					<button id="registerBtn" class="btn btn-danger ms-1 me-1">Register</button>
				</div>
			</div>
		</div>
	</nav>
	<div class="container mt-3" style="box-shadow: 1px 1px 1px 1px;">

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		$("#loginBtn").click(function() {
			window.location = "/login";
		});

		$("#registerBtn").click(function() {
			window.location = "/register";
		});
	</script>
</body>
</html>