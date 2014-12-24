package tasks.dto;

import java.io.Serializable;
import java.util.Map;

public class AllTasks implements Serializable{
	private Map <Integer, Task> allTasks;

	public Map<Integer, Task> getAllTasks() {
		return allTasks;
	}

	public void setAllTasks(Map<Integer, Task> allTasks) {
		this.allTasks = allTasks;
	}
}
