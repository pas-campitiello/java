public class Gufo extends Animale implements Volatile 
{
	public Gufo () 
	{
		System.out.println("anzi, per la precisione sono un GUFO !");
	}
	
	public Gufo (String nome) 
	{
		this.nome = nome;
		System.out.println("anzi, per la precisione il GUFO "+nome+" !");
	}
	
	void verso()
	{
		System.out.print(" Huuuuuh Huuuuh (gufìo)");
	}

	/* Implementare l'interfaccia Volatile significa implementare i metodi in essa definiti. 
	 * Questo è OBBLIGATORIO (provando a commentarlo si ottiene errore a compile time). */
	public void vola() 
	{
		System.out.println(" ...sono un Gufo e sto " + "VOLANDOOOOoooooo.....");
	}
}