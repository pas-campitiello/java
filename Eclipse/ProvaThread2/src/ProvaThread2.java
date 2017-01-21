public class ProvaThread2 
{
	public static void main(String[] args) 
	{
		//for (int i = 0;	i < Integer.parseInt(args[0]); i++)
		for (int i = 0;	i < 4; i++)
		{
			Thread thread =	new Thread(new Test(i));
			thread.start();
		}
	}
}
