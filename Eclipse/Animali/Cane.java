public class Cane extends Animale 
{
	public Cane ()
	{
		System.out.println("anzi, per la precisione sono un CANE !");
	}
	
	public Cane (String nome)
	{
		this.nome = nome;
		System.out.println("anzi, per la precisione il CANE "+nome+" !");
	}
	
	void verso()
	{
		System.out.println(" Bau Wou Wouf Houf(abbaìo!?!)");
	}
}