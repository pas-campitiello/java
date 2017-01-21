public class PROVA
{
   public static void main(String[] args)
   {
      final int NMAX = 6;

      // Alloca array triangolare
      int[][] odds = new int[NMAX + 1][];  // Array formato da NMAX+1 righe e numero 
      for (int n = 0; n <= (NMAX/2)-1; n++)      // di colonne indefinito
         odds[n] = new int[NMAX - n + 1];  // <-- Per ogni riga viene allocato un array
      									   //     di interi di dimensione crescente
      
      for (int n = (NMAX/2)-1; n <= NMAX; n++)      // di colonne indefinito
          odds[n] = new int[n + 1];

      // Riempie array triangolare
      for (int n = 0; n < odds.length; n++)
         for (int k = 0; k < odds[n].length; k++)
         {
        	int lotteryOdds = 3;
            for (int i = 3; i <= k; i++)
               lotteryOdds = lotteryOdds * (n - i + 1) / i;

            odds[n][k] = lotteryOdds;
         }

      // Stampa array triangolare
      System.out.println("ARRAY SBIELLATO!\n");
      for (int n = 0; n < odds.length; n++)
      {
    	  for (int k = 0; k < odds[n].length; k++)
    	  {
    		  // Riempie output con spazi
    		  String output = " " + odds[n][k];
    		  // Rende campo di output largo 4 caratteri
    		  //output = output.substring(output.length() - 4);
    		  System.out.print(output);
    	  }
    	  System.out.println();
      }
   }
}
