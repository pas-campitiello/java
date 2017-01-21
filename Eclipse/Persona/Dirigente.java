public class Dirigente extends Lavoratore 
{
	public float calcolaStipendio() 
	{
		float CalcStip;
		CalcStip= getStipendio();
		
		return CalcStip;
	}

	public Dirigente(String codiceFiscale, String cognome, String nome, int stipendio) 
	{
		super(codiceFiscale, cognome, nome, stipendio);
		// TODO Auto-generated constructor stub
	}
}
