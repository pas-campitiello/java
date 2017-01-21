public abstract class Studente extends Persona 
{
	private int tasse;
	
	public abstract float calcolaTasse();

	public int getTasse() 
	{	return tasse;	}

	public Studente(String codiceFiscale, String cognome, String nome) {
		super(codiceFiscale, cognome, nome);
	}
}
