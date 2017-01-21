package it.polimi.si.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
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

	public Collection findAll() throws SQLException 
	{
		Collection result = new LinkedList();

		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery("SELECT username, password FROM utenti");

		while (rs.next()) 
		{
			UserBean userBean = new UserBean(rs.getString("username"), rs.getString("password"));
			result.add(userBean);
		}

		return result;
	}

	public Collection findByUsername(String username) throws SQLException {

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

	
	public static void main(String args[]) throws Exception 
	{
		UserBeanDataAccess dataAccess = new UserBeanDataAccess();

		Collection users;
		try 
		{
			users = dataAccess.findAll();

			if (!users.isEmpty()) 
			{
				Iterator i = users.iterator();

				while (i.hasNext()) 
				{
					UserBean user = (UserBean) i.next();
					System.out.println(user.getUsername());
				}
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
