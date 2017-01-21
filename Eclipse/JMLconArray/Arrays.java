public class Arrays 
{
		//Overview: Definisce operazioni per manipolare array
		
		// @ ensures(*if x in a \result � l'indice, else \result ==-1*);
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
				else if (a[i]>x) return -1;  // Siccome l'array � ordinato se supero un
						// elemento che � maggiore di quello che voglio cercare, di sicuro 
			            // dopo quell'elemento non lo trover� (perch� sar� sempre a[i]>x)
			
			return -1; 
		}
		
		// @ ensures (* a[*] � una permutazione di \old(a[*]) *)
		// @ && (* a ordinato per valori crescenti*);
		// @ assignable a[*];
		public void sort (int[] a) 
		{
			
		}
}