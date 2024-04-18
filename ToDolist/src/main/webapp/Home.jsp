<%@page import="DAO.Dao"%>
<%@page import="DTO.Task"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="DTO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">
*{
margin:0px;
}
body{
background-image:url("data:image/jpeg;base64,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");
background-repeat: no-repeat;
background-size: 100%;
width:100%;
background-attachment:scroll;
text-overflow:scroll;
position:scroll;
height: 200vh; 
}
.main{
text-align: center;
font-size: 30px;

}
 img{
margin-left: 600px;
} 
#a1{
margin-left:620px;  
color:black;
text-decoration: none;
font-size: 30px;
text-shadow: 2.5px 2.5px white;
color: purple;
}
#main_module{
border-bottom: 2px solid purple;
text-shadow: 2.5px 2.5px white;
color: purple;
}
#main_2{
margin-top: 30px;
}
#a1:hover{
color: plum;
}
#head1{
text-shadow: 2.5px 2.5px white;
color: purple;
}
#head1:before{
        content: "***";
        width: 250px;
        position: absolute;
        left: 430px;
        top: 55px;
}
#head1:after{
        content: "***";
        width: 250px;
        position: absolute;
        right: 430px;
        top: 57px;

}

table,tr,th,td{
text-shadow: 2px 2px white;
color: black;
font-size: 17px;
padding: 20px;
}
th{
font-size: 18px;
}
td{
padding: 23px;
}

#head3{
font-size: 30px;
text-decoration: underline;
margin-left: 50px;
}
#a2{
text-decoration: none;
color: black;
}
#a2:hover{
color: purple;
}
nav{
border-bottom: 2px dotted purple;
line-height: 50px;
height: 50px;
}

.a4{
text-decoration: none;
padding-left: 30px;
font-size: 24px;
color:purple;
text-shadow: 2.5px 2.5px white;
}
.a4:hover{
color: black;
}
#a3{
text-decoration: none;
}

#a5{
text-decoration: none;
color:purple;
text-shadow: 2px 2px plum;
font-size: 30px;
margin-left: 500px;
}
</style>



</head>
<body>
              <!-- Navigation -->
<nav>
<a href="Addtask.jsp" class="a4">AddTask</a>
<a href="login.jsp" class="a4">Login</a>
<a href="signup.jsp" class="a4">SignUp</a>

</nav>


          <!-- get user from session -->
<%User user=(User) request.getSession().getAttribute("user"); %>
<%String username=user.getUsername(); %>
<div id="main_module">
<h1 class="main" id="head1">Welcome <%= username %></h1>
<h3 class="main">Email : <%= user.getUseremail() %></h3>

<% String image=new String(Base64.getEncoder().encode(user.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64,<%= image %> " width="150" height="100" class="main"><br>

<a href="Addtask.jsp" id="a1">Add Task</a><br>

</div>

<div id="main_2">
<h3 id="head3">TASKS</h3><br>

<%Dao dao=new Dao(); %>
<%List<Task> tasks=dao.getalltasks(user.getUserid()); %>

<table>
<tr>
<th>ID</th>
<th>TITLE</th>
<th>DESCRIPTION</th>
<th>PRIORITY</th>
<th>DUEDATE</th>
<th>STATUS</th>
<th>Delete</th>
<th>Edit</th>
</tr>

<% int num=1; %>
<% for(Task task:tasks){ %>
<tr>
<td><%= num %> </td>
<td><%= task.getTasktitle() %></td>
<td><%= task.getTaskdescription() %></td>
<td><%= task.getTaskpriority() %></td>
<td><%= task.getDuedate() %></td>
<td><%= task.getTaskstatus() %></td>
<td><a href="delete?id=<%= task.getTaskid()%>" id="a2">delete</a></td>
<td><a href="edit?id=<%= task.getTaskid()%>" id="a3">  Edit	 </a> </td>
</tr>

<% num +=1; %>
<%} %>
</table>
<a href="logout" id="a5">Logout</a>
</div>
</body>
</html>