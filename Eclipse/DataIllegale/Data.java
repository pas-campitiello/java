// Programma esempio per uso eccezioni e inner class

public class Data 
{
	private int giorno, mese, anno;
	
	public boolean corretta(int g,int m,int a) 
	{
		// anche se non pienamente corretto
		if ((a>0) && (m>=1) && (m<=12) && (g>=1)&& g<=31) return true;
		return false;
	}
	
	public class DataIllegale extends Exception		// innes class 
	{
		private static final long serialVersionUID = 1L;

		public DataIllegale() 
		{	super();	}

		public DataIllegale(String arg0) 
		{	super(arg0);	}
		
		public DataIllegale(Throwable arg0) 
		{	super(arg0);	}
	}
	
	public Data(int giorno, int mese, int anno) throws DataIllegale
	{
		super();
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		
		if(!corretta(giorno,mese,anno)) throw new DataIllegale("Exception string! ");
		else System.out.println("Data corretta");
	}

	public int getAnno() 
	{	return anno;	}

	public void setAnno(int anno) 
	{	this.anno = anno;	}

	public int getGiorno() 
	{	return giorno;	}

	public void setGiorno(int giorno) 
	{	this.giorno = giorno;	}

	public int getMese() 
	{	return mese;	}

	public void setMese(int mese) 
	{	this.mese = mese;	}
}