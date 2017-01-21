package it.polimi.si.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: LoginServletForward
 * 
 */
public class LoginServletJDBC extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	Connection connection;

	public void init() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/utenti";

		try 
		{
			connection = DriverManager.getConnection(url, "root", "pas");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException 
	{
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

		try 
		{
			PreparedStatement stm = connection.prepareStatement("SELECT userid FROM utente WHERE userid=? AND password=?");

			stm.setString(1, userId);
			stm.setString(2, password);
			ResultSet res = stm.executeQuery();

			if (res.next()) 
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Hello</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Hello</h1>");
				out.println("<p>L'utente " + userId + " e' loggato</p>");
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
				out.println("<p>L'utente " + userId + " non e' autorizzato</p>");
				out.println("</body>");
				out.println("</html>");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e1) 
		{
			// TODO Auto-generated catch block
			System.out.println("PORCA "+e1.getLocalizedMessage());
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Errore</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h1>Errore</h1>");
			out.println("<p>connection <b>" + connection + "</b></p>");
			out.println("<p>user <b>" + userId + "</b></p>");
			out.println("<p>password <b>" + password + "</b></p>");
			out.println("<p>getLocalizedMessage <b>" + e1.getLocalizedMessage() + "</b></p>");
			out.println("<p>getMessage          <b>" + e1.getMessage() + "</b></p>");
			out.println("<p>toString            <b>" + e1.toString() + "</b></p>");
			out.println("<p>fillInStackTrace    <b>" + e1.fillInStackTrace() + "</b></p>");
			out.println("<p>getCause            <b>" + e1.getCause() + "</b></p>");
			
			out.println("</body>");
			out.println("</html>");
		}
	}

	public void destroy() 
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}