import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Prova
 *
 */
 public class Prova extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
 {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Prova() 
	{
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Questo metodo GET non fa altro che restituire a video il messaggio
	 * "METODO GET - Richiesta" + request.getParameter("nome")" 
	 * dove "nome" è stato scelto nel file index.html alla riga
	 *  <input name = "nome" type = "text"/>. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//System.out.println("Questo è il nome: ..>" + request.getParameter("nome"));
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//out.println("<html><head><title>");
		out.println("METODO GET - Richiesta" + request.getParameter("nome"));
		//out.println("</title></head>");
		//out.println("<body>");

	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//out.println("<html><head><title>");
		out.println("METODO POST - Richiesta" + request.getParameter("nome"));
	}   	  	    
}