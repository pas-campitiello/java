import java.util.Random;

public class Producer extends Thread 
{
	private Buffer buff;
	//construct a producer object
  
	private int number;
  
	Producer (Buffer b) 
	{
		buff = b;
	}
  
	public void run() 
	{
		//Random alea = new Random();
		//int prodotto = alea.nextInt(10);
	  
		for (int i=0; i<10; i++)
		{
			buff.put(i);
			System.out.println("Producer put: " + i);
		}
	}
}