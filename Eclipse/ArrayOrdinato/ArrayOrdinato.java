import java.util.Scanner;

public class ArrayOrdinato 
{
	public static boolean sorted (int[] a) throws IndexOutOfBoundsException 
	{
		int prev;
		
		try 
		{ prev=a[14]; }      // Lancia eccezione se ci si riferisce ad una posizione oltre
							 // il limite dell'array (era meglio check diretto su a)

		catch (IndexOutOfBoundsException e)
		{	
			System.out.println("\nERRORE nel riferirsi ad all'array!");
			return true;	
		} 
		
		for (int i=1; i<a.length; i++) 
		{
			if (prev <= a[i]) prev=a[i];
			else return false;
		}

		return true;
	}
	
	public static void main(String[] args) 
	{
		final int SIZE = 10;
		int[] vettore = new int[SIZE];
		
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<vettore.length;i++)
		{
			System.out.print("Inserire l'elemento n° " + (i+1) + ": ");
			vettore[i]=input.nextInt();
		}
		
		if (sorted(vettore)) System.out.println("\nVettore ordinato!");
		else System.out.println("\nVettore DISORDINATO!");
	}
}
