package servletLoginLogout;
	
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBeanDataAccess;
	
/**
 * Servlet implementation class for Servlet: LoginServletForward
 * 
 */
public class LoginServletForward extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	UserBeanDataAccess userBeanDataAccess;

	public void init() 
	{
		try 
		{
			userBeanDataAccess = new UserBeanDataAccess();
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		try 
		{
			HttpSession session = request.getSession();
			if (userBeanDataAccess.validate(username, password)) 
			{
				session.setAttribute("logged", Boolean.TRUE);
				session.setAttribute("utente", username);				
				
				getServletContext().getRequestDispatcher("/updateAPI_Amm.jsp").forward(request, response);
			} 
			else 
			{
				session.setAttribute("logged", Boolean.FALSE);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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