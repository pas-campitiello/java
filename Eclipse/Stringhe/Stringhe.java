public class Stringhe 
{
	public static void main(String[] args) 
	{
		String K = args[0];
		
		System.out.println(args[0]);
		
		System.out.println(args[0].replaceAll ("[ \\p{Punct}]", ""));
		
		String nuova = args[0].replaceAll ("[^a-zA-Z0-9-_]", "");
		
		if (nuova.equals("")) 
			System.out.println("STRINGA: VUOTA");
		else System.out.println(nuova);
	}
}