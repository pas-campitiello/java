public class StackMAIN
{
	public static void main(String[] args) 
	{
		Stack s = null;
		try
		{	 s = new Stack(3);	}
		catch(NegStackSizeException nsse)
		{	System.err.println("Dimensione negativa!"); }
		
		/*try
		{	Object o1 = s.pop();	}
		catch(EmptyStackException vuoto)   
		{	
			// printStackTrace permette di vedere cosa è successo e continuare.
			// vuoto.printStackTrace();
			
			String str = vuoto.toString();
			System.out.println(str);
		}*/
										   
		
		
		for (int i = 0; i < 4; i++) 
		{
			try 
			{	s.push(new String("prova " + i));	} 
			catch (FullStackException fse) 
			{
				System.err.println(fse.getMessage()); 
				// Il messaggio è super("Max size is " + m);
				
				System.err.println("Resizing stack to hold "+(fse.getSize()*2)+" elements");
				
				Object[] data = new Object[fse.getSize()];
				
				for (int k = 0; k < data.length; k++) 
				{
					try { data[k] = s.pop();}
					catch (EmptyStackException e) {  }
				}
				
				Stack tmp = null;
				try
				{	tmp = new Stack(fse.getSize()*2);	}
				catch (NegStackSizeException e) {  }
				
				for (int j = data.length - 1; j >= 0; j--) 
				{
					try { tmp.push(data[j]); }
					catch (FullStackException e) {  }
				}
				
				s = tmp;
				// Re-inseriamo l’ultimo elemento che ha causato l'eccezione
				try { s.push(fse.getObject()); } 
				catch (FullStackException e) {  }
			}
		}

		s.stampaStack();
	}
}