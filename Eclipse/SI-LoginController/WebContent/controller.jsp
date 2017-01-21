<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="errore.jsp" isErrorPage="false"%>
<%@page import="it.polimi.si.bean.*" %> 

<jsp:useBean id="uBean" class="it.polimi.si.bean.UserBean" scope="request"/>
<jsp:setProperty name="uBean" property="*"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<% UserBeanDataAccess dataAccess = new UserBeanDataAccess();

   if (dataAccess.validate(uBean.getUserId(), uBean.getPassword())) { %>

<jsp:forward page="success.jsp"/>
        
<% } else { %>
    
<jsp:forward page="login.jsp"/>

<% } %>
