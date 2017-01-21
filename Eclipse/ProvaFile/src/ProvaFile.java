import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProvaFile 
{
	// Costanti
	// Percorsi per gli standard
	static final String[] iso3166 = {"standard\\iso3166.txt", "239"}; 
	static final String[] naics = {"standard\\naics-1997.txt", "24"};
	static final String[] unspsc = {"standard\\UNSPSC_v7_0401.txt", "9"};
	
	static final String[] datiFile = {"regData\\juddi_iso3166.txt", "239"};	
	
	/**
	 * @param args
	 */	
	public static void main(String[] args) 
	{
		/*		
		File MioFile1 = new File("InterazioneFileDatabase.java");

		if(MioFile1.exists()) 
		{
			String percorso = MioFile1.getAbsolutePath();
			
			System.out.println( percorso.replace("\\", "\\"+"\\") );
			System.out.println( percorso.replace("\\InterazioneFileDatabase.java", "") );
	    }  
		*/
		
		
		
		
		// Fase lettura e caricamento file in un array
		File f = new File(datiFile[0]);
		String linea = null;
		boolean aggiornato = false;
		
		// Array di array di String, per contenere i singoli array di String generati splittando ogni riga del file per ";" 
		String[][] lineaSplittata = new String[Integer.valueOf(datiFile[1]).intValue()][1];
		int i = 0;
		
		// Carico ogni singola linea del file, la splitto e la salvo nell'array di array di String; infine la stampo a video
		try
		{
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			linea = br.readLine();
			lineaSplittata[0] = linea.split(";");

			while(linea!=null) 
			{
				System.out.println(linea);
				
				i++;
				
				linea = br.readLine();
				if (linea!=null) lineaSplittata[i] = linea.split(";");
			}
		}
	    catch (IOException e)
	    {
	    	System.out.println(e.getMessage());
	    } 
	    
	    // Stampo a video l'array di array di String
	    stampaMatrice(lineaSplittata);
	    
	    
	    
	    
	    // Fase di scrittura, aggiornamento indici su condizione
	    i = 0;
	    linea = null;
	    
	    try
	    {
			// Sovrascrivo il file vecchio mettendoci tutto il contenuto nuovo.
			// Usare FileOutputStream(f,true) per scrivere in append.
			FileOutputStream fos = new FileOutputStream(f);
	    	PrintStream ps = new PrintStream(fos);
			
	    	for(i=0; i<Integer.valueOf(datiFile[1]).intValue(); i++)
		    {
		    	for(int j=0; j<lineaSplittata[i].length; j++)
		    	{
		    		if ( lineaSplittata[i][0].equals("ITALY") && aggiornato == false)
		    		{
		    			// Prendo il terzo e il quarto elemento, li trasformo in interi, gli sommo 1, 
		    			// li ritrasformo in String e li metto al posto vecchio posto,
		    			// praticamente li incremento di 1.
		    			lineaSplittata[i][2] = Integer.toString((Integer.valueOf(lineaSplittata[i][2]))+1);
		    			lineaSplittata[i][3] = Integer.toString((Integer.valueOf(lineaSplittata[i][3]))+1);
		    			aggiornato = true;
		    			
		    			// Scrivo l'array nel file
		    			ps.print(lineaSplittata[i][j]+";");
		    		}
		    		else ps.print(lineaSplittata[i][j]+";");
		    	}
		    	ps.println();
		    }	
	    }
	    catch (IOException e)
	    {
	    	System.out.println(e.getMessage());
	    } 
	    
	    // Stampo a video l'array di array di String
	    System.out.println();
	    stampaMatrice(lineaSplittata);
	    
	    
	    /*
		// Fase creazione di un nuovo registro con i 4 file che servono e i relativi dati
		String newRegName = "UDDIwebNice";
		String newRegInquiryURL = "localhost:8080iunqeury";
		String newRegPublishURL = "locahost:0800:publish";
		String newRegUsername = "nomeUTENTE";
		String newRegPassword = "p6RDApass";
		boolean esiste = false;
		String linea_iso3166 = null;
		String linea_naics = null;
		String linea_unspsc = null;
		
	    File cartella = new File("regData");
	    if (cartella.isDirectory()) 
	    {
	    	
	    	// Visualizzazione di tutti i file in una directory
	    	String files[] = cartella.list();
	        for(int i=0; i<files.length; i++)
	             System.out.println(files[i]);
	        
	        
	    	String files[] = cartella.list();
	    	// Controllo sul nome --> errore se esiste già --> non ammessi nomi uguali (jUDDI = juddi = jUdDi)
	    	for(int i=0; i<files.length; i=i+4)
	    	{
	    		System.out.println(i + ") " + files[i] + "  " + files[i].toUpperCase() + " " + newRegName.toUpperCase() + ".PROP");
	    		if ( files[i].toUpperCase().equals(newRegName.toUpperCase()+ ".PROP") ) esiste = true; 
	    	}
	    	
	    	if (esiste) System.out.println("ERRORE! Reg esistente");
	    	else
	    	{
	    		// Creazione file newRegName.prop con i 4 parametri
	    		// Creazione dei 3 file: newRegName_iso3166.txt, newRegName_naics-1997.txt, newRegName_UNSPSC_v7_0401.txt

	    		System.out.print("Creazione registry UDDI " + newRegName + "in corso...");
	    		
	    		File newRegProp = new File("regData\\" + newRegName + ".prop");
	    		
	    		File newRegIso3166 = new File("regData\\" + newRegName + "_iso3166.txt");
	    		File newRegNaics = new File("regData\\" + newRegName + "_naics-1997.txt");
	    		File newRegUnspsc = new File("regData\\" + newRegName + "_UNSPSC_v7_0401.txt");
	    		
	    		File iso3166_standard = new File(iso3166[0]);
	    		File naics_standard = new File(naics[0]);
	    		File unspsc_standard = new File(unspsc[0]);
	    		
	    		try
	    		{
	    			// Creazione newRegName.prop
					FileOutputStream newRegProp_os = new FileOutputStream(newRegProp,true);
			    	PrintStream newRegProp_ps = new PrintStream(newRegProp_os);
			    	
			    	newRegProp_ps.println("inquiryURL=" + newRegInquiryURL);
			    	newRegProp_ps.println("publishURL=" + newRegPublishURL);
			    	newRegProp_ps.println("userid="+newRegUsername);
			    	newRegProp_ps.println("password="+newRegPassword);
			    	
			    	// Creazione per copia dagli standard dei file/database
			    	// newRegName_iso3166.txt, newRegName_NAICS.txt, newRegName_UNSPSC_v7_0401.txt

			    	// Streaming OUT dei 3 file/database da creare
			    	FileOutputStream newRegIso3166_os = new FileOutputStream(newRegIso3166,true);
			    	PrintStream newRegIso3166_ps = new PrintStream(newRegIso3166_os);
			    	FileOutputStream newRegNaics_os = new FileOutputStream(newRegNaics,true);
			    	PrintStream newRegNaics_ps = new PrintStream(newRegNaics_os);
			    	FileOutputStream newRegUnspsc_os = new FileOutputStream(newRegUnspsc,true);
			    	PrintStream newRegUnspsc_ps = new PrintStream(newRegUnspsc_os);
			    	
			    	// Streaming IN dei 3 file/database standard
			    	FileInputStream iso3166_standard_is = new FileInputStream(iso3166_standard);
					InputStreamReader iso3166_standard_isr = new InputStreamReader(iso3166_standard_is);
					BufferedReader iso3166_standard_br = new BufferedReader(iso3166_standard_isr);
			    	
					FileInputStream naics_standard_is = new FileInputStream(naics_standard);
					InputStreamReader naics_standard_isr = new InputStreamReader(naics_standard_is);
					BufferedReader naics_standard_br = new BufferedReader(naics_standard_isr);
					
					FileInputStream unspsc_standard_is = new FileInputStream(unspsc_standard);
					InputStreamReader unspsc_standard_isr = new InputStreamReader(unspsc_standard_is);
					BufferedReader unspsc_standard_br = new BufferedReader(unspsc_standard_isr);
					
					// Leggo la prima linea dai file standard
					linea_iso3166 = iso3166_standard_br.readLine();
					linea_naics = naics_standard_br.readLine();
					linea_unspsc = unspsc_standard_br.readLine();

					while(linea_iso3166!=null || linea_naics!=null || linea_unspsc!=null) 
					{
						//System.out.println(linea_iso3166);
						//System.out.println(linea_naics);
						//System.out.println(linea_unspsc);
						
						// Copio dagli standard ai nuovi file
						if (linea_iso3166!=null && linea_iso3166!="") newRegIso3166_ps.println(linea_iso3166);
						if (linea_naics!=null && linea_naics!="") newRegNaics_ps.println(linea_naics);  
						if (linea_unspsc!=null && linea_unspsc!="") newRegUnspsc_ps.println(linea_unspsc);	
						//i++;
						
						// Leggo la linea successiva dai file standard
						linea_iso3166 = iso3166_standard_br.readLine();
						linea_naics = naics_standard_br.readLine();
						linea_unspsc = unspsc_standard_br.readLine();
					}
					
					// Chiudo gli stream OUT dei file creati.
					// per eventuali altri utilizzi nella stessa sessione (per esempio: deleteRegistry, ecc.)
					newRegProp_os.close();
					newRegIso3166_os.close();
					newRegNaics_os.close();
					newRegUnspsc_os.close();
	    		}
	    		catch (IOException e)
	    	    {
	    	    	System.out.println(e.getMessage());
	    	    } 
	    		System.out.println(" [OK]");
	    	}
	    	
	    }
	    else System.out.println("ERRORE. Directory inesistente!");
	    
	    
	    
	    
	    // Comando di listRegistry per visualizzare l'elenco con nomi degli attuali registry
	    System.out.println("");
	    if (cartella.isDirectory()) 
	    {
	    	// Visualizzazione di tutti i file in una directory
	    	String files[] = cartella.list();
	    	int j = 0;
	    	
	        for(int i=0; i<files.length; i++)
	        	if ( files[i].substring(files[i].length()-5, files[i].length()).equals(".prop") )
	        	{
	        		j++;
	        		System.out.println(j+") "+files[i]);
	        	}
	    }
	    else System.out.println("ERRORE. Directory inesistente!");
	    
	    
	    
	    
	    
	    
	   
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Comando di deleteRegistry per eliminare un registry
	    System.out.println("");
	    String regDaEliminare = "UDDIwebNice";
	    
	    System.out.print("Eliminazione registry UDDI " + regDaEliminare + "in corso...");
	    
	    if ( !(new File("regData\\" + regDaEliminare + ".prop")).delete() )
	    	System.out.println("ERRORE. Impossibile cancellare " + "regData\\" + regDaEliminare + ".prop");
	    if ( !(new File("regData\\" + regDaEliminare + "_iso3166.txt")).delete() ) 
	    	System.out.println("ERRORE. Impossibile cancellare " + "regData\\" + regDaEliminare + "_iso3166.txt");
		if ( !(new File("regData\\" + regDaEliminare + "_naics-1997.txt")).delete() )
			System.out.println("ERRORE. Impossibile cancellare " + "regData\\" + regDaEliminare + "_naics-1997.txt");	
		if ( !(new File("regData\\" + regDaEliminare + "_UNSPSC_v7_0401.txt")).delete() )
			System.out.println("ERRORE. Impossibile cancellare " + "regData\\" + regDaEliminare + "_UNSPSC_v7_0401.txt");

		System.out.println(" [OK]");
		
		*/
	}
	
	public static void stampaMatrice(String[][] mat)
	{
		int i = 0;
		
	    System.out.println();
	    //for(i=0; i<Integer.valueOf(datiFile[1]).intValue(); i++)
	    for(i=0; i<mat.length; i++)
	    {
	    	for(int j=0; j<mat[i].length; j++)
	    	{
	    		System.out.print(mat[i][j] + " | ");
	    	}
	    	System.out.println();
	    }
	}
}
