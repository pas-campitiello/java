// Programma esempio per uso eccezioni e inner class
// Stampando in output Data$DataIllegale significa che l'eccezione che si chiama 
// DataIllegale è partita dalla classe Data. 

public class ProvaEcc 
{
	public static void main(String[] args) 
	{		
		int giorno=12;
		int mese=13;
		int anno=2006;
		Data d;

		try 
		{	
		    d = new Data(giorno,mese,anno);
		}
		catch(Data.DataIllegale e) 
		{
			System.out.println("DATA SBAGLIATA!!!!");
			String s = e.toString();
			System.out.println(s); 
		}
	}
}