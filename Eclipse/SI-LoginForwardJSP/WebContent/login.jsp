<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<h1>Hello!</h1>

<%if ((session.getAttribute("logged")!=null) && !((Boolean)session.getAttribute("logged")).booleanValue()) { %>

<p color="#FF00000">Login fallito.</p>

<%} %>

<form id="miaform" method="POST" action="LoginServletForward">
 
 <p>username: <input type="text" id="username" name="username"><br>
 <p>password: <input type="text" id="password" name="password"><br><br>
 <input type="submit" id="submit" value="login"></p>

</form>

</body>
</html>