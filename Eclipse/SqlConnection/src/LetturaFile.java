import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LetturaFile 
{
	static String filePath = "mysql"; 
	static String username;
	static String password;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		File f = new File(filePath);
		FileInputStream fis;
		
		try 
		{
			fis = new FileInputStream(f);
		
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			username = br.readLine();
			password = br.readLine();
			
			/*
			while(linea!=null) 
			{
			       System.out.println(linea);
			       username = linea;
			       linea = br.readLine();
			}
			*/
			System.out.println("username = " + username);
			System.out.println("password = " + password);
		} 
		catch (FileNotFoundException e) 
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
