public class Application 
{	
	private int base;
	private String[] operations;
	private MainFrame gui;
	
	public Application() 
	{
		operations = new String[] { "Sum", "Diff", "Mult", "Pow", "Log" };
		gui = new MainFrame(this);   //Riferimento di loopback
		gui.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
	
	public void setBase(int base) 
	{
		this.base = base;
		gui.showBase(base);   // Aggiungo l'interfaccia grafica col nuovo valore
	}
	
	public int getBase() 
	{
		return base;
	}

	public int sum(int x) 
	{
		return x + base;
	}
	
	public String[] getOperations() 
	{
		return operations;
	}
	
	// Effettua 5 operazioni con i numeri da min a max,	combinandoli con la base
	public Double[][] performOperations(int min, int max) 
	{
		Double[][] results = new Double[max - min +1][operations.length];
		for (int i = min; i <= max; i++) 
		{
			results[i - min][0] = (double)i + base;
			results[i - min][1] = (double)i - base;
			results[i - min][2] = (double)i * base;
			results[i - min][3] = Math.pow(i, base);
			results[i - min][4] = Math.log(i)/Math.log(base);
		}
		
		return results;
	}
}
