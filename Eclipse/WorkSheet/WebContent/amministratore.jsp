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
AMMINISTRATORE DI PROGETTI<br>
 * si logga nel sistema e vede un elenco dei suoi progetti; sceglie un progetto e vede una struttura come OMP2009Effort.ods;<br>
 * non può vedere le schede personali dei singoli utenti;<br>
 * può creare nuovi progetti decidendo WorkPackage e altri parametri come data inizio progetto, persone che lavorano e WP a cui collaborano;<br>
 * può vedere/modificare i dati raggruppati in un pannello per:<br>
        - ciascun progetto<br>
	- allocazione preventiva (forecast)<br>
	- allocazione effettiva - per mese, per wp<br>
  	- ripartizione dell'allocazione sulle persone (per mese, per wp)<br>
  	- possibilita' di proiettare su 2 dimensioni (tempo*persone, tempo*wp)<br>

</body>
</html>
