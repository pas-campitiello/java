public class FullStackException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	private Object extraObject;
	private int maxSize;
	
	public FullStackException (int m, Object o) 
	{
		super("Max size is " + m);
		maxSize = m;
		extraObject = o;
	}
	
	public Object getObject() 
	{ return extraObject; }
	
	public int getSize() 
	{ return maxSize; }	
}