<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to three.jsp page</h1>
	<hr />


	<h2>Product ID: ${product.id}</h2>
	<h2>Product Name: ${product.name}</h2>
	<h2>Product Price: ${product.price}</h2>
	<h2>Product Description: ${product.description}</h2>
	<hr />

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>

		<c:forEach var="prod" items="${requestScope.productList}">
			<tr>
				<td>${prod.id}</td>
				<td>${prod.name}</td>
				<td>${prod.price}</td>
				<td>${prod.description}</td>
			</tr>
		</c:forEach>



	</table>


</body>
</html>