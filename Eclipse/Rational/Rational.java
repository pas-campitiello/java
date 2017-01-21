/*@ pure @*/
public class Rational 
{
	//OVERVIEW: rappresenta un tipo immutabile per numeri razionali
	// Un razionale tipico è un qualunque rappresentante del razionale n/d
	// AF(c) = c.num/c.denom
	//@ private invariant denom != 0;
	// rep: una coppia di interi:
	
	private int num;
	private int denom;
	
	//Costruttori:
	
	//@ ensures (* inizializza this con coppia di interi *);
	//@ signals (ArithmeticException e) d == 0;
	public Rational(int n, int d) 
	{
		if (d==0) throw new ArithmeticException("Rational(int,int) constr.");
			num = n; denom = d;
	}
	
	// Costruttore di conversione da int a Rational
	public Rational(int i) 
	{	this(i,1); 	}
	
	// Costruttore di default: 0/1, non 0/0
	public Rational() 
	{	this(0,1); 	}
	
	// Metodi:
	
	public String toString()
	{
		return "Rational: " + num + "/" + denom + " ";
	}
	
	//@ ensures (* \result == this + r *);
	public Rational sum(Rational r) 
	{
		return new Rational(num*r.denom + r.num*denom, denom*r.denom);
	}
	
	//@ ensures (* \result == this * r *);
	public Rational mult(Rational r) 
	{
		return new Rational(num*r.num, denom* r.denom);
	}
	
	//@ ensures (* \result == this - r *);
	public Rational subtract(Rational r) 
	{
		return new Rational(num*r.denom - r.num*denom, denom*r.denom);
	}
	
	//@ ensures (* \result == this / r *);
	//@ signals (ArithmeticException e) r.num == 0;
	public Rational divide(Rational r) 
	{
		if (r.num == 0) throw new ArithmeticException("divide(Rational) meth.");
		else return new Rational(num*r.denom, denom*r.num);
	}
}