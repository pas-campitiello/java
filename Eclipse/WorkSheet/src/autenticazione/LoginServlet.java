package autenticazione;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBean.UserBeanDataAccess;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	UserBeanDataAccess accessoDatiUtente;

	// Primo metodo eseguito nella servlet: apre la connessione al database tramite un oggetto UserBeanDataAccess
	public void init() 
	{
		try 
		{
			accessoDatiUtente = new UserBeanDataAccess();
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
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		getServletContext().getRequestDispatcher("/errore.htm").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("usernameLog");
		String password = request.getParameter("passwordLog");

		try 
		{
			HttpSession session = request.getSession();
			
			if (accessoDatiUtente.validate(username, password)) 
			{
				session.setAttribute("logged", Boolean.TRUE);
				session.setAttribute("username", username);
				
				String ruolo = accessoDatiUtente.getRuolo(username,password);
				
				session.setAttribute("ruolo", ruolo);	
				
				if (ruolo.equals("Ricercatore")) 
					getServletContext().getRequestDispatcher("/ricercatore/ricercatore.jsp").forward(request, response);
				else if (ruolo.equals("Amministratore di progetti")) 
					getServletContext().getRequestDispatcher("/amministratore.jsp").forward(request, response);
				else if (ruolo.equals("superamministratore")) 
					getServletContext().getRequestDispatcher("/superamm.jsp").forward(request, response);
			} 
			else 
			{
				session.setAttribute("logged", Boolean.FALSE);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			//getServletContext().getRequestDispatcher("/errore.htm").forward(request, response);
			// TODO Auto-generated method stub
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter(); 
			out.println("<html>"); 
			out.println("<head>");
			out.println("<title>Errore</title>"); 
			out.println("</head>");
			out.println("<body>"); 
			out.println("<h1>Errore</h1>"); 
			out.println("<p>e = "+e+"</p>"); 
			out.println("<p>e.getLocalizedMessage() = "+e.getLocalizedMessage()+"</p>");
			out.println("<p>e.getMessage() = "+e.getMessage()+"</p>");
			out.println("<p>e.hasCode() = "+e.hashCode()+"</p>");
			out.println("<p>e.toString() = "+e.toString()+"</p>");
			out.println("<p>e.getStackTrace() = "+e.getStackTrace()+"</p>");
			out.println("</body>");
		    out.println("</html>");
			return;
		} 
	}

	
	
	
	// Ultimo metodo eseguito nella servlet: chiude la connessione al database tramite un oggetto UserBeanDataAccess
	public void destroy() 
	{
		try 
		{
			accessoDatiUtente.getConnection().close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
