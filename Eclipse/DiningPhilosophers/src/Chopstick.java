public class Chopstick 
{
	private static int counter = 0;
	private int number = counter++;
	
	public String toString() 
	{
		return "Chopstick " + number;
	}
}