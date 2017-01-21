// Main singolo per le varie sottoclassi

public class Main 
{
	public static void main(String[] args) 
	{ 
		SpremiAgrumi s = new SpremiAgrumiElettrico(); 
		//SpremiAgrumiElettrico se = new SpremiAgrumi(); 
		
		Agrume a = new Arancia();  
		
		//Arancia a2 = new Agrume(); 
		
		Limone l = new Limone(); 
		
		s.spremi(a); 
		s.spremi(l); 
		
		s = new SpremiAgrumi(); 
		s.spremi(new Agrume()); 
	}   
}