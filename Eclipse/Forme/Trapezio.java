public class Trapezio extends Quadrilatero 
{
	private float altezza;
	
	private float base2;
	
	private float lato2;
	
	public Trapezio(float altezza, float base2, float lato2) 
	{
		super();
		this.altezza = altezza;
		this.base2 = base2;
		this.lato2 = lato2;
	}
	
	public String disegna()
	{
		return "Altezza=" +altezza+ ", base2=" +base2+ ", lato2=" +lato2;
	}
}
