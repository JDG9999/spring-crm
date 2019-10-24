<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
	<div class="jumbotron">
		<h1 class="display-4">CRM - Customer Manager</h1>
	</div>
	<h3 class="form-title">Add customer</h3>
	<form class="form-add">
		<form:form action="save-customer" modelAttribute="customer"
			method="POST">
			<form:hidden path="id" />
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">First name:</label>
				<div class="col-sm-10">
					<form:input path="firstName" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Last name:</label>
				<div class="col-sm-10">
					<form:input path="lastName" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" />
				</div>
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</form>
	<p class="form-back">
		<a href="${pageContext.request.contextPath}/customer/list"> Back
			to the customer list </a>
	</p>
</body>
</html>