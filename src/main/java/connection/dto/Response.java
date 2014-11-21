package connection.dto;

import java.io.Serializable;

import users.dto.User;

public class Response implements Serializable{

	private String statusLogin;
	User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}
	
}