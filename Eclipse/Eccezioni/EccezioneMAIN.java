import java.util.Scanner;

public class EccezioneMAIN 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		
		System.out.print("Inserire nuovo elemento: ");
		try
		{	
			num = input.nextInt();
			if (num>0) throw new NewKindOfException("Numero > 0");
			else throw new NewKindOfException();
		}	
		catch(NewKindOfException ecc)
		{
			String s = ecc.toString();
			System.out.println(s); 
		}
		
		System.out.println(num);
	}
}
