public class Arrays 
{
		//Overview: Definisce operazioni per manipolare array
		
		// @ ensures(*if x in a \result è l'indice, else \result ==-1*);
		// @ assignable \nothing;
		public int search (int[ ] a, int x) 
		{
			return (-1);
		}
		
		// @ requires (*a ordinato per valori crescenti*);
		// @ ensures (*if x in a ritorna l'indice, else -1*);
		// @ assignable \nothing;
		public static int searchSorted (int[] a, int x)
		{
			if (a==null) return -1;
			
			for (int i=0; i<a.length; i++)
				if (a[i]==x) return 1;
				else if (a[i]>x) return -1;  // Siccome l'array è ordinato se supero un
						// elemento che è maggiore di quello che voglio cercare, di sicuro 
			            // dopo quell'elemento non lo troverò (perchè sarà sempre a[i]>x)
			
			return -1; 
		}
		
		// @ ensures (* a[*] è una permutazione di \old(a[*]) *)
		// @ && (* a ordinato per valori crescenti*);
		// @ assignable a[*];
		public void sort (int[] a) 
		{
			
		}
}