package userBean;

/**
 * @author  Pasquale Campitiello
 */
public class UserBean 
{
	private String username;
	private String password;

	public UserBean(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
}