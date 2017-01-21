/**
 * HttpsClient.java
 * Copyright (c) 2005 by Dr. Herong Yang
 */
import java.io.*;
import java.net.*;


public class TestHTTPConnection 
{
   public static void main(String[] args) 
   {
	   URL url;
	   String preURL	= "https://www10.ceda.polimi.it/polijtweb/";
	   String postURL	= "polijtweb.jsp?edit0_0=__THMC__232&edit1_0=__THCB__NON_AUTENTICATO&edit2_0=__SV__4208e102310211f38a99f2fb34d5273e&javaWeb=true&asq=117&returnUrl=http%3A%2F%2Fwww.polimi.it&hcss=0320940111585be38faaf7db31df6e4a&asq_id=28&object=5492&state=10&num_field=3&evn=EVNCMD_7&__pj0=0&__pj1=9987a3e06b4cda672e03f90bdbe5de35";
	   
	   try
	   {
		   Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("131.175.12.65", 8080));		   
		   
		   if (postURL.equals("https://aunicalogin.polimi.it/aunicalogin/getservizio.xml?id_servizio=117&returnURL=http://www.polimi.it"))
			   url = new URL(postURL);
		   else url = new URL(preURL + postURL);
		   
		   //System.out.println(1>2 ? "bubu":"bafa");
		   
		   System.out.println(url);
		   URLConnection conn = url.openConnection(proxy);
		   System.out.println("conn = " + conn);
		   System.out.println();

		   // Retrieve information from HTTPS: GET
		   InputStream istream = conn.getInputStream();
		   BufferedReader br = new BufferedReader(new InputStreamReader(istream));		   
		   
		   while ((br.read()) != -1) 
		   {
		       System.out.println(br.readLine());
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
