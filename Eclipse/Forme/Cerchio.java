public class Cerchio extends Forma 
{
	private double raggio;
	
	public Cerchio(double raggio) 
	{
		super();
		this.raggio = raggio;
	}

	public String disegna() 
	{
		return null;
	}

	public double getRaggio() 
	{	return raggio;	}

	public void setRaggio(double raggio) 
	{	this.raggio =  raggio;   }

	public double getArea()
	{
		return Math.PI*raggio*raggio;
	}
	
	public double getCirconferenza()
	{
		return Math.PI*2*raggio;
	}
}