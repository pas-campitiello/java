<%@ page language="java" contentType="te
xt/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="errore.jsp"%>
<%@ page import="it.polimi.si.bean.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	session = null;
	//session.invalidate();
	//pageContext.forward("login.html");
	String redirectURL = "login.html";
    response.sendRedirect(redirectURL);
%>


</html>