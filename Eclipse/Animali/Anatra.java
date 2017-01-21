public class Anatra extends Animale implements Volatile,Cibo
{
	public Anatra() 
	{
		System.out.println("anzi, per la precisione sono un'ANATRA!");
	}
	
	public Anatra (String nome) 
	{
		this.nome = nome;
		System.out.println("anzi, per la precisione l'ANATRA "+nome+"!");
	}
	
	void verso()
	{
		System.out.print(" Qua Qua (anatrìo?!?)");
	}

	/* Implementare l'interfaccia Volatile significa implementare i metodi in essa definiti. 
	 * Questo è OBBLIGATORIO (provando a commentarlo si ottiene errore a compile time). */
	public void vola() 
	{
		System.out.println(" ...sono un'Anatra e sto " + "VOLANDOOOOoooooo.....");
	}
	
	/* Implementare l'interfaccia Cibo significa implementare i metodi in essa definiti. 
	 * Questo è OBBLIGATORIO (provando a commentarlo si ottiene errore a compile time). */
	public void cuoci() 
	{
		System.out.println(" ...sono un'Anatra e sto " + "cuocendo.....");
	}
}
