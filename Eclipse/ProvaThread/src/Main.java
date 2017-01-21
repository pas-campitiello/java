public class Main 
{
	public static void main (String args[]) 
    {
		// create shared buffer
		Buffer B = new Buffer (100);
    
		// create consumer
		Consumer C = new Consumer (B);
    
		// create producer
		Producer P = new Producer (B);
    
		// start consumer and producer
		//if (!C.isAlive()) 
			C.start();
		//if (!P.isAlive())
			P.start();
    }
}