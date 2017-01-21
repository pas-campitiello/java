<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="errore.jsp" isErrorPage="false"%> 

<jsp:useBean id="uBean" class="it.polimi.si.bean.UserBean" scope="request"/>
<jsp:setProperty name="uBean" property="*"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
  <head>
    <title>Login page</title>
  </head>
  <body>
  <h1>Login</h1>
  <% if (uBean.getUserId()!=null && !uBean.getUserId().equals("")) { %>
    <p>Errore nell'autenticazione. L'utente <%=uBean.getUserId()%> non esiste</p>
  <% }%>
  <form action="controller.jsp" method=GET>
    <table>
        <tr>
            <td width="30px">User: </td>
            <td width="80px"><input type=text name="userId"/></td>
        </tr>    
        <tr>
            <td width="30px">Password: </td>
            <td width="80px"><input type=text name="password"/></td>
        </tr>
    </table>
    <input type="submit" value="submit"/>
  </form>
  </body>
</html>
