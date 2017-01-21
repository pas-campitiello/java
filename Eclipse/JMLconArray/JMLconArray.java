public class JMLconArray
{
	public static void main(String[] args) 
	{
		int[] vett = {1,2,3};
		
		if (Arrays.searchSorted(vett, 2)==-1) 
			System.out.println("L'elemento cercato NON è stato trovato nell'array!!!");
		else System.out.printf("Elemento trovato alla posizione %d",Arrays.searchSorted(vett, 2));
	}
}