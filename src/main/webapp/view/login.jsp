<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

//user
<font color="red">
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}
%>
</font>

<form action="loginp" method="post">
username<input type="text" name="username">
password<input type="password" name="password">
<input type="submit" value="login">
<input type="reset" value="reset">

<a href="createaccount">CreateAccount</a>
</form>

<br>

//admin
<form action="login" method="post">
username<input type="text" name="username">
password<input type="password" name="password">
<input type="submit" value="login">
<input type="reset" value="reset">

<a href="loginpage">Back to Login</a>
</form>


</body>
</html>