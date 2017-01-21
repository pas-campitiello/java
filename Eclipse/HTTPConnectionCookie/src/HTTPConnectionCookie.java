import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class HTTPConnectionCookie 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("131.175.12.65", 8080));
		URL myUrl;
		URLConnection urlConn = null;
		
		String webPoliselfURL = new String("https://aunicalogin.polimi.it/aunicalogin/getservizio.xml?id_servizio=117&returnURL=http://www.polimi.it");
		
		String preURL	= new String("https://www10.ceda.polimi.it/polijtweb/");
		String postURL	= webPoliselfURL; 
				new String("polijtweb.jsp?edit0_0=__THMC__232&edit1_0=__THCB__NON_AUTENTICATO&edit2_0=__SV__398c2a38014ab48be47d459efc90f04c&javaWeb=true&asq=117&returnUrl=http%3A%2F%2Fwww.polimi.it&hcss=d3c697ba5c883a033da9262c56410c63&asq_id=28&object=15579&state=10&num_field=3&evn=EVNCMD_7&__pj0=0&__pj1=8dba1b7350155f75403238cb542cfdee");
		
		String cookie = null;
		
		System.out.println("Connecting...");
		
		try 
		{
			// Se è la prima richiesta al webPoliself setto solo l'URL opportuno, altrimenti URL opportuno e cookie
			if (postURL.equals(webPoliselfURL))
			{
				myUrl = new URL(postURL);
				System.out.println(myUrl);
				
				urlConn = myUrl.openConnection(proxy);
			}
			else 
			{
				myUrl = new URL(preURL + postURL);
				System.out.println(myUrl);
				
				urlConn = myUrl.openConnection(proxy);

				System.out.print("Setto cookie... ");
				
				// Costruisco il cookie e setto la proprietà "Cookie" per la request
				String myCookie = "JTAUTOLOGOFF=1pd1fn3l8ycim;";
				urlConn.setRequestProperty("Cookie", myCookie);
				
				System.out.print(myCookie);
				System.out.println("	[OK]");
			}
			
			urlConn = myUrl.openConnection(proxy);
			
			
			
			String headerName = null;
			for (int i=1; (headerName = urlConn.getHeaderFieldKey(i))!=null; i++) 
			{
			 	if (headerName.equals("Set-Cookie")) 
			 	{                  
			 		cookie = urlConn.getHeaderField(i);
			 		
			 		if (cookie.indexOf(";") != -1)
			 		{
			 			cookie = cookie.substring(0, cookie.indexOf(";"));
			 			String cookieName = cookie.substring(0, cookie.indexOf("="));
			 			String cookieValue = cookie.substring(cookie.indexOf("=") + 1, cookie.length());
			 			
			 			System.out.println("[line " +i+ "] cookie = " + cookie);
			 			System.out.println("[line " +i+ "] cookieName  = " + cookieName);
			 			System.out.println("         cookieValue = " + cookieValue);
			 		}
			 		else
			 		{
				 		System.out.println("[line " +i+ "] cookie = " + cookie);
			 		}
			 	}
			 	else
			 	{
			 		System.out.println("[line " +i+ "] NO cookie");
			 	}
			}
			
			
			// Retrieve information from HTTPS: GET
			InputStream istream = urlConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(istream));		   
			
			String rigaLetta;
			while ((br.read()) != -1) 
			{
				rigaLetta = br.readLine();
				
				// Subito dopo  "</script> </div>" c'è un link! 
				// readLine legge e sposta alla riga successiva dove c'è il link appunto.
				//if ( (rigaLetta.indexOf("Orario delle lezioni"))!=-1 ) 
					//System.out.println(rigaLetta.subSequence(rigaLetta.indexOf("<a href="), rigaLetta.indexOf("target")));
				
				System.out.println(rigaLetta);
			}
			istream.close();
		} 
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}