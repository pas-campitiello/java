public class NumeriMain 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		NumeroComplesso nc; 
		Numero n; 
		
		/*nc = new NumeroComplesso(3,4); 
		nc.somma(new Numero (5)); 				// 4a
		nc.somma(new NumeroComplesso(5,10)); 	// 4b
		nc.print(); 
		*/
		nc = new Numero(4); 					// 6
		nc.somma(new NumeroComplesso(3,1)); 	// 7a
		//nc.somma(new Numero(3)); 				// 7b
		//nc.print(); 
		
		n = new Numero(5); 						// 9a
		//n = new NumeroComplesso(5,0); 			// 9b
		n.somma(nc); 
		n.print();   
	}
}
