import java.util.*;

public class RationalMAIN 
{
	public static void main(String[] args) throws java.io.IOException 
	{
		Scanner in = new Scanner(System.in);
	
		System.out.println("Inserisci due numeri su due righe diverse: ");
			
		int a = in.nextInt();
		int b = in.nextInt();
		
		Rational r1 = new Rational(a,b);	// il razionale inserito
		Rational r2 = new Rational();		// il razionale nullo
		Rational r3 = new Rational(a);		// il razionale a/1
		
		// Conversione automatica con toString(), ma solo se altri sono stringhe
		// se si scrive in println(r1 + r2 + r3.toString()) dà errore perchè di due 
		// elementi consecutivi uno deve essere per forza una stringa, quindi si usa la 
		// toString()
		System.out.println(r1 + r2.toString() + r3 );
		System.out.println(r2 + r3.toString());
		System.out.println(r1.mult(r2) + "" + r1.sum(r3));
	}
}
