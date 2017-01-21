package userBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserBeanDataAccess 
{	
	static String databaseUsername = "root";
	static String databasePassword = "123456";
	static String databaseName = "worksheet_db"; 

	private Connection connection;
	
	
	public UserBeanDataAccess() throws ClassNotFoundException, SQLException 
	{		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/"+databaseName;
		this.connection = DriverManager.getConnection(url, databaseUsername,databasePassword);
	}


	
	public String getRuolo(String username, String password) throws SQLException 
	{
		PreparedStatement stm = connection.prepareStatement("SELECT Ruolo FROM Utente WHERE username=? AND password=?");
		
		//SELECT Ruolo FROM Utente WHERE username='paolino' AND password='passaworda'

		stm.setString(1, username);
		stm.setString(2, password);
		ResultSet res = stm.executeQuery();
		
		res.next();
		return res.getString("ruolo");
	}
	
	

	
	public Boolean isAdmin(String username, String password) throws SQLException
	{
		PreparedStatement stm = connection.prepareStatement("SELECT isAdmin FROM utenti " +
															"WHERE username=? AND password=? AND isAdmin=1");

		stm.setString(1, username);
		stm.setString(2, password);
		ResultSet rs = stm.executeQuery();
		rs.last();
		
		if (rs.getRow() > 0) return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	
	// Controlla la se username e password sono esistenti
	public boolean validate(String username, String password) throws SQLException 
	{
		PreparedStatement stm = connection.prepareStatement("SELECT username FROM Utente WHERE username=? AND password=?");

		stm.setString(1, username);
		stm.setString(2, password);
		ResultSet res = stm.executeQuery();
		
		return res.next();
	}

	
	// Regista un nuovo utente nel database
	public void registraNuovoUtente(String matricola, String username, String password, String nome, String cognome, String mail, String ruolo) throws SQLException 
	{
		Statement stat = connection.createStatement();
		stat.executeUpdate("INSERT INTO Utente VALUES (null,'"+matricola+"','"+username+"','"+password+"','"+nome+"','"+cognome+"','"+mail+"','"+ruolo+"')");
	}
	
	
	public Connection getConnection() 
	{
		return connection;
	}
}
