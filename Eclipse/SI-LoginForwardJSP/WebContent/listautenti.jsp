<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista utenti</title>
</head>
<body>

<% 

if ((session.getAttribute("logged")==null) || !((Boolean)session.getAttribute("logged")).booleanValue()) { %>

	<p>Accesso alla pagina consentito ai soli utenti autenticati</p>

<% 
} 
else 
{
	Collection users = (Collection) session.getAttribute("users");
	if (!users.isEmpty()) 
	{
		Iterator i = users.iterator();
		while (i.hasNext()) 
		{
			UserBean user = (UserBean) i.next();%> 
			<p><%=user.getUsername()%></p>
	 <% }
	} 
	
	session.removeAttribute("users");
}
%>
<p><a href="LogoutServlet">logout</a></p>

</body>
</html>