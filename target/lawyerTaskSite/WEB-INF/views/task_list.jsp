<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "check_user.jsp"%> 
<%@ include file = "header.jsp"%> 
<%@page import="tasks.dto.AllTasks"%>
<%@page import="java.util.Map"%>
<%@page import="tasks.dto.Task"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>

<table class="table table-striped">
<thead>
	<tr>
		<td>taskId</td>
		<td>userId</td>
		<td>claimAbout</td>
		<td>caseTask</td>
		<td>judge</td>
		<td>defendant</td>
		<td>claimant</td>
		<td>groupClaim</td>
		<td>creatingData</td>
		<td>nextReminder</td>
		<td>currentReminder</td>
		<td>deadLine</td>
		<td></td>
	</tr>  
</thead>
<tbody>
<%
AllTasks allTasks = (AllTasks)request.getAttribute("map");
Map<Integer, Task> mapOfTasks = allTasks.getAllTasks();
SimpleDateFormat dateToMyFormat = new SimpleDateFormat("dd.MM.YYYY / HH:mm", new Locale("ru"));
for(int i = 1; i <= mapOfTasks.size(); i++) {  
	Task task = mapOfTasks.get(i); %>
	<tr id="task-<%=task.getTaskId()%>">
		<td> <%= task.getTaskId() %></td>
		<td> <%= task.getUserId() %></td>
		<td> <%= task.getClaimAbout() %></td>
		<td> <%= task.getCaseTask() %></td>
		<td> <%= task.getJudge() %></td>
		<td> <%= task.getDefendant() %></td>
		<td> <%= task.getClaimant() %></td>
		<td> <%= task.getGroupClaim() %></td>
		<td> <%= dateToMyFormat.format(new Date(task.getCreatingData())) %></td>
		<td> <%= dateToMyFormat.format(new Date(task.getNextReminder())) %></td>
		<td> <%= dateToMyFormat.format(new Date(task.getCurrentReminder())) %></td>
		<td> <%= dateToMyFormat.format(new Date(task.getDeadLine())) %></td>
		<td> <button type="button" class="btn btn-primary" onclick="editTask(<%=task.getTaskId() %>);">edit</button> </td>
	</tr>  
<%  };  %>
</tbody>
</table>
<script>
function editTask(taskId) {
	data = [];
	$("#task-"+taskId+" >td").each(function(td) {
		data.push($(this).text());
	});
	
	$("#taskId").val(data[0].trim());	
	$("#claimAbout").val(data[2]);
	$("#caseTask").val(data[3]);
	$("#judge").val(data[4]);
	$("#defendant").val(data[5]);
	$("#claimant").val(data[6]);
	$("#groupClaim").val(data[7]);
	//$("#nextReminder").val(data[9]);
	$('#getCurrentReminder').datetimepicker({
		value: data[9].trim(),
		format:'d.m.Y / H:i',
    });
	$("#form-container").show();	
}

function addTask() {
	$('#task-form')[0].reset(); 
	$('#getCurrentReminder').datetimepicker({
		format:'d.m.Y / H:i',

	});
	$('#form-container').show();
}
</script>
<button type="button" class="btn btn-primary" onclick="addTask()">Add Task</button>


<%@ include file = "task_form.jsp"%>

<%@ include file = "footer.jsp"%>

<script type="text/javascript" src="js/jquery.datetimepicker.js"></script>