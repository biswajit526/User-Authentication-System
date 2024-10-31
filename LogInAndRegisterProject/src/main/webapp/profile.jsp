<%@page import="in.biswa.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	%>
	<h1 style="color:green">Your Details are Shown Below</h1>
	<table>
		<tr>
			<th>ID</th>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<th>Name</th>
			<td><%=user.getName()%></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><%=user.getEmail()%></td>
		</tr>
		<tr>
			<th>City</th>
			<td><%=user.getCity()%></td>
		</tr>
	</table>
	<br>
	<a href="logout">Log Out</a>
</body>
</html>