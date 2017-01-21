import java.util.*;

public class ParadossoZenone 
{
	public static Iterator<Double> zenoIter(double d) throws IllegalArgumentException 
	{	return new IZ(d);	}

	private static class IZ implements Iterator<Double> 
	{
		private double distance; //distanza da coprire
		
		public IZ(double d) throws IllegalArgumentException 
		{
			if (d <= 0) throw new IllegalArgumentException();
			distance = d;
		}

		public boolean hasNext() 
		{
			if (distance<=0) System.out.printf("Distanza: %.20f",distance);
			
			return distance > 0;
		}

		public Double next() throws NoSuchElementException 
		{
			if (distance <= 0) throw new NoSuchElementException();
			distance /= 2; //restituisco metà della distanza da coprire; ne resterà ancora metà
			return distance; //autoboxing
		}
		
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	} //end of inner class "IZ"
}