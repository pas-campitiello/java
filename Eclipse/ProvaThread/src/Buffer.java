public class Buffer 
{
  private int n;
  // size of buffer
  
  private int [] contents;
  // contents of buffer
  
  private int in, out = 0;
  // indexes of where to read from/write to

  private int total = 0;
  // number of items in the buffer

  Buffer (int size) 
  {
      n = size;
      contents = new int [n];
  }
  
  public synchronized void put (int item) 
  {
      while (!(total < n))
        // wait until there is space
    	// Aspetta fino a quando si crea lo spazio nel buffer, eventualmente pieno
        try { wait(); }
        catch (InterruptedException e)
        { }
      
      contents [in] = item;
      
      System.out.println(" Buffer: write at " + in + " item " + item);
      
      if (++in == n) in = 0;
      
      total++;
      
      notify(); // wake up any blocked threads
  }
  
  public synchronized int get () 
  {
	  int temp;
	  // wait till there is something
	  // Aspetta fino a quando ci sia qualcosa nel buffer, eventualmente vuoro
	  while (!(total > 0)) 
		try 
	    { 
			System.out.println("Buffer vuoto. Aspetto...");
			wait();
		}
	  	catch (InterruptedException e) 
	  	{ }
	  
	  temp = contents[out];
	  System.out.println(" Buffer: read from " + out + " item " + temp);
	  
	  if (++out == n) out = 0;
	  
	  total--;
	  
	  notify();    // wake up any blocked threads
	 
	  return temp;
	}
}