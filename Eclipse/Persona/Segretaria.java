public class Segretaria extends Lavoratore 
{
	public float calcolaStipendio() 
	{
		float CalcStip;
		CalcStip= getStipendio();
		
		return CalcStip;
	}

	public Segretaria(String codiceFiscale, String cognome, String nome, int stipendio) 
	{
		super(codiceFiscale, cognome, nome, stipendio);
	}
}
