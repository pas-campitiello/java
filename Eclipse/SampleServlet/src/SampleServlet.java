import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class for Servlet: SampleServlet
 *
 */
 public class SampleServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
 {
	static final long serialVersionUID = 1L;
	private ServletConfig config;
   
	public void init (ServletConfig config) throws ServletException 
    {
		this.config = config;
	}

	public void destroy() {} // do nothing
  
	public ServletConfig getServletConfig() 
	{
		return config;
	}
  
	public String getServletInfo() 
	{
		return "A Simple Servlet";
	}

	public void service (ServletRequest req,ServletResponse res) throws ServletException, IOException  
	{
		res.setContentType( "text/html" );
		PrintWriter out = res.getWriter();
		out.println( "<html>" );
		out.println( "<head>" );
		out.println( "<title>A Sample Servlet</title>" );
		out.println( "</head>" );
		out.println( "<body>" );
		out.println( "<h1>A Sample Servlet</h1>" );
		out.println( "</body>" );
		out.println( "</html>" );
		out.close();
	}
}