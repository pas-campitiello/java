public class DiningPhilosophers 
{
	public static void main(String[] args) 
	{
		Philosopher[] philosopher = new	Philosopher[Integer.parseInt(args[0])];
		
		Philosopher.ponder = Integer.parseInt(args[1]);
		
		Chopstick left = new Chopstick(), 
		          right = new Chopstick(), 
		          first = left;
		
		int i = 0;
		
		while(i < philosopher.length - 1) 
		{
			philosopher[i++] = new Philosopher(left, right);
			left = right;
			right = new Chopstick();
		}
		
		if(args[2].equals("deadlock"))
			philosopher[i] = new Philosopher(left, first);
		else // Swapping values prevents deadlock:
			philosopher[i] = new Philosopher(first, left);
	}
} 