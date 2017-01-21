public class MainCD 
{
	public static void main(String[] args) 
	{
		ArchivioCD2 archivio;
		DatiCD listaCD[];
		
		archivio = new ArchivioCD2(1);
		
		archivio.inserisci_CD("Outward Bound", "Eric Dolphy", (float)9.9, (short)5);
		archivio.inserisci_CD("Sunday at The Village Vanguard", "Bill Evans", (float)9.9, (short)4);
		archivio.inserisci_CD("Blues and the Abstract Truth", "Oliver Nelson", (float)12.9, (short)5);
		archivio.inserisci_CD("Verona", "Pearl Jam", (float)18.9, (short)4);
		archivio.inserisci_CD("Electric Ladyland", "Jimi Hendrix", (float)18.9, (short)5);
		archivio.inserisci_CD("Rimini", "Fabrizio De André", (float)5.0, (short)3);
		
		// Ordinamento per prezzo
		listaCD = archivio.ordinati_per_prezzo();
		System.out.println("CD ordinati per prezzo\n");
		for( DatiCD cd : listaCD ) 
			System.out.println(cd + "\n");
		
		// Ordinamento per giudizio
		listaCD = archivio.ordinati_per_giudizio();
		System.out.println("\n\nCD ordinati per giudizio\n");
		for( DatiCD cd : listaCD ) 
			System.out.println(cd + "\n");
		
		// Ricerca titolo
		DatiCD mio = archivio.trovaTitolo("Rimini");
		if (mio == null) System.out.println("Non trovato");
		else System.out.printf("CD TROVATO: \n" + mio.toString());	
	}
}
