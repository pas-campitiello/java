public class Universitario extends Studente 
{
	private String matricola;
	
    public Universitario(String codiceFiscale, String cognome, String nome, String matricola) 
    {
		super(codiceFiscale, cognome, nome);
		this.matricola = matricola;
	}

    public float calcolaTasse() 
	{
		float CalcTasse;
		CalcTasse= getTasse();
		
		return CalcTasse;
	}

	public String getMatricola() 
	{	return matricola;   }
}
