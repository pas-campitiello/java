<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=utf-8">
	<TITLE>..:: WorkSheet ::..</TITLE>	

    <style type="text/css">
	/*demo page css*/
	body
	{ 
		font: 62.5% "Trebuchet MS", sans-serif; 
		margin: 5px; 
	}
	.demoHeaders 
	{ 
		margin-top: 2em; 
	}
	#dialog_link 
	{ 
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative; 
	}
	#dialog_link span.ui-icon 
	{ 
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px; 
	}
	ul#icons 
	{ 
		margin: 0;
		padding: 0; 
	}
	ul#icons li 
	{ 
		margin: 2px; 
		position: relative; 
		padding: 4px 0; 
		cursor: pointer; 
		float: left; 
		list-style: none; 
	}
	ul#icons span.ui-icon 
	{ 
		float: left; 
		margin: 0 4px; 
	}
    </style>
</HEAD>

<BODY>

<TABLE WIDTH=100% BORDER=0 CELLPADDING=4 CELLSPACING=0 STYLE="page-break-before: always; page-break-inside: avoid">
	<TR VALIGN=TOP>
		<TD ALIGN=CENTER>
			<P ALIGN=CENTER STYLE="border-bottom: 1px solid #000000;">
				<FONT SIZE=7><B>WorkSheet v0.05</B></FONT>
			</P>
		</TD>
		<TD>
			<IMG SRC="docs_icon.png" NAME="immagini1" ALIGN=LEFT WIDTH=83 HEIGHT=83 BORDER=0><BR>
		</TD>
	</TR>
</TABLE>



<TABLE WIDTH=800 BORDER=1 CELLPADDING=4 CELLSPACING=3 table style="margin:auto;">
	<TR>
		<TD>
			<FONT SIZE=4><B>Login</B> [solo utenti registrati]</FONT>
		</TD>
		
		<TD>
			<FONT SIZE=4><B>Registrazione utente</B></FONT>
		</TD>
	</TR>

	<TR>
		<TD VALIGN=TOP>
			<FORM NAME="login" ACTION="LoginServlet" METHOD="POST" onload=document.forms[1].reset()>
				<TABLE WIDTH=200 BORDER=0 CELLPADDING=4 CELLSPACING=0>
				
					<TR VALIGN=TOP>
						<TD>
							<P><FONT SIZE=4>Username</FONT></P>
						</TD>
			
						<TD WIDTH=198 SDVAL="3" SDNUM="1040;">
							<P><A NAME="usernameLog"></A>
								<INPUT TYPE=TEXT NAME="usernameLog">
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P><FONT SIZE=4>Password</FONT></P>
						</TD>
						<TD>
							<P><A NAME="passwordLog"></A><INPUT TYPE=PASSWORD NAME="passwordLog"></P>
						</TD>
					</TR>
	
					<TR VALIGN=TOP>
						<TD>
							<P><BR></P>
						</TD>
						<TD>
							<P>
								<INPUT TYPE=SUBMIT NAME="tastoLogin" Value="Login">
							</P>
						</TD>
					</TR>
					
					<TR VALIGN=TOP>
						<TD>
						</TD>
						<TD>
						</TD>
					</TR>
					
					<TR VALIGN=TOP>
						<TD>
						</TD>
						<TD>
							<%if ( session.getAttribute("registrato")!=null && ((Boolean)session.getAttribute("registrato")).booleanValue() ) 
							{ %>
									
								<br>	
									<p> 
										<font color=green>
										Ciao <%=session.getAttribute("username")%>! 
										<br>La tua registrazione e' stata completata con successo.
										</font>
									</p>

							<% session.removeAttribute("registrato"); 
								//session.invalidate();
								// NON funzia session.invalidate(); //altrimenti se refresho e ritrasmetto mi crea altra riga identica nel database
							} 
							else if ( session.getAttribute("registrato")!=null && !((Boolean)session.getAttribute("registrato")).booleanValue() ) 
							{ %>
								<br>	
								<br>
									<p> 
										<font color=red>
											La registrazione non e' andata a buon fine. Controllare i dati inseriti (sono tutti obbligatori).
										</font>
									</p>
							
							<% session.removeAttribute("registrato");
							} 
							else if ((session.getAttribute("logged")!=null) && !((Boolean)session.getAttribute("logged")).booleanValue()) { %>

								<br>
								<br>
									<p> 
										<font color=red>
											ERRORE.<br>Ricontrollare username e password.
										</font>
									</p>

							<%} %>
							
							
						</TD>
					</TR>
					
				</TABLE>
			</FORM>
		</TD>




		<TD>
			<FORM NAME="registrazione" ACTION="RegistrazioneServlet" METHOD="POST" onload=document.forms[2].reset()>
				<TABLE WIDTH=400 BORDER=0 CELLPADDING=4 CELLSPACING=0>

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Matricola </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="matricolaReg"></A><INPUT TYPE=TEXT NAME="matricolaReg">
							</P>
						</TD>
					</TR>
					

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Username </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="usernameReg"></A><INPUT TYPE=TEXT NAME="usernameReg">
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Password </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="passwordReg"></A><INPUT TYPE=PASSWORD NAME="passwordReg">
							</P>
						</TD>
					</TR>
					
					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Ripeti password </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="ripetiPasswordReg"></A><INPUT TYPE=PASSWORD NAME="ripetiPasswordReg">
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Nome </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="nomeReg"></A><INPUT TYPE=TEXT NAME="nomeReg">
							</P>
						</TD>
					</TR>
					
					<TR VALIGN=TOP>
						<TD WIDTH=256>
							<P ALIGN=RIGHT><FONT SIZE=4>Cognome </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="cognomeReg"></A><INPUT TYPE=TEXT NAME="cognomeReg">
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Mail </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="mailReg"></A><INPUT TYPE=TEXT NAME="mailReg">
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P ALIGN=RIGHT><FONT SIZE=4>Ruolo </FONT>
							</P>
						</TD>
						<TD>
							<P><A NAME="ruoloReg"></A>
								<SELECT NAME="ruoloReg">
									<OPTION SELECTED>
									<OPTION>Amministratore di progetti</OPTION>
									<OPTION>Ricercatore</OPTION>
								</SELECT> 
							</P>
						</TD>
					</TR>

					<TR VALIGN=TOP>
						<TD>
							<P><BR>
							</P>
						</TD>
						<TD>
							<P>
								<INPUT TYPE=SUBMIT NAME="tastoRegistrazione" Value="Registrazione">
							</P>
						</TD>
					</TR>
					
				</TABLE>
			</FORM>
		</TD>
	</TR>
</TABLE>





<P ALIGN=CENTER><FONT SIZE=2>Politecnico di Milano | Progetto di Laboratorio Software (prof. Agosta) | BONETTI Damiano - CAMPITIELLO Pasquale</FONT></P>

</BODY>

</HTML>
