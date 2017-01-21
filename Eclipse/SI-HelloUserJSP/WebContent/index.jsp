<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

String utente = request.getParameter("utente");	

%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld</title>
</head>
<body>
<%

if (utente!=null && !("".equals(utente))) {
%>

<p>Hello World <%=utente %></p>

<%
}
else {
%>

<form id="miaform" method="POST" action="index.jsp">
	<p>Inserisci il tuo nome: <input type="text" id="utente" name="utente"/><br/>
 	<input type="submit" id="submit"/></p>
</form>
	
<%
}
%>
</body>
</html>