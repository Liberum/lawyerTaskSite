package connection.dto;

import java.io.Serializable;

import tasks.dto.AllTasks;
import tasks.dto.Task;
import users.dto.User;

public class Response implements Serializable{

	private String statusLogin;
	private String controllerType;
	User user;
	AllTasks tasks;
	Task task;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public AllTasks getTasks() {
		return tasks;
	}

	public void setTasks(AllTasks tasks) {
		this.tasks = tasks;
	}
	
	public String getControllerType() {
		return controllerType;
	}
	
	public void setControllerType(String controllerType) {
		this.controllerType = controllerType;
	}
	
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