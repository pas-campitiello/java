public abstract class Lavoratore extends Persona 
{
	private int stipendio;
	
	public abstract float calcolaStipendio();

	public Lavoratore(String codiceFiscale, String cognome, String nome, int stipendio) 
    {
		super(codiceFiscale, cognome, nome);
		this.stipendio = stipendio;
	}

	public int getStipendio() 
	{	return stipendio;	}
}
