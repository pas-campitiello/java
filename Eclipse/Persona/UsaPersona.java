public class UsaPersona 
{
	public static void main(String[] args) 
	{
		Persona[] people=new Persona[8];
		
		people[0]=new Dirigente("YERU88","Paolo","Verdi",1560);
		people[1]=new Segretaria("UIKJ77","Maria","Rossi",1250);
		people[2]=new Universitario("YIOU08","Paolo","Bianco","51295");
		people[3]=new Scolastico("ERTYI33","Matteo","Zara");
		people[4]=new Dirigente("XEXU58","Patrick","Metternich",1133);
		people[5]=new Segretaria("SIKB47","Marta","Gomesh",1000);
		people[6]=new Universitario("YPLO01","Franco","Brango","31335");
		people[7]=new Scolastico("SSSYI53","Daria","Masciata");
		
		
		for(int i=0; i<people.length; i++)
		{
			if (people[i] instanceof Dirigente)
			System.out.println("LAVORATORE (Dirigente): " + people[i].getNome() + " " + people[i].getCognome() 
					+ " " + people[i].getCodiceFiscale() +  " " +((Lavoratore)people[i]).calcolaStipendio());
					
			if (people[i] instanceof Segretaria)
				System.out.println("LAVORATORE (Segretaria): " + people[i].getNome() + " " + people[i].getCognome() 
						+ " " + people[i].getCodiceFiscale() +  " " +((Lavoratore)people[i]).calcolaStipendio());
			
			if (people[i] instanceof Universitario)
				System.out.println("STUDENTE (Universitario): " + people[i].getNome() + " " + people[i].getCognome()
						+ " " + people[i].getCodiceFiscale() +  " "	+ ((Studente)people[i]).getTasse());
			
			if (people[i] instanceof Scolastico)
				System.out.println("STUDENTE (Scolastico): " + people[i].getNome() + " " + people[i].getCognome() 
						+ " " + people[i].getCodiceFiscale() +  " " + ((Studente)people[i]).getTasse());			
		}
	}
}
