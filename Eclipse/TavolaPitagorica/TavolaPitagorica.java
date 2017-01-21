public class TavolaPitagorica
{
 public static void  main(String[] args)
 {
   int k;
   int j;

   for (k=1;k<10;k++)
   {
     for (j=1;j<=10;j++)
     {
       if ((j*k)<10) System.out.print(" "+j*k+" ");
       else System.out.print(j*k+" ");
     }
     System.out.println();
   }
 }
}
