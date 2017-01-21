public abstract class Persona 
{
	private String CodiceFiscale;
	private String Cognome;
	private String Nome;
	
	public String getCodiceFiscale() 
	{	return CodiceFiscale;	}
	
	public String getCognome() 
	{	return Cognome;	  }
	
	public String getNome() 
	{	return Nome;	}

	public Persona(String codiceFiscale, String cognome, String nome)
	{
		super();

		CodiceFiscale = codiceFiscale;
		Cognome = cognome;
		Nome = nome;
	}
}
