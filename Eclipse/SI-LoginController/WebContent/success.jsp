<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="errore.jsp" isErrorPage="false"%> 
<jsp:useBean id="uBean" class="it.polimi.si.bean.UserBean" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina di Ok</title>
    </head>
    <body>

	    <h1>Benvenuto <%=uBean.getUserId()%></h1>

    </body>
</html>
