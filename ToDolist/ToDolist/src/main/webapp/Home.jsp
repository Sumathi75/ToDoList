<%@page import="java.util.Base64"%>
<%@page import="DTO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%User user=(User) request.getSession().getAttribute("user"); %>
<%String username=user.getUsername(); %>

<h1>Welcome <%= username %></h1>
<h3>Email : <%= user.getUseremail() %></h3>

<% String image=new String(Base64.getEncoder().encode(user.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64,<%= image %> " width="150" height="100"><br>

<a href="Addtask.jsp">Add TAsk</a>



</body>
</html>