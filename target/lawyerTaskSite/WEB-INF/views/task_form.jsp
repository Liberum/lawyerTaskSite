<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="form-container" style="display:none" class="col-md-8">
<form method="post" id="task-form">
	<div class="form-group">
		<label for="claimAbout">claimAbout</label> <input type="text"
			class="form-control" id="claimAbout" name="task"
			placeholder="claimAbout">
	</div>
	<div class="form-group">
		<label for="caseTask">caseTask</label> <input type="text"
			class="form-control" id="caseTask" name="task"
			placeholder="caseTask">
	</div>	
	<div class="form-group">
		<label for="judge">judge</label> <input type="text"
			class="form-control" id="judge" name="task"
			placeholder="judge">
	</div>	
	<div class="form-group">
		<label for="defendant">defendant</label> <input type="text"
			class="form-control" id="defendant" name="task"
			placeholder="defendant">
	</div>	
	<div class="form-group">
		<label for="claimant">claimant</label> <input type="text"
			class="form-control" id="claimant" name="task"
			placeholder="claimant">
	</div>	
	<div class="form-group">
		<label for="groupClaim">groupClaim</label> <input type="text"
			class="form-control" id="groupClaim" name="task"
			placeholder="groupClaim">
	</div>	
	<div class="form-group">
		<label for="getCurrentReminder">getCurrentReminder</label> <input type="text"
			class="form-control" id="getCurrentReminder" name="task"
			placeholder="getCurrentReminder">
	</div>	
	
	<input type="hidden" name="task" id="taskId"/>
	<input type="submit" value="Save"/>	
</form>
</div>
<div class="clearfix"></div>