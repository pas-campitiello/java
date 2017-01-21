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
 * Servlet implementation class for Servlet: LoginServletBean
 */
public class LoginServletBean extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	UserBeanDataAccess dataAccess;
	int x=0;

	public void init() 
	{
		try 
		{
			dataAccess = new UserBeanDataAccess();
			x=1;
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("ClassNotFoundException --> " + e);
		} 
		catch (SQLException e) 
		{
			System.out.println("SQLException --> " + e);
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("NullPointerException --> " + e);
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
			if (dataAccess.validate(userId, password)) 
			{
				// Creo una nuova sessione per l'utente con userId 
				HttpSession session = request.getSession();
				session.setAttribute("utente", userId);

				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Welcome</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Elenco Utenti</h1>");

				// Collezione per stampare l'elenco degli utenti presenti nel database utenti 
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
					System.out.println("Errore dentro l'if dataAccess.validate(userId, password) -> " + e);
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
				out.println("<h1>Errore</h1>");
				out.println("<p>L'utente " + userId + " non e' autorizzato!</p>");
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
		catch (NullPointerException e1) 
		{			
		}
	}
}