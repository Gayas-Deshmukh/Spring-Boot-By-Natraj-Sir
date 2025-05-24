<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Balance</title>
</head>
<body>
	<center>
		<h3>Show Balance Page</h3>
		<b>Balance : <%= new Random().nextInt(1000000) %></b>
	</center>
	
	<a href="./">Home</a>
	
</body>
</html>