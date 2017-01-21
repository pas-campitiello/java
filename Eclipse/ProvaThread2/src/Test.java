public class Test implements Runnable
{
	private int number;
	
	public Test(int number)
	{
		this.number = number; 
	}
	
	public void run()
	{
		for (int i = 0; i < 2; i++)
	    {
			System.out.print("I am thread number " + number);
			System.out.println();
		}
	}
}