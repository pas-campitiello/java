package it.polimi.si.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: LoginServlet
 * 
 */
public class LoginServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException 
	{
		// Sets the content type of the response being sent to the client, 
		// if the response has not been committed yet
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Errore</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Errore</h1>");
		out.println("<p>Metodo GET non supportato dalla servlet</p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException 
	{
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		if ("plebani".equals(userId) && "pierluigi".equals(password)) 
		{
			// Sets the content type of the response being sent to the client, 
			// if the response has not been committed yet
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
		
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hello</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hello</h1>");
			out.println("<p>L'utente "+ userId +" e' loggato</p>");
			out.println("</body>");
			out.println("</html>");
		} 
		else 
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Errore</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Errore</h1>");
			out.println("<p>L'utente "+ userId +" non e' autorizzato</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}