<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="errore.jsp"%>
<%@ page import="it.polimi.si.bean.*"%>

<%
UserBeanDataAccess userBeanDataAccess;
if (application.getAttribute("UserBeanDataAccess") != null) 
{
	userBeanDataAccess = (UserBeanDataAccess)application.getAttribute("UserBeanDataAccess");	
} 
else 
{
	userBeanDataAccess = new UserBeanDataAccess();
	application.setAttribute("UserBeanDataAccess", userBeanDataAccess);
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if (userBeanDataAccess.validate(username, password)) 
	{
		session.setAttribute("utente", username);
		pageContext.forward("/listautenti.jsp");
	} 
	else 
	{ %>
		<head>
		<title>Errore</title>
		</head>
		<body>
		<h1>Errore</h1>
		<p>L'utente <%=username%> non è autorizzato</p>
		</body>
  <% }%>
</html>