public interface Volatile 
{
	/* Un solo metodo, che è astratto (essendo in una interfaccia, non occorre specificare 
	 * che sia astratto - è sottinteso). Tutte le classi che implementano questa interfaccia 
	 * DEVONO specificare il codice per questo metodo. 
	 * 
	 * Tutti i metodi definiti nelle interfacce sono “public” senza che sia specificato.
	 * 
	 * Una interfaccia è come una classe che può avere solo attributi costanti e i cui metodi 
	 * sono tutti pubblici ed astratti. Implicitamente, gli attributi dichiarati in una 
	 * interfaccia sono: 
	 *  – visibili alla classe che la implementa
	 *  – immodificabili (static final). */
	void vola();
}
