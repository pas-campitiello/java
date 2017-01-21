public class Numero extends NumeroComplesso 
{     
    public Numero(float reale) 
    { 
        super(reale,0); 
    } 
    
    public void somma(NumeroComplesso nc) 
    { 
        reale += nc.reale +1; 
    } 
    
    public void print() 
    { 
    	System.out.println(reale);
    } 
} 
 