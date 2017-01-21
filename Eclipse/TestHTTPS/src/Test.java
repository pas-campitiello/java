 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.io.Writer;
 import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.client.HttpClient;

 public class Test 
 {
        
     public static final String TARGET_HTTPS_SERVER = "www.verisign.com"; 
     public static final int    TARGET_HTTPS_PORT   = 443; 
        
     public static void main(String[] args) throws Exception 
     {
    	 HttpClient httpclient = new HttpClient();
    	 httpclient.getHostConfiguration().setProxy("myproxyhost", 8080);
    	 
    	 httpclient.getState().setProxyCredentials("my-proxy-realm", " myproxyhost",
    	 new UsernamePasswordCredentials("my-proxy-username", "my-proxy-password"));
    	 GetMethod httpget = new GetMethod("https://www.verisign.com/");
    	 try { 
    	   httpclient.executeMethod(httpget);
    	   System.out.println(httpget.getStatusLine());
    	 } finally {
    	   httpget.releaseConnection();
    	 }
     }
}