import java.util.*;

public class Zoo 
{
	private ArrayList<Animale> gabbie;

	public Zoo() 
	{
		gabbie = new ArrayList<Animale>();
	}
	
	public void ospitaAnimale(Animale a) 
	{
		gabbie.add(a);
	}

	public void apriTetti() 
	{
		for (Animale anim : gabbie) 
		{	
			anim.verso();
			if (anim instanceof Volatile) 
			{	
				((Volatile)anim).vola();
				
				/* gabbie.remove(anim);
				 * 
				 * ^- Non si può fare, perché sotto il “foreach” abbiamo un Iterator 
				 *    che però è nascosto. Si ha un ArrayList cioè gabbie quindi per scorrerlo
				 *    e farci tutte le operazioni possibili si deve usare l'iteratore.
				 *    Quindi in realtà si dovrebbe fare come nel metodo sotto...
				*/
			}
		}
	}
	
	public void apriTetti_FUGA()
	{
		for (Iterator<Animale> i = gabbie.iterator(); i.hasNext();) 
		{
			Animale anim= i.next();
			anim.verso();
			if (anim instanceof Volatile)
			{
				((Volatile)anim).vola();
				i.remove();
			}
		}	
	}
	
	public void contenutoZoo() 
	{
		/* Stampa del contenuto senza utilizzare l'iteratore:
		 * 
		 * for (Animale anim : gabbie) 
		{	
			if (anim instanceof Cane) System.out.println("ANIMALE: Cane " + "  NOME: "+anim.getNome());
			if (anim instanceof Gatto) System.out.println("ANIMALE: Gatto " + "  NOME: "+anim.getNome());
			if (anim instanceof Anatra) System.out.println("ANIMALE: Anatra " + "  NOME: "+anim.getNome());
			if (anim instanceof Elefante) System.out.println("ANIMALE: Elefante " + "  NOME: "+anim.getNome());
			if (anim instanceof Gufo) System.out.println("ANIMALE: Gufo " + "  NOME: "+anim.getNome());
		}*/
		
		// L'iteratore può essere usato solo con gli ArrayList.
		// Stampa del contenuto utilizzando l'iteratore:
		for (Iterator<Animale> i = gabbie.iterator(); i.hasNext();) 
		{
			Animale anim = i.next();
			if (anim instanceof Cane) System.out.println("ANIMALE: Cane " + "  NOME: "+anim.getNome());
			if (anim instanceof Gatto) System.out.println("ANIMALE: Gatto " + "  NOME: "+anim.getNome());
			if (anim instanceof Anatra) System.out.println("ANIMALE: Anatra " + "  NOME: "+anim.getNome());
			if (anim instanceof Elefante) System.out.println("ANIMALE: Elefante " + "  NOME: "+anim.getNome());
			if (anim instanceof Gufo) System.out.println("ANIMALE: Gufo " + "  NOME: "+anim.getNome());
		}
	}
}
