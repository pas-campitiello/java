import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.*;
import java.util.Iterator;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;


public class ParserICS
{
	static Calendar ical = null;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{	
		int k = 0;
		String dataInizioEvento, dataFineEvento, tipoEvento;
		FileOutputStream scriptEventi;
		PrintStream outScriptEventi = null;

		
		// Crea il file per lo script di aggiornamento
		try 
		{
			scriptEventi = new FileOutputStream("mysql//scriptEventi.sql");
			outScriptEventi = new PrintStream(scriptEventi);
			
			outScriptEventi.println("use worksheet_db;");
		}
		catch (IOException e) 
		{
			System.out.println("Errore: " + e);
			System.exit(1);
		}
		
		
		
		// Estrae dalla cartella "ics" i file calendario .ICS da parsare
		File dirIcs = new File ("ics");
		String[] fileIcs = dirIcs.list();


		// Cicla sui file .ICS
		for (k = 0; k < fileIcs.length; k++)
		{    		
			// Leggi il file ics e importa 
			try 
			{
				FileInputStream fin = new FileInputStream("ics//" + fileIcs[k]);
	
				CalendarBuilder builder = new CalendarBuilder();
	
				ical = builder.build(fin);
			}
			catch (Exception e) 
			{}
			
			// Itera sul contenuto del file calendario .ICS
			for (Iterator i = ical.getComponents().iterator(); i.hasNext();) 
			{
				Component component = (Component) i.next();
	
			    for (Iterator j = component.getProperties().iterator(); j.hasNext();) 
			    {
			       	Property property = (Property) j.next();
			        		       	
			        // Se la property è CATEGORIES (mi serve perchè subito dopo ci sono le date inizio e fine)
			       	// e se il valore della property è vacanza, esami o sospensione
			        if( (property.getName().equals("CATEGORIES")) &&
			        	(	(property.getValue().equals("Vacanza")) || 
			        		(property.getValue().equals("Esami")) || 
			        		(property.getValue().equals("Sospensione lezioni")) 
			        	))
			        {
			        	tipoEvento = property.getValue();
				       	//System.out.println("tipo_evento: " + tipoEvento);
	
				        // Le date sono una di seguito all'altra
				       	dataInizioEvento = ((Property)j.next()).getValue();
				       	dataFineEvento = ((Property)j.next()).getValue();
				       	
				       	// Converte le strighe in formato Date SQL e le stampa a video
			        	//System.out.println("data_inizio_evento: " + StringToDateSQLConverter( dataInizioEvento ) );
			        	//System.out.println("data_fine_evento: " + StringToDateSQLConverter( dataFineEvento ) );
			        	
			        	// Aggiorna il file script per il successivo aggiornamento del database
			        	outScriptEventi.println("INSERT INTO Evento");
			        	outScriptEventi.println("VALUES('','"+StringToDateSQLConverter( dataInizioEvento )+"',"
			        									+"'"+StringToDateSQLConverter( dataFineEvento )+"','"+tipoEvento+"');");
			        }	
			     }
			}
			
		    System.out.println ("Parsing calendario eventi: " + fileIcs[k] + "	[COMPLETATO]");
		}
		

		
		// Aggiorna il database inserendo le date di eventi estratte
		System.out.println("\nAggiornamento database -----");
		executeScript ("worksheet_db", "mysql/scriptEventi.sql", true); 
	}
	
	
	
	// Prende in ingresso una stringa da convertire (sarebbe una data formattata secondo il pattern yyyyMMdd, cioè quello usato nell'ICS)
	// e la converte in una data per SQL (nel formato standard SQL yyyy-MM-dd).
	public static java.sql.Date StringToDateSQLConverter(String stringToConvert)
	{		
		java.sql.Date dateSQL = null;
		String pattern = "yyyyMMdd";
	  
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try 
		{
			dateSQL = new java.sql.Date(sdf.parse(stringToConvert).getTime());
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return dateSQL;
	}

	
	
	// Esegue uno script su un database
	public static void executeScript (String dbname, String scriptpath, boolean verbose) 
	{
		String username = null, password = null;
		
		try 
		{
			// Lettura da tastiera "mySql" di username e password per accesso a MySql
			InputStreamReader tastiera = new InputStreamReader(System.in);
			
			System.out.print(" inserire username MySQL: ");
			BufferedReader myInput = new BufferedReader (tastiera);
			username = new String (myInput.readLine());
			
			System.out.print(" inserire password MySQL: ");
			myInput = new BufferedReader (tastiera);
			password = new String (myInput.readLine());
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		// Creo stringa per il comando da lanciare e lancio comando
		try 
		{
			String[] cmd = new String[]{"mysql",dbname, "--user=" + username, "--password=" + password, "-e", "source " + scriptpath};
			
			//System.out.println(cmd[0] + " " + cmd[1] + " " + cmd[2] + " " + cmd[3] + " " + cmd[4] + " " + cmd[5]);
			
			Process proc = Runtime.getRuntime().exec(cmd);
			
			if (verbose) 
			{
				InputStream inputstream = proc.getInputStream();
				InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
				BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
	
				// read the output
				String line;
				while ((line = bufferedreader.readLine()) != null) 
				{
					System.out.println(line);
				}
	
				// check for failure
				try 
				{
					if (proc.waitFor() != 0) 
					{
						System.err.println("ERROR -> exit value = " + proc.exitValue());
						System.err.println("Ricontrollare i valori inseriti.");
						return;
					}
				}
				catch (InterruptedException e) 
				{
					System.err.println("ERROR -> "+ e);
					return;
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return;
		}
		
		System.out.println("[OK]");
	}
}