<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap-4.3.1/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
	<div class="jumbotron">
		<h1 class="display-4">CRM - Customer Manager</h1>
		<hr class="my-4">
		<button type="button" class="btn btn-success btn-lg"
			onclick="window.location.href='add-customer'; return false;" />
		Add customer
		</button>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempCustomer" items="${customers}">
				<c:url var="updateLink" value="/customer/update-customer">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<c:url var="deleteLink" value="/customer/delete-customer">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<tr>
					<th scope="row">${tempCustomer.id}</th>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td><a href="${updateLink}" class="btn btn-primary">Update</a>
						<a href="${deleteLink}" class="btn btn-danger"
						onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>