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
		<form action="modify" modelAttribute="student">
			<table>
				<tr>
					<td>ID:</td>
					<td><input name="id" value="${student.id}" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input name="name" value="${student.name}" /></td>
				</tr>
				<tr>
					<td>Branch:</td>
					<td><input name="branch" value="${student.branch}" /></td>
				</tr>
				<tr>
					<td>PhoneNo:</td>
					<td><input name="phoneNo" value="${student.phoneNo}" /></td>
				</tr>
				<td>Address:</td>
				<td><input name="address" value="${student.address}" /></td>
				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>