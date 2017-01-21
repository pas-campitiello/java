<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>REGISTRY UDDI</title>
<script type="text/javascript">
function validate_required(field)
{
 with (field)
 {
   if (value==null||value=="")
   {
     return false;
   }
   else {return true}
 }
}

function validate_form2(field1,field2,thisform)
{
 with (thisform)
 {
  if ( (validate_required(field1)==false) || (validate_required(field2)==false) )
  {
    alert("Almeno una textbox è vuota!");
  	field1.focus();
  	return false;
  }
 }
}
</script>

</head>

<body>

<table border="1" width="100%" id="table1" style="border-collapse: collapse" bordercolor="#66CCFF" cellpadding="5">
	<tr>
		<td colspan="2" style="border-width: 3px; " bgcolor="#FFFFCC">
		<p align="center" style="margin-top: 0; margin-bottom: 0"><b>
		<font face="Verdana" size="5" color="#000080">CLIENT 
		UDDI WEB per ProxyUnivReg</font></b></td>
	</tr>
	<tr>
		<td width="51%" rowspan="3">
		<p align="left" style="margin-top: 0; margin-bottom: 0">
		<u>
		<font face="Verdana" size="2"><b>• Ricerca web service:</b> </font></u></p>
		<p align="left" style="margin-top: 0; margin-bottom: 0">
		<font face="Verdana" size="2">funzioni per la ricerca di tutte le 
		informazioni di un web service (Business Entity, Business Service, 
		TModel e Binding Template) salvate nei registry UDDI registrati.</font></p>
		<p style="margin-top: 0; margin-bottom: 0">&nbsp;<table border="0" width="100%" id="table4">
			<tr>
				<td width="183"><b>
		<font face="Verdana" size="5" color="#000080">
				<img border="0" src="lens.png" width="180" height="180"></font></b></td>
				<td>
		<p style="margin-top: 0; margin-bottom: 0"><a href="inquiryAPI.htm">
		<font face="Verdana" size="2" color="#000080">Vai alla pagina di ricerca</font></a></td>
			</tr>
		</table>
		</td>
		<td width="49%">
		<p style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
		<p style="margin-top: 0; margin-bottom: 0"><u><b>
		<font face="Verdana" size="2">• Pubblicazione ed eliminazione web 
		service: </font></b></u></p>
		<p style="margin-top: 0; margin-bottom: 0">
		<font face="Verdana" size="2">funzioni per la pubblicazione e 
		l'eliminazione di un web service (Business Entity, Business Service, 
		TModel e Binding Template) da/nei registry UDDi registrati.</font></p>
		<p style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
		<p style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
		<p style="margin-top: 0; margin-bottom: 0">
		<u>
		<font face="Verdana" size="2"><b>• Funzioni di amministrazione: </b></font>
		</u></p>
		<p style="margin-top: 0; margin-bottom: 0">
		<font face="Verdana" size="2">aggiungere/eliminare registry UDDI, aggiungere/eliminare utenti</font></p>
		<p style="margin-top: 0; margin-bottom: 0">&nbsp;<hr color="#000080">
		<p style="margin-top: 0; margin-bottom: 0">
		<font face="Verdana" size="2">Per accedere a queste funzioni è 
		necessario loggarsi.</font><p style="margin-top: 0; margin-bottom: 0">&nbsp;</td>
	</tr>
	<tr>
		<td height="13" width="50%">
		<form method="POST" action="LoginServletForward" onsubmit="return validate_form2(username,password,this)">
			<table border="0" width="74%" id="table2">
				<tr>
					<td width="147">
					<p align="left"><font face="Verdana" size="1">Username</font></td>
					<td>
					<p align="left"><font face="Verdana" size="1">Password</font></td>
				</tr>
				
				<%if ((session.getAttribute("logged")!=null) && !((Boolean)session.getAttribute("logged")).booleanValue()) { %>

				<p color="#FF00000">Login fallito.</p>

				<%} %>
			</table>
			<p style="margin-top: 0; margin-bottom: 0" align="left">
			<font face="Verdana">
			<input type="text" name="username" size="20"><font size="2"> </font>
			<input type="password" name="password" size="20"><font size="2">&nbsp;
			</font>
			<input type="submit" value="Login" name="B1" style="font-weight: 700"><font size="2"> </font>
			<input type="reset" value="Cancella" name="B2"></font></p>
		</form>
		</td>
	</tr>
	<tr>
		<td height="13" width="50%">
		<form method="POST" action="ClientUDDIWeb" onsubmit="return validate_form2(userScelto,passScelta,this)">
			<p style="margin-top: 0; margin-bottom: 0" align="left"><u>
			<font face="Verdana" size="2">Registrazione nuovo utente</font></u></p>
			<table border="0" width="69%" id="table3">
				<tr>
					<td width="147">
					<p align="left"><font face="Verdana" size="1">Username 
					scelto</font></td>
					<td>
					<p align="left"><font face="Verdana" size="1">Password 
					scelta</font></td>
				</tr>
			</table>
			<p style="margin-top: 0; margin-bottom: 0" align="left">
			<input type="text" name="userScelto" size="20">
			<input type="password" name="passScelta" size="20">&nbsp;&nbsp;
			<input type="submit" value="Registrati" name="B3">
			<input type="reset" value="Cancella" name="B4"></p>
			<input type="hidden" name="comando" value="add_user">
		</form>
		</td>
	</tr>
</table>



</body>

</html>