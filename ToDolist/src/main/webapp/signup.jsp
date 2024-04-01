<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sign-up</title>
<style>
form{
margin: 300px;
margin-top:100px;
margin-left:400px;
margin-right:500px;
border: 3px solid black;
padding: 30px 0px 30px 100px;
background-color: purple;
}
body{

}
</style>
</head>
<body>
<form action="saveuser" method="post" enctype="multipart/form-data">
Id:<input type="text" name="id"><br><br>
Name:<input type="text" name="name"><br><br>
Email:<input type="text" name="email"><br><br>
Contact:<input type="text" name="contact"><br><br>
Password:<input type="text" name="password"><br><br>
Image:<input type="file" name="image"><br><br>

<input type="submit">
</form>
</body>
</html>