public class UsaForme 
{
	public static void main(String[] args) 
	{
		Forma f;
		f = new Rettangolo(10,5);
		
		Forma c = new Cerchio(7);
		
		System.out.println("Area cerchio = "+((Cerchio)c).getArea()+
					 	   "\nArea rettangolo = "+ ((Rettangolo)f).getArea());
		
		Forma q = new Quadrato(8);
		
		String latoQuadrato = q.disegna();
		System.out.println("Lato quadrato = "+latoQuadrato);
	}

}