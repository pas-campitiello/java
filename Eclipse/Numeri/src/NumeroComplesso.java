public class NumeroComplesso 
{      
    protected float reale; 
    protected float immaginario; 
    
    public NumeroComplesso(float reale, float immaginario) 
    { 
        this.reale = reale; 
        this.immaginario = immaginario; 
    } 
    
    void somma(NumeroComplesso nc) 
    { 
        reale += nc.reale; 
        immaginario += nc.immaginario; 
    } 
    
    void print() 
    { 
    	System.out.println(reale + "+" + immaginario + "*i"); 
    } 
} 