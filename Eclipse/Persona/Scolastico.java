public class Scolastico extends Studente 
{
	public Scolastico(String codiceFiscale, String cognome, String nome) 
	{
		super(codiceFiscale, cognome, nome);
	}

	public float calcolaTasse() 
	{
		float CalcTasse;
		CalcTasse= getTasse();
		
		return CalcTasse;
	}
}
