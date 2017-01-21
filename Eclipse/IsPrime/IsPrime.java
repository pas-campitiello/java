public class IsPrime 
{
	public static void main(String[] args)
	throws NumberFormatException 
	{													// In JAVA 5 è possibile fare così: 
		for(int i=0; i<args.length ; i++)               //  for(String s : args){ 
		{												//  int n = Integer.parseInt(s);		      											
			String s = args[i];							//   xxx cancellare questa riga xxx
			int n = Integer.parseInt(s);				//  ... continuare con lo stesso codice
			int div = 2;
			boolean isPrimo = true;
	    
			while (div<n && isPrimo) 
			{
				if (n % div == 0) isPrimo = false;
				div++;
			}
	    
			if (isPrimo) System.out.println( n + " e' primo!");
			else System.out.println( n + " NON e' primo!");
		}
		
	 /* USANDO MIO ALGORITMO IN PRIMO.PAS SI AVREBBE:
        
		for(int j=0; j<args.length ; j++)
		{
			String s = args[j];
		
			int n = Integer.parseInt(s);
		 
			int i=1,c=0;
			do
			{
				if ((n%i) == 0) c=c+1;
				i=i+1;
			}
			while ((i<n) && (c<=1));
						
			if (c==1)  System.out.printf("\n%d e' un numero primo\n",n);
			else  System.out.printf("\n%d NON e' primo\n",n);
	 
		}
	 */
	}
}

