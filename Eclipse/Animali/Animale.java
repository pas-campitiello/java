public abstract class Animale 
{
	protected String nome; /* PROTECTED Stringa visibile solo alle sottoclassi e alle classi 
							  nello	stesso package; viene ereditata */
	
	/* Questo costruttore è invocato automaticamente dai costruttori delle sottoclassi (come 
	 * prima istruzione). La System.out serve a mostrare questo effetto. NON è invocabile 
	 * direttamente. */
	protected Animale()
	{
		System.out.print("Sono un animale generico, appena nato...");
	}
	
	/* L'unico metodo (astratto anche lui) - da implementarsi in modo diverso in ogni animale 
	 * diverso.
	 * Un metodo astratto è un metodo per il quale non viene specificata alcuna implementazione
     * Una classe è astratta se contiene almeno un metodo astratto. 
     * Non è possibile creare istanze di una classe astratta
     * Le classi astratte sono molto utili per introdurre delle astrazioni di alto livello. */
	abstract void verso();
		
	public String getNome() 
	{
		if (nome != null ) return nome;
		return "!No name!";
	}
}