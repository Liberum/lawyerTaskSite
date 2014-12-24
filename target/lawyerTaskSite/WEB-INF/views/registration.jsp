<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header.jsp"%> 
 
<div class="panel panel-default center-block "
	style="width: 350px; margin-top: 50px; text-align: left;">
	<div class="panel-heading">
		<h3 class="panel-title">Registration</h3>
	</div>

	<div class="panel-body">
		<form method="post" role="form">
			<div class="form-group">
				<label for="emailInput">Email address</label> <input type="email"
					class="form-control" id="emailInput" name="email"
					placeholder="Enter email" value="" maxlength="40">
			</div>
			<div class="form-group">
				<label for="passwordInput">Password</label> <input type="password"
					class="form-control" id="passwordInput" name="password"
					placeholder="Enter password" value="" maxlength="40">
			</div>
			<div class="form-group">
				<label for="passwordInput">Name</label> <input type="text"
					class="form-control" id="nameInput" name="name"
					placeholder="Enter name" value="" maxlength="40">
			</div>
			<div class="pull-right">
				<button type="reset" class="btn btn-primary">Reset</button>	
				<button type="submit" class="btn btn-primary">Register</button>	
			</div>
		</form>
		
		<% //TODO сделать нормальный прогресс бар%>
		
		<div class="clearfix"></div>
		<br>
<div class="progress">
  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
    <span class="sr-only">Complete</span>
  </div>
</div>

	</div>
</div>
			<%@ include file = "footer.jsp"%>	