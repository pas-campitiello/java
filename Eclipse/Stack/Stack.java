public class Stack 
{
	private Object[] data;
	private int free, max;
	
	/* Se chiamiamo un costruttore che lancia eccezioni, dobbiamo obbligatoriamente 
	 * rilanciarle(in alternativa inizializzare direttamente qui le	variabili)*/
	public Stack() throws NegStackSizeException    // <-------|
	{	this(10);	}
	
	public Stack(int size) throws NegStackSizeException
	{
		if (size >= 0) 
		{
			data = new Object[size];
			max = size; free = 0;
		}
		else throw new NegStackSizeException();
	}
		
	public Object pop() throws EmptyStackException 
	{
		if (free > 0) 
		{ return data[--free]; } 
		else throw new EmptyStackException();
	}
	
	public void push(Object o) throws FullStackException 
	{
		if (free < max) 
		{ data[free++] = o;	} 
		else throw new FullStackException(max, o);
	}
	
	public void stampaStack()
	{
		for (int j=0; j<max; j++)
			System.out.println("Elemento n° " + j + " presente nell'array dello stack: " + data[j]);
	}
}