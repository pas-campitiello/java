<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,it.polimi.si.bean.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista utenti</title>
</head>
<body>

<% 

String username = (String) session.getAttribute("utente");

if (username!=null && !("".equals(username))) 
{ 
	//UserBeanDataAccess userBeanDataAccess = (UserBeanDataAccess)application.getAttribute("UserBeanDataAccess");	
	//Collection users;
	//users = userBeanDataAccess.findAll();

	//if (!users.isEmpty()) 
	//{
		//Iterator i = users.iterator();
		//while (i.hasNext()) 
		//{
			//UserBean user = (UserBean) i.next(); 
%>
			<p> 
			salve <%=username%>!
			<br>
			<a href='logout.jsp'>Logout</a> 
			
			
			</p>
	  <%//}
	//} 
} 
else 
{ 
	%>
	<p>Errore. Pagina accessibile solo ad utenti loggati</p>	
	<%
}
%>


</body>
</html>