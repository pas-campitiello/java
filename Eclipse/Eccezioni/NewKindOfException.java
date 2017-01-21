public class NewKindOfException extends Exception 
{
	private static final long serialVersionUID = 1L;  // A cosa serve questo?

	public NewKindOfException()
	{ super(); }
	
	public NewKindOfException(String s)
	{ super(s); } 
}