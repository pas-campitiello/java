import java.util.Random;

public class LeggeGrandiNumeri
{
   public static void main(String[] args) 
   {
		int moneta=0;
		int numTeste=0,numCroci=0;
		double probT = 0,probC = 0;

		Random seme = new Random();

		for (int i=1; i<=10000; i++)
		{
			moneta = seme.nextInt(2)+1;
			
			if (moneta==1) 	
			{
				numTeste = numTeste + 1;
				probT = (double)numTeste/i; 
				probC = (double)numCroci/i; 
				System.out.println(i+")	" + moneta + " - Testa ("+numTeste+")	-->	probT = " + probT + "	probC = " + probC);
			}
			else
			{
				numCroci = numCroci + 1;
				probT = (double)numTeste/i; 
				probC = (double)numCroci/i; 
				System.out.println(i+")	" + moneta + " - Croce ("+numCroci+")	-->	probT = " + probT + "	probC = " + probC);
			}
		}
	}
}