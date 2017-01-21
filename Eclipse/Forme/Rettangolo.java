
public class Rettangolo extends Quadrilatero 
{
	private float base;
	private float altezza;

	public Rettangolo(float base, float altezza) 
	{
		super();
		this.base = base;
		this.altezza = altezza;
		super.setArea(base*altezza);
		super.setPerimetro((base+altezza)*2);
	}
	
	public String disegna()
	{
		return "Base=" +base+ ", altezza=" +altezza;
	}

	public float getAltezza() 
	{	return altezza;	  }
	
	
}
