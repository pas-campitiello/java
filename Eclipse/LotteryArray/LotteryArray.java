// In pratica questo programma realizza il tringolo di Tartaglia
// usando un array triangolare.

public class LotteryArray
{
   public static void main(String[] args)
   {
      final int NMAX = 3;

      // Alloca array triangolare
      int[][] odds = new int[NMAX + 1][];  // Array formato da NMAX+1 righe e numero 
      for (int n = 0; n <= NMAX; n++)      // di colonne indefinito
         odds[n] = new int[n + 1];         // <-- Per ogni riga viene allocato un array
      									   //     di interi di dimensione crescente

      // Riempie array triangolare
      for (int n = 0; n < odds.length; n++)
         for (int k = 0; k < odds[n].length; k++)
         {
            /*
               calcola coefficiente binomiale
               n * (n - 1) * (n - 2) * . . . * (n - k + 1)
               -------------------------------------------
               1 * 2 * 3 * . . . * k
            */
            int lotteryOdds = 1;
            for (int i = 1; i <= k; i++)
               lotteryOdds = lotteryOdds * (n - i + 1) / i;

            odds[n][k] = lotteryOdds;
         }

      // Stampa array triangolare
      System.out.println(":::: / TRIANGOLO DI TARTAGLIA \\ ::::\n");
      System.out.println("_________ coefficienti\n");
      for (int n = 0; n < odds.length; n++)
      {
    	  System.out.print("(a+b)^" + n + " = ");
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
