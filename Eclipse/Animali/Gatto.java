public class Gatto extends Animale 
{ 
	public Gatto () 
	{
		System.out.println("anzi, per la precisione sono un GATTO !");
	}
	
	public Gatto (String nome)
	{
		this.nome = nome;
		System.out.println("anzi, per la precisione il GATTO "+nome+" !");
	}

	void verso()
	{
		System.out.println(" Miaaaaaaaooooo(miagolio)");
	}
}
