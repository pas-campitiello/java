<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=utf-8">
	<TITLE>..:: WorkSheet ::..</TITLE>	

  <head>
    <link type="text/css" href="ricercatore/css/theme/jquery-ui-1.8.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="ricercatore/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="ricercatore/js/jquery-ui-1.8.1.custom.min.js"></script>
    <script type="text/javascript" src="ricercatore/jquery.sheet.min.js"></script>
    
    <script type="text/javascript">
    
	$(document).ready
	(
	    function()
	    {
	        $('#tabs1').tabs();
	        $('#tabs2').tabs();
	        $('div#tabs1').hide();
	        $('div#tabs2').hide();
	        
	        $('a#mostraTab1').click
	        (
	            function()
	            {
	                $('#tabs1').slideDown('slow');
	                $('div#tabs1').show();
	            }
	        )
	        
	        
	        $('a#nascondiTab1').click
	        (
	            function()
	            {
	                $('#tabs1').hide('slow');
	                $('div#tabs1').hide();
	            }
	        )
	        
	        $('a#mostraTab2').click
	        (
	            function()
	            {
	                $('#tabs2').slideDown('slow');
	                $('div#tabs2').show();
	            }
	        )
	        
	        
	        $('a#nascondiTab2').click
	        (
	            function()
	            {
	                $('#tabs2').hide('slow');
	                $('div#tabs2').hide();
	            }
	        )
	    }
	);

    </script>
    
    
    <script language="javascript">
    function soloNumeri(id)
    {
    	var valore = document.getElementById(id).value;
        valore = valore.replace (/[^\d]/g,'');
        document.getElementById(id).value = valore;
    }
	</script>
    
    
    
    
    
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
		text-decoration: bold;
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
  </head>
  
  <body>
	<TABLE WIDTH=100% BORDER=0 CELLPADDING=4 CELLSPACING=0 STYLE="page-break-before: always; page-break-inside: avoid">
		<TR VALIGN=TOP>
			<TD>
				<P ALIGN=CENTER STYLE="border-bottom: 1px solid #000000;">
					<FONT SIZE=7><B>WorkSheet</B></FONT>
					
					<font size="2">
					<b>Salve <%=session.getAttribute("username")%>!</b> [<%=session.getAttribute("ruolo")%>] <b>| <a href="LogoutServlet">logout</a></b>
					
					</font>
				</P>
			</TD>
			<TD>
				<IMG SRC="docs_icon.png" NAME="immagini1" ALIGN=LEFT WIDTH=83 HEIGHT=83 BORDER=0><BR>
			</TD>
		</TR>
	</TABLE>
	

  	<!-- tabella menu -->
  	<form name="ore">
  	<table BORDER=0>

 	  <tr>
 	    <td style="width: 150px;">Progetto</td>
  	    <td style="width: 150px;">Work Package</td>
  	    <td style="width: 150px;">Mese</td>
  	    <td style="width: 150px;">Giorno</td>
  	    <td style="width: 150px;">Ore</td>
 	 </tr>
 	 
 	 <tr>
 	    <td style="width: 150px;"> 
     		<select name="progetto">
     			<option selected>
     			<option>progetto1</option>
     			<option>progetto2</option>
     			<option>progetto3</option>
     		</select>
  	    </td>
  	    
  	    <td>
  	        <select name="work_package">
     			<option selected>
     			<option>WP1</option>
     			<option>WP2</option>
     			<option>WP3</option>
     		</select>
     	    </td>
     	    
     	    <td>
     	        <select name="mese">
     			<option selected>
     			<option>Mese1</option>
     			<option>Mese2</option>
     			<option>Mese3</option>
     		</select>
     	    </td>
     	    
     	    <td>
     	        <select name="giorno">
     			<option selected>
     			<option>1gen2010</option>
     			<option>2gen2010</option>
     			<option>3gen2010</option>
     		</select>
     	    </td>
     	    
     	    <td>
     	        <input type=text name="ore_lavorate" size="2" id="numero" onblur="soloNumeri('numero')" onkeyup="soloNumeri('numero')">
     	    </td>
  	    
 	    <td style="width: 150px;">
   	        <input type=submit name="salva_ore" value="Salva">
  	    </td>
 	 </tr>

	</table>  
	</form>
       	

    
    <!-- Tab scheda progetto-->
    <h2 class="demoHeaders">Scheda Progetto</h2>
    <a href="#" id="mostraTab1">mostra</a>
    <a href="#" id="nascondiTab1">nascondi</a>
		<div id="tabs1">
			<ul>
				<li><a href="#tabs1-1">Mese1</a></li>
				<li><a href="#tabs1-2">Mese2</a></li>
				<li><a href="#tabs1-3">Mese3</a></li>
				<li><a href="#tabs1-1">Mese1</a></li>
				<li><a href="#tabs1-2">Mese2</a></li>
				<li><a href="#tabs1-3">Mese3</a></li>
				<li><a href="#tabs1-1">Mese1</a></li>
				<li><a href="#tabs1-2">Mese2</a></li>
				<li><a href="#tabs1-3">Mese3</a></li>
				<li><a href="#tabs1-1">Mese1</a></li>
				<li><a href="#tabs1-2">Mese2</a></li>
				<li><a href="#tabs1-3">Mese3</a></li>
			</ul>
			<div id="tabs1-1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
			<div id="tabs1-2">Phasellus mattis tincidunt nibh. Cras orci urna, blandit id, pretium vel, aliquet ornare, felis. Maecenas scelerisque sem non nisl. Fusce sed lorem in enim dictum bibendum.</div>
			<div id="tabs1-3">Nam dui erat, auctor a, dignissim quis, sollicitudin eu, felis. Pellentesque nisi urna, interdum eget, sagittis et, consequat vestibulum, lacus. Mauris porttitor ullamcorper augue.</div>
		</div>

<!-- Tab riepilogo progetti -->
    <h2 class="demoHeaders">Riepilogo progetti</h2>
    <a href="#" id="mostraTab2">mostra</a>
    <a href="#" id="nascondiTab2">nascondi</a>
		<div id="tabs2">
			<ul>
				<li><a href="#tabs2-1">Mese1</a></li>
				<li><a href="#tabs2-2">Mese2</a></li>
				<li><a href="#tabs2-3">Mese3</a></li>
			</ul>
			<div id="tabs2-1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
			<div id="tabs2-2">Phasellus mattis tincidunt nibh. Cras orci urna, blandit id, pretium vel, aliquet ornare, felis. Maecenas scelerisque sem non nisl. Fusce sed lorem in enim dictum bibendum.</div>
			<div id="tabs2-3">Nam dui erat, auctor a, dignissim quis, sollicitudin eu, felis. Pellentesque nisi urna, interdum eget, sagittis et, consequat vestibulum, lacus. Mauris porttitor ullamcorper augue.</div>
		</div>

   
  </body>
  
  
</html>

