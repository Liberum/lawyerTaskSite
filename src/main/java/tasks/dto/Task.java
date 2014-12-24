package tasks.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task implements Serializable{
	private int taskId;
	private int userId;
	private String claimAbout;
	private String caseTask;
	private String judge;
	private String defendant;
	private String claimant;
	private String groupClaim;
	private long creatingData;
	private long nextReminder;
	private long currentReminder;
	private long deadLine;

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getClaimAbout() {
		return claimAbout;
	}
	public void setClaimAbout(String claimAbout) {
		this.claimAbout = claimAbout;
	}
	public String getCaseTask() {
		return caseTask;
	}
	public void setCaseTask(String caseTask) {
		this.caseTask = caseTask;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public String getDefendant() {
		return defendant;
	}
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}
	public String getClaimant() {
		return claimant;
	}
	public void setClaimant(String claimant) {
		this.claimant = claimant;
	}
	public String getGroupClaim() {
		return groupClaim;
	}
	public void setGroupClaim(String groupClaim) {
		this.groupClaim = groupClaim;
	}
	public long getCreatingData() {
		return creatingData;
	}
	public void setCreatingData(long creatingData) {
		this.creatingData = creatingData;
	}
	public long getNextReminder() {
		return nextReminder;
	}
	public void setNextReminder(long nextReminder) {
		this.nextReminder = nextReminder;
	}
	public long getCurrentReminder() {
		return currentReminder;
	}
	public void setCurrentReminder(long currentReminder) {
		this.currentReminder = currentReminder;
	}
	public long getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
	}
	
	
	public String toString(){ 
		SimpleDateFormat dateToMyFormat = new SimpleDateFormat("dd.MM.YYYY", new Locale("ru"));
		String str = "ID: " + taskId + "; UserId:" + userId + "; claimAbout:" + claimAbout + "; caseTask:" + caseTask + 
				"; judge:" + judge + "; defendant:" + defendant + "; claimant:" + claimant +
				"; groupClaim:" + groupClaim + ";\ncreatingData: " + dateToMyFormat.format(new Date(creatingData)) + 
				"; nextReminder:" + dateToMyFormat.format(new Date(nextReminder)) + 
				"; currentReminder:" + dateToMyFormat.format(new Date(currentReminder)) + 
				"; deadLine:" + dateToMyFormat.format(new Date(deadLine)) + "\n";
		return str;
	}

}
