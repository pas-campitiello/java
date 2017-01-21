package registrazione;

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
 * Servlet implementation class RegistrazioneServlet
 */
public class RegistrazioneServlet extends HttpServlet 
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
    public RegistrazioneServlet() 
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
		String matricola 		= request.getParameter("matricolaReg");
		String username 		= request.getParameter("usernameReg");
		String password 		= request.getParameter("passwordReg");
		String ripetiPassword	= request.getParameter("ripetiPasswordReg");
		String nome 			= request.getParameter("nomeReg");
		String cognome	 		= request.getParameter("cognomeReg");
		String mail	 			= request.getParameter("mailReg");
		String ruolo 			= request.getParameter("ruoloReg");
		

		HttpSession session = request.getSession();
		
		if (matricola.equals("") || username.equals("") || password.equals("") || !password.equals(ripetiPassword) ||
			nome.equals("") || cognome.equals("") || mail.equals("") || ruolo.equals("") )
		{
			session.setAttribute("registrato", Boolean.FALSE);
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		    return;
		}
		else 
		{
			session.setAttribute("registrato", Boolean.TRUE);
			session.setAttribute("username", username);
			
			try
			{
				//accessoDatiUtente = new UserBeanDataAccess();
				accessoDatiUtente.registraNuovoUtente(matricola, username, password, nome, cognome, mail, ruolo);
				//accessoDatiUtente.getConnection().close();
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
			/*catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
			*/
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			request.getSession().invalidate();
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
