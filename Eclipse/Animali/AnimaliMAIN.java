public class AnimaliMAIN 
{	
	public static void main(String[] args) 
	{
		// Definizione dell'insieme di animali
		Animale[] bestie=new Animale[5];
		
		System.out.println("Gli oggetti Cane, Gatto, ecc., chiamano la superclasse Animale" +
							" e poi eseguono il proprio costruttore." +
							"\nLe stringhe seguenti lo dimostrano:");
		bestie[0]=new Cane("Fido");
		bestie[1]=new Gatto("Fuffi");
		bestie[2]=new Elefante();
		bestie[3]=new Gufo("Alone");
		bestie[4]=new Anatra("Verrecchia");
		
		// Creazione degli zoo
		Zoo ZooPrimo=new Zoo();
		Zoo ZooSecon=new Zoo();
		
		ZooPrimo.ospitaAnimale(bestie[0]);
		ZooPrimo.ospitaAnimale(bestie[1]);
		ZooPrimo.ospitaAnimale(bestie[4]);
		ZooSecon.ospitaAnimale(bestie[2]);
		ZooSecon.ospitaAnimale(bestie[3]);
		
		System.out.println("\n-------------------------------------------------------------------");
		
		// Visualizza contenuto degli zoo
		System.out.println("\nPuntatore allo Zoo 1: " + ZooPrimo);
		ZooPrimo.contenutoZoo();
		System.out.println("\nPuntatore allo Zoo 2: " + ZooSecon);
		ZooSecon.contenutoZoo();
		
		// Prova di chiamata a apriTetto() per i due zoo e visualizzazione del contenuto:
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\nSono stati aperti i tetti dello Zoo 1:");
		ZooPrimo.apriTetti();
		System.out.println("\nSono stati aperti i tetti dello Zoo 2:");
		ZooSecon.apriTetti();
		System.out.println("\nContenuto degli zoo dopo apriTetti():");
		System.out.println("\nPuntatore allo Zoo 1: " + ZooPrimo);
		ZooPrimo.contenutoZoo();
		System.out.println("\nPuntatore allo Zoo 2: " + ZooSecon);
		ZooSecon.contenutoZoo();
		
		// Prova di chiamata a apriTetto_FUGA() per i due zoo e visualizzazione del contenuto:
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\nSono stati aperti i tetti dello Zoo 1 (i volatili sono scappati):");
		ZooPrimo.apriTetti_FUGA();
		System.out.println("\nSono stati aperti i tetti dello Zoo 2 (i volatili sono scappati):");
		ZooSecon.apriTetti_FUGA();
		System.out.println("\nContenuto degli zoo dopo apriTetti_FUGA():");
		System.out.println("\nPuntatore allo Zoo 1: " + ZooPrimo);
		ZooPrimo.contenutoZoo();
		System.out.println("\nPuntatore allo Zoo 2: " + ZooSecon);
		ZooSecon.contenutoZoo();
	}	
}