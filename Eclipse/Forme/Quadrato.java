public class Quadrato extends Rettangolo 
{
	public Quadrato (float lato)
	{
		super(lato,lato);
	}
	
	public String disegna()
	{
		return "Lato = " +super.getAltezza();
	}

}
