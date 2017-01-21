package it.polimi.si.servlet;

import it.polimi.si.bean.UserBeanDataAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: LoginServletForward
 * 
 */
public class LoginServletForward extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	UserBeanDataAccess dataAccess;

	public void init() 
	{
		try 
		{
			dataAccess = new UserBeanDataAccess();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
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
		
		UserBeanDataAccess accessoDBmio = null;
		try 
		{
			accessoDBmio = new UserBeanDataAccess();
		} 
		catch (ClassNotFoundException e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try 
		{
			accessoDBmio.validate(userId, password);
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			if (dataAccess.validate(userId, password))  
			{
				HttpSession session = request.getSession();
				session.setAttribute("utente", userId);

				getServletContext().getRequestDispatcher("/UserListServlet").forward(request, response);
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
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}