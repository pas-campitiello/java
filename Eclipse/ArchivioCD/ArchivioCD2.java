/* Con questa classe ArchivioCD2 si vuole modificare l’implementazione (NON L’INTERFACCIA!),
   modificando ArchivioCD utilizzando l'ArrayList che è un “generic container”.
   Questo solo per far vedere un altro tipo di implementazione: ArchivioCD e ArchivioCD2 sono
   intercambiabili.
 */

import java.util.*;

public class ArchivioCD2
{
	// Questa volta usiamo un ArrayList per memorizzare l'archivio di CD
	private ArrayList<DatiCD> archivio;

	// Non mi serve piu' un campo n_CD, perche' la funzione size() dell'ArrayList
	// da' esattamente il numero di oggetti presenti
	
	public ArchivioCD2(int dim) 
	{
		// La dimensione con cui si inizializza l'ArrayList e' solo indicativa,
		if (dim > 0) archivio = new ArrayList<DatiCD>(dim);
		else archivio = new ArrayList<DatiCD>();
	}
	
	public void inserisci_CD (String tit, String aut, float pr, short giud) 
	{
        // se non c'e' spazio, il resizing è automatico.
		archivio.add(new DatiCD(tit, aut, pr, giud));
	}
	
	public DatiCD[] ordinati_per_prezzo()
	{
		boolean ordinato = false;
		int i, n_CD=archivio.size();
        
		// Trasferisco la lista in un array temporaneo.
		DatiCD ris[] = archivio.toArray(new DatiCD[archivio.size()]);
		DatiCD temp;
		
		while(ordinato == false) 
		{
			ordinato = true;
			for( i=0 ; i<n_CD-1 ; i++ )
				if (ris[i].getPrezzo() > ris[i+1].getPrezzo()) 
				{
					temp = ris[i];
					ris[i] = ris[i+1];
					ris[i+1] = temp;
					ordinato = false;
				}
		}
		return ris;
	}
	
	public DatiCD[] ordinati_per_giudizio()
	{
		boolean ordinato = false;
		int i, n_CD=archivio.size();
        
		// Trasferisco la lista in un array temporaneo.
		DatiCD ris[] = archivio.toArray(new DatiCD[archivio.size()]);
		DatiCD temp;
		
		while(ordinato == false) 
		{
			ordinato = true;
			for( i=0 ; i<n_CD-1 ; i++ )
				if (ris[i].getGiudizio() > ris[i+1].getGiudizio()) 
				{
					temp = ris[i];
					ris[i] = ris[i+1];
					ris[i+1] = temp;
					ordinato = false;
				}
		}
		return ris;
	}
	
	public DatiCD trovaTitolo(String titolo)
	{
		for (DatiCD cd : archivio) 
		{ 
			if (cd.getTitolo().equals(titolo)) return cd;
		}
		return null;
	}
}
