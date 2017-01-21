<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html><head>


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

function validate_form4(field1,field2,field3,field4,thisform)
{
 with (thisform)
 {
  if ( (validate_required(field1)==false) || (validate_required(field2)==false) || (validate_required(field3)==false) || (validate_required(field4)==false))
  {
    alert("Almeno una textbox è vuota!");
  	field1.focus();
  	return false;
  }
 }
}

function validate_form5(field1,field2,field3,field4,field5,thisform)
{
 with (thisform)
 {
  if ( (validate_required(field1)==false) || (validate_required(field2)==false) || (validate_required(field3)==false) || (validate_required(field4)==false) || (validate_required(field5)==false) )
  {
    alert("Almeno una textbox è vuota!");
  	field1.focus();
  	return false;
  }
 }
}

function validate_form6(field1,field2,field3,field4,field5,field6,thisform)
{
 with (thisform)
 {
  if ( (validate_required(field1)==false) || (validate_required(field2)==false) || (validate_required(field3)==false) || (validate_required(field4)==false) || (validate_required(field5)==false) || (validate_required(field6)==false))
  {
    alert("Almeno una textbox è vuota!");
  	field1.focus();
  	return false;
  }
 }
}

function validate_form7(field1,field2,field3,field4,field5,field6,field7,thisform)
{
 with (thisform)
 {
  if ( (validate_required(field1)==false) || (validate_required(field2)==false) || (validate_required(field3)==false) || (validate_required(field4)==false) || (validate_required(field5)==false) || (validate_required(field6)==false) || (validate_required(field7)==false) )
  {
    alert("Almeno una textbox è vuota!");
  	field1.focus();
  	return false;
  }
 }
}

function errSessioneTerminata()
{
    alert("Sessione terminata! L'accesso alla pagina è consentito solo ad utenti autenticati. Tornare alla HOME e rieseguire il login.");
  	
  	return false;
}


</script>

</head>

<body>




<table id="table12" width="100%" border="1" cellpadding="5">
	<tbody><tr>
		<td valign="top" align="center" bgcolor="#66FF66">
			<p style="margin-top: 0pt; margin-bottom: 0pt;">
			<font face="Verdana">UDDI PUBLISH/UPDATE APIs - <b>PUBBLICAZIONE 
			ed ELIMINAZIONE</b></font></p></td>
		</tr>
		
	
	<tr>
		<td valign="top" align="center">
			<div align="right">
			<div align="left">
			<table id="table35" width="100%" border="0" bordercolor="#c0c0c0" cellpadding="3">
				<tbody><tr>
					<td width="104">
					<form method="POST" 
<% 
	if ((session.getAttribute("logged")!=null) && ((Boolean)session.getAttribute("logged")).booleanValue()) 
	{
		%>
		action="ClientUDDIWeb">
		<%
	}
	else %>><%
%>		
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
						<input value="Refresh database" name="B27" type="submit"></p>
						<input type="hidden" name="comando" value="refresh_database">
					</form>
					</td>
					<td valign="top" width="509">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">E' consigliato fare un refresh </font>
					</p>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">del database 
					periodicamente.</font></p></td>
					<td valign="top">
					<div align="right">
						<table id="table36" style="border-collapse: collapse;" width="445" border="1" bordercolor="#c0c0c0" cellpadding="3">
							<tbody><tr>
								<td align="center" width="122">
								<font face="Verdana" size="1">
								
<% 
	if ((session.getAttribute("logged")==null) || !((Boolean)session.getAttribute("logged")).booleanValue()) { %>

	<b><font color="#FF0000">ATTENZIONE! L'accesso alla pagina è consentito solo ad utenti autenticati.</font></b>
	<a href="index.jsp">HOME</a>
<% 
} 
else 
{
	%> 
			Salve <%=session.getAttribute("utente")%>!
								
								</font></td>
								<td align="center" width="122"><b>
								<font size="1" face="Verdana">
								<a href="LogoutServlet">LOGOUT &amp; HOME</a></font></b></td>
	 <%
}
%>								<td align="center"><b>
								<font face="Verdana" size="1">
								<a href="inquiryAPI.htm">RICERCA</a></font></b></td>
								<td width="115" align="center"><b>
								<a href="#helpparametri"><font size="1" face="Verdana">HELP parametri</font></a></b></td>
							</tr>
						</tbody></table>
					</div>
					</td>
				</tr>
			</tbody></table>
			<br>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegSBE,userRegSBE,passRegSBE,nomeSBE,this)">
			<div style="background-color: #FFCCCC;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font size="2" face="Verdana">Save </font></b></u><b><u>
			<font size="2" face="Verdana">Business Entity</font></u></b><br>
				</p></div>
				<table id="table20" width="100%" border="0">
			<tbody><tr>
					<td width="176">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">
					Nome registry in cui salvare</font></p></td>
					<td width="149">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="144">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome BE da salvare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegSBE" size="25" type="text"> 
			<input name="userRegSBE" size="20" type="text"> 
			<input name="passRegSBE" size="20" type="password"> 
			<input name="nomeSBE" size="20" type="text">&nbsp;&nbsp; 
			<input value="Salva" name="Invia" type="submit">
			<input value="Reimposta" name="B11" type="reset"></p>
			<input type="hidden" name="comando" value="save_business">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegSBS,userRegSBS,passRegSBS,nomeSBS,this)">
			<div style="background-color: #FFCCCC;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font size="2" face="Verdana">Save </font></b></u><b><u>
			<font size="2" face="Verdana">Business Service</font></u></b><br>
				</p></div>
				<table id="table24" width="100%" border="0">
			<tbody><tr>
					<td width="174">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">
					Nome registry in cui salvare</font></p></td>
					<td width="151">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="144">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome BS da salvare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegSBS" size="25" type="text"> 
			<input name="userRegSBS" size="20" type="text"> 
			<input name="passRegSBS" size="20" type="password"> 
			<input name="nomeSBS" size="20" type="text">&nbsp;&nbsp; 
			<input value="Salva" name="Invia" type="submit">
			<input value="Reimposta" name="B18" type="reset"></p>
			<input name="comando" value="save_service" type="hidden">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegSTM,userRegSTM,passRegSTM,nomeSTM,this)">
			<div style="background-color: #FFCCCC;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font size="2" face="Verdana">Save TModel</font></b></u><br>
				</p></div>
				<table id="table25" width="100%" border="0">
			<tbody><tr>
					<td width="176">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">Nome 
					registry in cui salvare</font></p></td>
					<td width="148">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="146">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome TM da salvare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegSTM" size="25" type="text"> 
			<input name="userRegSTM" size="20" type="text"> 
			<input name="passRegSTM" size="20" type="password"> 
			<input name="nomeSTM" size="20" type="text">&nbsp;&nbsp; 
			<input value="Salva" name="Invia" type="submit">
			<input value="Reimposta" name="B19" type="reset"></p>
			<input name="comando" value="save_tmodel" type="hidden">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form6(nomeRegSBT,userRegSBT,passRegSBT,nomeSBT,accessPointSBT,urlTypeSBT,this)">
			<div style="background-color: #FFCCCC;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font size="2" face="Verdana">Save Binding Template</font></b></u><br>
				</p></div>
				<table id="table26" width="100%" border="0">
			<tbody><tr>
					<td width="176">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">Nome 
					registry in cui salvare</font></p></td>
					<td width="149">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="144">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td width="145">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome BS in cui salvare</font></p></td>
					<td width="145">
					<font size="1" face="Verdana">AccessPoint</font></td>
					<td>
					<font size="1" face="Verdana">UrlType</font></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegSBT" size="25" type="text"> 
			<input name="userRegSBT" size="20" type="text"> 
			<input name="passRegSBT" size="20" type="password"> 
			<input name="nomeSBT" size="20" type="text">
			<input name="accessPointSBT" size="20" type="text">
			<input name="urlTypeSBT" size="20" type="text">&nbsp;&nbsp; 
			<input value="Salva" name="Invia" type="submit">
			<input value="Reimposta" name="B20" type="reset"></p>
			<input name="comando" value="save_binding" type="hidden">
		</form>
			<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form(nomeBE,this)">
			<input name="comando" value="save_binding" type="hidden">
		</form>
		<br>
		
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegDBE,userRegDBE,passRegDBE,nomeDBE,this)">
			<div style="background-color: #FFDA8C;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font face="Verdana" size="2">Delete </font></b></u><b><u>
			<font size="2" face="Verdana">Business Entity</font></u></b><br>
				</p></div>
				<table id="table41" width="100%" border="0">
			<tbody><tr>
					<td width="176">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">
					Nome registry in cui cercare</font></p></td>
					<td width="149">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="144">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome BE da eliminare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegDBE" size="25" type="text"> 
			<input name="userRegDBE" size="20" type="text"> 
			<input name="passRegDBE" size="20" type="password"> 
			<input name="nomeDBE" size="20" type="text">&nbsp;&nbsp; 
			<input value="Elimina" name="Invia" type="submit">
			<input value="Reimposta" name="B28" type="reset"></p>
			<input type="hidden" name="comando" value="delete_business">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegDBS,userRegDBS,passRegDBS,nomeDBS,this)">
			<div style="background-color: #FFDA8C;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font face="Verdana" size="2">Delete </font></b></u><b><u>
			<font size="2" face="Verdana">Business Service</font></u></b><br>
				</p></div>
				<table id="table42" width="100%" border="0">
			<tbody><tr>
					<td width="174">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">
					Nome registry in cui cercare</font></p></td>
					<td width="151">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="144">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome BS da eliminare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegDBS" size="25" type="text"> 
			<input name="userRegDBS" size="20" type="text"> 
			<input name="passRegDBS" size="20" type="password"> 
			<input name="nomeDBS" size="20" type="text">&nbsp;&nbsp; 
			<input value="Elimina" name="Invia" type="submit">
			<input value="Reimposta" name="B29" type="reset"></p>
			<input type="hidden" name="comando" value="delete_service">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegDTM,userRegDTM,passRegDTM,nomeDTM,this)">
			<div style="background-color: #FFDA8C;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font face="Verdana" size="2">Delete TModel</font></b></u><br>
				</p></div>
				<table id="table43" width="100%" border="0">
			<tbody><tr>
					<td width="176">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">Nome 
					registry in cui cercare</font></p></td>
					<td width="148">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="146">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Nome TM da eliminare</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegDTM" size="25" type="text"> 
			<input name="userRegDTM" size="20" type="text"> 
			<input name="passRegDTM" size="20" type="password"> 
			<input name="nomeDTM" size="20" type="text">&nbsp;&nbsp; 
			<input value="Elimina" name="Invia" type="submit">
			<input value="Reimposta" name="B30" type="reset"></p>
			<input name="comando" value="delete_tmodel" type="hidden">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(nomeRegDBT,userRegDBT,passRegDBT,serviceKeyDBT,this)">
			<input name="comando" value="delete_binding" type="hidden">
			<div style="background-color: #FFDA8C;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font size="2" face="Verdana">Delete Binding Template</font></b></u><br>
				</p></div>
				<table id="table44" width="100%" border="0">
			<tbody><tr>
					<td width="174">
					<p style="margin-top: 0pt; margin-bottom: 0pt;"><font size="1" face="Verdana">Nome 
					registry in cui cercare</font></p></td>
					<td width="147">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Username registry</font></p></td>
					<td width="146">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">Password registry</font></p></td>
					<td width="738">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">ServiceKey del BS superiore al 
					BT da eliminare</font></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="nomeRegDBT" size="25" type="text"> 
			<input name="userRegDBT" size="20" type="text"> 
			<input name="passRegDBT" size="20" type="password"> 
			<input name="serviceKeyDBT" size="40" type="text">&nbsp;&nbsp; 
			<input value="Elimina" name="Invia" type="submit">
			<input value="Reimposta" name="B31" type="reset"></p>
		</form>
		</div></div></td>
		</tr>
		
	</tbody></table>

<br>

<table id="table68" width="100%" border="1" cellpadding="5">
	<tbody><tr>
		<td valign="top" align="center" bgcolor="#66ff66">
			<p style="margin-top: 0pt; margin-bottom: 0pt;">
			<b>
			<font face="Verdana">FUNZIONI DI AMMINISTRAZIONE</font></b></p></td>
		</tr>
		
	
	<tr>
		<td valign="top" align="center">
			<div align="right">
			<div align="left">
			<table id="table69" width="100%" border="0" bordercolor="#c0c0c0" cellpadding="3">
				<tbody><tr>
					<td width="104">
					<form method="POST" action="--WEBBOT-SELF--">
						<!--webbot bot="SaveResults" U-File="fpweb:///_private/form_results.csv" S-Format="TEXT/CSV" S-Label-Fields="TRUE" -->
						<p style="margin-top: 0pt; margin-bottom: 0pt;">
						<input value="Refresh database" name="B36" type="submit"></p>
					</form>
					</td>
					<td valign="top" width="509">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">E' consigliato fare un </font>
					</p>
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font size="1" face="Verdana">refresh del database 
					periodicamente.</font></p></td>
					<td width="189">&nbsp;</td>
					<td valign="top">
					<div align="right">
						<table id="table70" style="border-collapse: collapse;" width="189" border="1" bordercolor="#c0c0c0" cellpadding="3">
							<tbody><tr>								
								<td width="115" align="center"><b>
		<a href="#helpparametri"><font size="1" face="Verdana">HELP parametri</font></a></b></td>
							</tr>
						</tbody></table>
					</div>
					</td>
				</tr>
			</tbody></table>
		<br>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form7(userAmmAR,passAmmAR,nomeNuovoRegAR,inqUrlAR,pubUrlAR,userNuovoRegAR,passNuovoRegAR,this)">
			<div style="background-color: #66CCFF;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font face="Verdana" size="2">Add registry</font></b></u><font size="2" face="Verdana"> 
			(solo amministratore)</font><br>
				</p></div>
				<table id="table79" width="100%" border="0">
			<tbody><tr>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Username amm</font>.</td>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Password amm</font>.</td>
					<td width="134">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Nome nuovo registry</font></td>
					<td width="148">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Inquiry URL</font></td>
					<td width="148">
					<font face="Verdana" size="1">Publish URL</font></td>
					<td width="148">
					<font face="Verdana" size="1">Username nuovo registry</font></td>
					<td width="148">
					<font face="Verdana" size="1">Password nuovo registry</font></td>
					<td>
					&nbsp;</td>
				</tr>
				<tr>
					<td width="106">
					<font size="1" face="Verdana">
			<input name="userAmmAR" size="14" type="text"></font></td>
					<td width="106">
					<font size="1" face="Verdana"> 
			<input name="passAmmAR" size="14" type="password"></font></td>
					<td width="134">
					<font size="1" face="Verdana"> 
			<input name="nomeNuovoRegAR" size="18" type="password"></font></td>
					<td width="148">
					<font size="1" face="Verdana"> 
			<input name="inqUrlAR" size="20" type="text"></font></td>
					<td width="148">
					<font size="1" face="Verdana">
					<input type="text" name="pubUrlAR" size="20"></font></td>
					<td width="148">
					<font size="1" face="Verdana">
					<input type="text" name="userNuovoRegAR" size="20"></font></td>
					<td width="148">
					<input type="password" name="passNuovoRegAR" size="20"></td>
					<td>
					<font size="1" face="Verdana"> 
			&nbsp; 
			<input value="Aggiungi" name="Invia" type="submit"> <input value="Reimposta" name="B45" type="reset"></font></td>
				</tr>
			</tbody></table>
			<input type="hidden" name="comando" value="add_registry">
			</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form5(userAmmDR,passAmmDR,nomeRegElimDR,userRegElimDR,passRegElimDR,this)">
			<div style="background-color: #66CCFF;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><u><b>
			<font face="Verdana" size="2">Delete registry</font></b></u><font size="2" face="Verdana"> 
			(solo amministratore)</font></p></div>
				<table id="table91" width="100%" border="0">
			<tbody><tr>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Username amm</font>.</td>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Password amm</font>.</td>
					<td width="134">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Nome registry</font></td>
					<td width="148">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Username registry</font></td>
					<td width="148">
					<font face="Verdana" size="1">Password registry</font></td>
					<td width="554">
					&nbsp;</td>
				</tr>
				<tr>
					<td width="106">
					<font size="1" face="Verdana">
			<input name="userAmmDR" size="14" type="text"></font></td>
					<td width="106">
					<font size="1" face="Verdana"> 
			<input name="passAmmDR" size="14" type="password"></font></td>
					<td width="134">
					<font size="1" face="Verdana"> 
			<input name="nomeRegElimDR" size="18" type="password"></font></td>
					<td width="148">
					<font size="1" face="Verdana"> 
			<input name="userRegElimDR" size="20" type="text"></font></td>
					<td width="148">
					<font size="1" face="Verdana">
			<input name="passRegElimDR" size="20"></font></td>
					<td width="554">
					<font size="1" face="Verdana"> 
			&nbsp; 
			<input value="Elimina" name="Invia1" type="submit"> 
					<input value="Reimposta" name="B49" type="reset"></font></td>
				</tr>
			</tbody></table>
			<input type="hidden" name="comando" value="delete_registry">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form2(userScelto,passScelta,this)">
			<div style="background-color: #66CCFF;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<font face="Verdana" size="2"><u><b>
			Add user</b></u> (registra un nuovo utente)</font></p></div>
				<table id="table81" width="100%" border="0">
			<tbody><tr>
					<td width="146">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Username scelta</font></td>
					<td width="1067">
					<p style="margin-top: 0pt; margin-bottom: 0pt;">
					<font face="Verdana" size="1">Password scelta</font></p></td>
				</tr>
			</tbody></table>
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<input name="userScelto" size="20" type="text"> 
			<input name="passScelta" size="20" type="password">&nbsp;&nbsp; 
			<input value="Aggiungi" name="Invia" type="submit">
			<input value="Reimposta" name="B47" type="reset"></p>
			<input type="hidden" name="comando" value="add_user">
		</form>
		<form method="post" action="ClientUDDIWeb" onsubmit="return validate_form4(userAmmDU,passAmmDU,userUtenteElimDU,passUtenteElimDU,this)">
			<div style="background-color: #66CCFF;">
			<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left">
			<font size="2" face="Verdana"><u><b>
			Delete user</b></u> (solo amministratore)</font><br>
				</p></div>
				<table id="table92" width="100%" border="0">
			<tbody><tr>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Username amm.</font></td>
					<td width="106">
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="1">Password amm.</font></td>
					<td width="176">
					<font face="Verdana" size="1">Username utente da eliminare</font></td>
					<td width="171">
					<font face="Verdana" size="1">Password utente da eliminare</font></td>
					<td width="643">
					&nbsp;</td>
				</tr>
				<tr>
					<td width="106">
					<font size="1" face="Verdana">
			<input name="userAmmDU" size="14" type="text"></font></td>
					<td width="106">
					<font size="1" face="Verdana"> 
			<input name="passAmmDU" size="14" type="password"></font></td>
					<td width="176">
					<font size="1" face="Verdana"> 
			<input name="userUtenteElimDU" size="25" type="password"></font></td>
					<td width="171">
					<font size="1" face="Verdana"> 
			<input name="passUtenteElimDU" size="25" type="password"></font></td>
					<td width="643">
					<font size="1" face="Verdana"> 
			&nbsp; 
			<input value="Elimina" name="Invia" type="submit"> 
					<input value="Reimposta" name="B50" type="reset"></font></td>
				</tr>
			</tbody></table>
			<input type="hidden" name="comando" value="delete_user">
		</form>

		</div></div></td>
		</tr>
		
	</tbody></table>



<p>&nbsp;</p>



<table border="1" width="100%" id="table85" cellpadding="3">
	<tr>
		<td>
		<div style="background-color: #CCFFFF">
		<p style="margin-top: 0pt; margin-bottom: 0pt;" align="left"><b>
		<font size="2" face="Verdana"><u>Help<a name="helpparametri"></a></u></font></b></p>
		</div>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">
		<span style="font-family: Verdana;" lang="EN-GB"><font size="2">
		ABBREVIAZIONI: BE = Business Entity, BS = Business Service, TM = TModel, 
		BT = Binding Template</font></span></p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">
		<span style="font-family: Verdana;"><font size="2">NOTE SUI PARAMETRI:</font></span></p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">
		&nbsp;</p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">
		<font size="2"><span style="font-family: Verdana">&lt;<b>AccessPoint</b>&gt;: 
		URL indicante l'indirizzo di rete utile per invocare il web service 
		descritto.</span></font></p>
		<p style="margin-top: 0pt; margin-bottom: 0pt;">
		<font size="2"><span style="font-family: Verdana">&lt;<b>UrlType</b>&gt;: 
		ulteriori informazione sul tipo di URL descritto dall'AccessPoint 
		(esempio: http, ecc.)</span></font></p>
					<p style="margin-top: 0pt; margin-bottom: 0pt">
					&nbsp;<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="2">&lt;<b>ServiceKey del BS superiore al 
					BT da eliminare</b>&gt;: Service Key del Business Service al 
					livello superiore del Binding Template da eliminare. 
					Verranno eliminati tutti i Binding Template sotto registrati 
					per il Business Service indicato.</font><p style="margin-top: 0pt; margin-bottom: 0pt">
					&nbsp;<p style="margin-top: 0pt; margin-bottom: 0pt">
					<font face="Verdana" size="2">&lt;<b>Inquiry URL</b>&gt;: URL per 
					invocare le UDDI inquiry API sul nuovo registry che si sta 
					salvando.</font><p style="margin-top: 0pt; margin-bottom: 0pt;">
		<font face="Verdana" size="2">&lt;<b>Publish URL</b>&gt;: URL per invocare le 
		UDDI publish API sul nuovo registry che si sta salvando.</font></p>
		</td>
	</tr>
</table>



</body></html>