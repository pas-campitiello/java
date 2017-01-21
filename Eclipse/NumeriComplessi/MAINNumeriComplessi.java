public class MAINNumeriComplessi 
{
	public static void main (String[] args) 
	{
		Complex c1 = new Complex(-4, Math.PI);
		Complex c2 = new Complex(-8, 1);
		
		System.out.println("c1 = " +c1);
		System.out.println("c2 = " +c2);
		System.out.println("c1 + c2 = " +c1.sum(c2));
		System.out.println("c1 - c2 = " +c1.sub(c2));
		System.out.println("c1 * c2 = " +c1.mul(c2));
		
		try 
		{
			System.out.println("c1 / c2 = " +c1.div(c2));
		}
		catch (ArithmeticException e) 
		{
		}
	}
}
