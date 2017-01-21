public class Elefante extends Animale 
{
	public Elefante () 
	{
		System.out.println("anzi, per la precisione sono un ELEFANTE!");
	}
	
	public Elefante (String nome)
	{
		this.nome = nome;
		System.out.println("anzi, per la precisione l'ELEFANTE "+nome+"!");
	}
	
	void verso()
	{
		System.out.println(" HRIIIIIIIIIIII (barrito) ");
	}
}