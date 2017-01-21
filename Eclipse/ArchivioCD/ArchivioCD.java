public class ArchivioCD 
{
	private DatiCD archivio[];
	private int n_CD;
	
	public ArchivioCD (int dim) 
	{
		if (dim > 0) archivio = new DatiCD[dim];
		else archivio = new DatiCD[1];
		n_CD = 0; //eliminabile
	}
	
	public void inserisci_CD (String tit, String aut, float pr, short giud)
	{
		if (n_CD == archivio.length) 
		{
			// se l'archivio e' pieno lo rialloco raddoppiandone la dimensione
			System.out.println("Resizing dell'archivio da " + n_CD + " a " + n_CD*2);
			DatiCD new_arch[] = new DatiCD[archivio.length*2];
			
			/*// Loop di copia dell'array
			for(int i=0 ; i<archivio.length ; i++)
			{
				new_arch[i] = archivio[i];
			}*/
			
			// Questa API sostituisce l'intero FOR sopra
			System.arraycopy(archivio, 0, new_arch, n_CD,archivio.length);
			
			archivio = new_arch;
		}
		
		archivio[n_CD] = new DatiCD(tit, aut, pr, giud);
		
		n_CD++;
	}
	
	public DatiCD[] ordinati_per_giudizio() 
	{
		boolean ordinato = false;
		int i;
        
		// nota che non ordino l'archivio, ma un array temporaneo!
		DatiCD ris[] = new DatiCD[n_CD];
		for ( i=0 ; i<n_CD ; i++ ) ris[i] = archivio[i];
		
		DatiCD temp;
        
		// L'ordinamento e' un normale bubblesort, qui pero' aggiungo anche un secondo  
		// ordinamento, per prezzo (crescente), se il giudizio e' uguale
		
		while(ordinato == false) 
		{
			ordinato = true;
			for( i=0 ; i<n_CD-1 ; i++ )
				if ((ris[i].getGiudizio() < ris[i+1].getGiudizio()) || 
					(ris[i].getGiudizio() == ris[i+1].getGiudizio() && ris[i].getPrezzo() > ris[i+1].getPrezzo()))
				{
					temp = ris[i];
					ris[i] = ris[i+1];
					ris[i+1] = temp;
					ordinato = false;
				}
		}
		return ris;
	}
}
