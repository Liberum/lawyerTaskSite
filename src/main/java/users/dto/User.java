package users.dto;
import java.io.Serializable;

public class User implements Serializable{
	
	private String login;
	private String password;
	private String name;
	private int id =-1;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){ 
		String str = "ID: " + id + "; Name:" + name + "; Login:" + login + "; Password:" + password + "\n";
		return str;
	}
}