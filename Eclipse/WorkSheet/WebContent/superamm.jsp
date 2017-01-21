<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=utf-8">
	<TITLE>..:: WorkSheet ::..</TITLE>	
</HEAD>

<BODY>

<TABLE WIDTH=100% BORDER=0 CELLPADDING=4 CELLSPACING=0 STYLE="page-break-before: always; page-break-inside: avoid">
	<COL WIDTH=216*>
	<COL WIDTH=40*>

	<TR VALIGN=TOP>
		<TD WIDTH=84%>
			<P ALIGN=CENTER STYLE="border-bottom: 1px solid #000000;">
				<FONT SIZE=7><B>WorkSheet v0.02</B></FONT>
			</P>
		</TD>
		<TD WIDTH=16%>
			<P ALIGN=CENTER><IMG SRC="docs_icon.png" NAME="immagini1" ALIGN=LEFT WIDTH=83 HEIGHT=83 BORDER=0><BR>
			</P>
		</TD>
	</TR>
</TABLE>

Salve <%=session.getAttribute("username")%>! - Ruolo <%=session.getAttribute("ruolo")%> | <a href="LogoutServlet">logout</a>
<hr>

<br><br>
SuperAmministratore:<br>
 * si logga nel sistema e vede l'elenco di tutti gli Amministratori di progetto e di tutti i Ricercatori. Ogni Amministratore di progetto o Ricercatore è 
    un link che porta rispettivamente alla pagina dell'Amministratore di progetto oppure alla pagina del Ricercatore in cui si possono visualizzare 
    salvare le schede personali;<br>
 * può modificare i dati di profiliazione personali degli Amministratori o dei Ricercatori;<br>
 * può modificare/eliminare i dati dei singoli progetti creati e salvati dai vari Amministratori;<br>
 * può modificare i fogli di lavoro dei vari Ricercatori.<br>

</body>
</html>
