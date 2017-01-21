package it.polimi.si.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: HelloUserServlet
 * 
 */
public class HelloUserServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	public HelloUserServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String utente = request.getParameter("utente");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World! " + utente + "</h1>");
		out.println("<p>Metodo GET</p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String utente = request.getParameter("utente");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World! " + utente + "</h1>");
		out.println("<p>Metodo POST</p>");
		out.println("Method: " + request.getMethod());
		out.println("<BR>");
		out.println("Request URI: " + request.getRequestURI());
		out.println("<BR>");
		out.println("User Agent: "+request.getHeader("User-Agent"));
		out.println("</body>");
		out.println("</html>");
	}
}