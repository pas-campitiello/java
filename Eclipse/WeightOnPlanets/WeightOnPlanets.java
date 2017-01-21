public class WeightOnPlanets 
{
	public static void main(String[] args) 
	{
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight/Planet.EARTH.surfaceGravity();
		
		for (Planet p : Planet.values())
			System.out.printf("\nYour weight on %s is %f%n",p, p.surfaceWeight(mass));
		
		// "%n" funziona con il "\n" del C
			
		//System.out.printf("\nSurface gravity on Earth is %f",Planet.EARTH.surfaceGravity());
		//System.out.printf("\nMass on Earth is %f\n",mass);
	}
}
