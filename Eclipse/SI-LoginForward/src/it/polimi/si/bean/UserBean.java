package it.polimi.si.bean;

public class UserBean {

	private String userId;

	private String password;

	public UserBean(String user, String password) {
		super();
		this.userId = user;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
