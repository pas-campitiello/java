import java.util.*;

public class SerieFibonacci 
{
	public static void main(String[] args) 
	{
		printFibos(1000000000);   // Con int massimo 1000000000
	}

	public static class Num 
	{
		public static Iterator allFibos() 
		{
			return new FibosGen();
		}

		// Classe interna
		private static class FibosGen implements Iterator 
		{
			private int prev1, prev2; //i due ultimi generati
			private int nextFib; //nuovo # Fibonacci generato
			
			FibosGen() 
			{
				prev2 = 1; 
				prev1 = 0;
			}
			
			public boolean hasNext () {return true;}
			
			public void remove () {}
			
			public Object next ( ) 
			{
				nextFib = prev1+prev2;
				prev2 = prev1; prev1=nextFib;
				return (Integer)(nextFib);
			}
		}
	}
	
	// @assignable System.out;
	// @ensures (*stampa tutti # Fibonacci <=m in ordine
	// @ crescente *);
	public static void printFibos(int m)
	{
		Iterator g = Num.allFibos();
		int i=0;
		while (g.hasNext()) //sempre true
		{
			i++;
			int p = ((Integer) g.next()).intValue();
			if (p > m ) return;
			System.out.println(i + ") ==> " + p);
		}
	}
}
