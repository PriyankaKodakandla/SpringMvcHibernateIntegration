
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>ID:</td>
				<td>${student.id}</td>
			</tr>
			<br>

			<tr>
				<td>Name:</td>
				<td>${student.name}</td>
			</tr>
			<br>

			<tr>
				<td>Branch:</td>
				<td>${student.branch}</td>
			</tr>
			<br>

			<tr>
				<td>PhoneNo:</td>
				<td>${student.phoneNo}</td>
			</tr>
			<br>

			<tr>
				<td>Address:</td>
				<td>${student.address}</td>
				<br>
			</tr>
		</table>
		<br>
		<br>
		<form action="index.jsp">
			<input type="submit" value="Home page">
		</form>
	</center>
</body>
</html>