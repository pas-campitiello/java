package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class UserBeanDataAccess 
{
	Connection connection;

	public UserBeanDataAccess() throws ClassNotFoundException, SQLException 
	{

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/ProxyUnivRegDB";
		connection = DriverManager.getConnection(url, "root", "123456");
	}

	public void insertUser(UserBean user) 
	{
	}

	public Collection findByUsername(String username) throws SQLException 
	{
		Collection result = new LinkedList();

		PreparedStatement stm = connection.prepareStatement("SELECT username FROM utenti WHERE username=?");

		stm.setString(1, username);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) 
		{
			UserBean userBean = new UserBean(rs.getString("username"), rs.getString("password"));
			result.add(userBean);
		}
		
		return result;
	}

	public boolean validate(String username, String password) throws SQLException 
	{
		PreparedStatement stm = connection.prepareStatement("SELECT username FROM utenti WHERE username=? AND password=?");

		stm.setString(1, username);
		stm.setString(2, password);
		ResultSet res = stm.executeQuery();
		
		return res.next();
	}
}
