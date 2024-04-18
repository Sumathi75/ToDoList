<%@page import="DTO.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div id="main">

<%Task task=(Task)request.getAttribute("task"); %>

<form action="updatetask" method="post" >
Task Id:<input type="text" name="taskid" hidden="" value="<%= task.getTaskid() %>" readonly><br><br> 
Task Title:<input type="text" name="tasktitle"  value="<%= task.getTasktitle() %>" required><br><br>
Task Description:<input type="text" name="taskdescription"  value="<%= task.getTaskdescription() %>"><br><br>

Current Task priority is :<h4><%= task.getTaskpriority() %></h4><br>

Task priority:<br>
<label for="option1"><br>
<input type="radio" id="option1" value="low" name="taskpriority" >Low
</label><br>
<label for="option2">
<input type="radio" id="option2" value="medium" name="taskpriority">Medium
</label><br>
<label for="option3">
<input type="radio" id="option3" value="high" name="taskpriority">High
</label><br><br>
DueDate:<input type="date" name="taskduedate" value="<%= task.getDuedate() %>"><br><br>
Status:<input type="text" name="taskstatus" value="<%= task.getTaskstatus()%>"><br><br>
<input type="submit">
</form>
</div>
</body>
</html>