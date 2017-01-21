public class Consumer extends Thread 
{
  private Buffer buff;
  //construct a producer object
  
  Consumer (Buffer b) 
  {
    buff = b;
  }
  
  public void run() 
  {
	  int value = 0;
	  
	  for (int i=0; i<10; i++)
	  {
		  value = buff.get();
		  System.out.println("Consumer got: " + value);
	  }
  }
}