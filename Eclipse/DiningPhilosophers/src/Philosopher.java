import java.util.Random;

public class Philosopher extends Thread 
{
	private static Random rand = new Random();
	private static int counter = 0;
	private int number = counter++;
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	static int ponder = 0; // Package access
	
	public Philosopher(Chopstick left, Chopstick right) 
	{
		leftChopstick = left;
		rightChopstick = right;
		start();	
	}
	
	public void think() 
	{
		System.out.println(this + " thinking");
		if(ponder > 0)
			try  
			{
				sleep(rand.nextInt(ponder));
			} 
			catch(InterruptedException e) 
			{
				throw new RuntimeException(e);
			}
	}
	
	public void eat() 
	{
		synchronized(leftChopstick) 
		{
			System.out.println(this + " has " + this.leftChopstick + " Waiting for " + this.rightChopstick);
			
			synchronized(rightChopstick) 
			{
				System.out.println(this + " eating");
			}
		}
	}
	
	public String toString() 
	{
		return "Philosopher " + number;
	}
	
	public void run() 
	{ 
		while(true) 
		{
			think();
			eat();
		}
		}
	}