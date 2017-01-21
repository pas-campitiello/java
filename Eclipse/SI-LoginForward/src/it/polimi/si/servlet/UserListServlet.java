package it.polimi.si.servlet;

import it.polimi.si.bean.UserBean;
import it.polimi.si.bean.UserBeanDataAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: UserListServlet
 * 
 */
public class UserListServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
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
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String utente = (String) session.getAttribute("utente");

		if (utente != null) 
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Elenco Utenti</h1>");
			out.println("<p>[Generata da UserListServlet]</p>");

			Collection users;
			try 
			{
				users = dataAccess.findAll();

				if (!users.isEmpty()) 
				{
					Iterator i = users.iterator();

					while (i.hasNext()) 
					{

						UserBean user = (UserBean) i.next();
						out.println("<p>" + user.getUserId() + "</p>");
					}

				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.println("<p></p>");
			out.println("<p><a href=\"LogoutServlet\">logout</a></p>");
			
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
			out.println("<p>Errore. Pagina accessibile solo ad utenti loggati</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}