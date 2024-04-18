<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddTask</title>
<style type="text/css">
*{
margin:0px;
}
body{
background-image:url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYt4EjgZvXFV0NCreomkhJrgUER9YkV-f5bA&s");
background-repeat: no-repeat;
background-size: 100%;
background-attachment:fixed;
height: 100vh;
postion:fixed; 
height: 100vh;
width: 100%;
}
form{
border: 2px solid white;
border-collapse: collapse;
border-radius: 20px;
padding:20px 30px;
margin-top: 150px;

color:black;
margin-left:500px;

width: 300px;
}


</style>
</head>
<body>
<div id="main">
<form action="addtask" method="post" id="f1">
Task Title:<input type="text" name="tasktitle" required="required"><br><br>
Task Description:<input type="text" name="taskdescription"><br><br>
Option:
<label for="option1"><br>
<input type="radio" id="option1" value="low" name="taskpriority">Low
</label><br>
<label for="option2">
<input type="radio" id="option2" value="medium" name="taskpriority">Medium
</label><br>
<label for="option3">
<input type="radio" id="option3" value="high" name="taskpriority">High
</label><br><br>
Due Date:<input type="date" name="taskduedate"><br><br>
<button type="submit">Submit</button>
</form>
</div>

</body>
</html>