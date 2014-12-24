<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header.jsp"%> 
 
<div class="panel panel-default center-block"
	style="width: 350px; margin-top: 50px; text-align: left;">
	<div class="panel-heading">
		<h3 class="panel-title">Login</h3>
	</div>

	
	<div class="panel-body">
		<form method="post" role="form">
			<div class="form-group">
				<label for="emailInput">Email address</label> <input type="email"
					class="form-control" id="emailInput" name="email"
					placeholder="Enter email" value="admin@admin.net">
			</div>
			<div class="form-group">
				<label for="passwordInput">Password</label> <input type="password"
					class="form-control" id="passwordInput" name="password"
					placeholder="Enter password" value="admin">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>	
					
			<a href="registration.do" class="btn btn-default" role="button">Register</a>
			<a href="reset_password.do" class="btn btn-default" role="button">Reset
				Password</a>
		</form>
		
		<% //TODO сделать нормальный прогресс бар%>
		<br>
<div class="progress">
  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
    <span class="sr-only">Complete</span>
  </div>
</div>

	</div>
</div>
			<%@ include file = "footer.jsp"%>		