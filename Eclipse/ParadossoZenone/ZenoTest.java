import java.util.Iterator;

public class ZenoTest 
{
	public static void main(String[] args) 
	{
		if (args.length != 1) System.out.println("Missing argument: distance.");
		else 
		{
			try 
			{
				double d = Double.parseDouble(args[0]);
				Iterator<Double> iter = ParadossoZenone.zenoIter(d);
				double percorsa = 0;
				while (iter.hasNext()) 
				{
					percorsa += iter.next();
					System.out.printf("%.20f\n",percorsa);
				}
			}
			catch (Exception e) 
			{
					System.out.println("Eccezione" + e);
			}
				
			// raggiungerà il Pelide Achille il suo traguardo?
		} 	
	}
}
