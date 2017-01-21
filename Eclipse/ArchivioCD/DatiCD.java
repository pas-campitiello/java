public class DatiCD 
{
	private String titolo;
	private String autore;
	private float prezzo;
	private short giudizio;
	
	// Costruttore
	public DatiCD (String t, String a, float p, short g) 
	{
		prezzo = p;
		giudizio = g;
		titolo = t;
		autore = a;
	}
	
	public String getTitolo() 
	{	return titolo;	}
		
	public void setTitolo(String t) 
	{	titolo = t;		}
	
	public String getAutore() 
	{	return autore;	}
	
	public float getPrezzo() 
	{	return prezzo;	}
	
	public short getGiudizio() 
	{	return giudizio;	}
	
	public String toString() 
	{
		return titolo + "\n" + autore +	"\nprezzo: " + prezzo +	"\ngiudizio: " + giudizio;
	}
}
