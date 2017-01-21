package it.polimi.si.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: HelloWorldServlet
 *
 */
public class HelloWorldServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("<p>Metodo GET</p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("<p>Metodo POST</p>");
		out.println("</body>");
		out.println("</html>");
	}  	  	    
}