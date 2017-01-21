package it.polimi.si.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException 
	{
        request.getSession().invalidate();
		getServletContext().getRequestDispatcher("/login.html").forward(request, response);
	}
}