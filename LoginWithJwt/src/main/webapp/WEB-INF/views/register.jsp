<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register | App</title>
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
	<div class="container">
		<div class="d-flex align-items-center justify-content-center mt-5">

			<div class="card p-5"
				style="width: 58rem; box-shadow: 1px 1px 1px 1px">
				<h3 class="text-center">Register here</h3>
				<div class="text-center">
					<c:if test="${param.success != null}">
						<div style="color: green; font-weight: bold;">${param.result}</div>
					</c:if>

					<c:if test="${param.error != null}">
						<div style="color: red; font-weight: bold;">${param.result}</div>
					</c:if>
				</div>
				<form action="/addUser" method="POST">
					<div class="mb-3">
						<label for="name" class="form-label">Enter your name:</label> <input
							type="text" class="form-control" id="name"
							aria-describedby="emailHelp" name="name" placeholder="Name">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email address</label> <input
							type="email" class="form-control" id="email"
							aria-describedby="emailHelp" name="email" placeholder="Email">
					</div>

					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="password">
					</div>
					<div class="form-group">
						<label for="role">Role</label> <select class="form-control"
							id="role" name="role" required>
							<option value="">Select Role</option>
							<option value="Admin">Admin</option>
							<option value="User">User</option>
							<!-- Add more roles if needed -->
						</select>
					</div>
					<button type="submit"
						class="btn btn-danger mt-3 .bg-danger.bg-gradient" id="submit">Submit
					</button>
				</form>
			</div>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>