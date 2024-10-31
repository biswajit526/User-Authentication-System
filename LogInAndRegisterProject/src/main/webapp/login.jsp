<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in page</title>
</head>
<body>
	
	<form action="./login" method="post">
		<%
		if (request.getAttribute("msg") != null) {
		%>
		<p style="color: green"><%=request.getAttribute("msg")%></p>
		<%
		}
		%>
		<table>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email1"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" Value="Log In"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>