//import java.io.*;
import java.util.*;

public class TestInput 
{
	public static void main(String args[]) 
	{
		/*// OPPUREtry 
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Come ti chiami ?");
			System.out.println("Ciao "+in.readLine());
		} 
		catch (IOException e) 
		{ }*/
		
		
		Scanner input = new Scanner(System.in);
		
		int num;
		
		System.out.print("Inserire nuovo elemento: ");
		num = input.nextInt();
		
		System.out.print("\nElemento inserito: "+num);
	}
}