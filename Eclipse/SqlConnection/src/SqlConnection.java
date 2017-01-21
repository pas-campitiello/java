import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		String matricola 		= "700012";
		String username 		= "maria";
		String password 		= "12";
		String ripetiPassword	= "12";
		String nome 			= "Maria";
		String cognome	 		= "Chiave";
		String mail	 			= "maigfjsa@.d";
		String ruolo 			= "Ricercatore";
		
		try 
		{
			System.out.println("Carico il driver");
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Effettuo la connessione");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worksheet_db", "root", "123456");

			System.out.println("Creo uno statement");
			Statement stm = con.createStatement();

			System.out.println("Effettuo un inserimento");
			stm.executeUpdate("INSERT INTO Utente VALUES (null,'"+matricola+"','"+username+"','"+password+"','"+nome+"','"+cognome+"','"+mail+"','"+ruolo+"')");

			con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//getServletContext().getRequestDispatcher("/errore.htm").forward(request, response);
			//return;
		} 

	}

}
