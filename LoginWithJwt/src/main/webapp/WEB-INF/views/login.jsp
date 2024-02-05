<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login | App</title>
<style type="text/css">
body {
	background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
}
</style>
</head>
<body>
	<div class="container">
		<div class="d-flex align-items-center justify-content-center mt-5">

			<div class="card p-5"
				style="width: 58rem; box-shadow: 1px 1px 1px 1px">
				<h3 class="text-center">Login here</h3>
				<div class="text-center">
					<c:if test="${param.error != null}">
						<div style="color: green; font-weight: bold;">Bad
							Credentials</div>
					</c:if>

				</div>
				<form action="/loginauth" method="post">
					<div class="mb-3">
						<label for="email" class="form-label">Email address</label> <input
							type="email" class="form-control" id="email"
							aria-describedby="emailHelp" name="username" placeholder="Email">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="password">
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>