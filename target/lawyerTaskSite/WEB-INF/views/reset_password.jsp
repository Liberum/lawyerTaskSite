<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header.jsp"%> 
 
<div class="panel panel-default center-block"
	style="width: 350px; margin-top: 50px; text-align: left;">
	<div class="panel-heading">
		<h3 class="panel-title">Reset password</h3>
	</div>

	<div class="panel-body">
		<form method="post" role="form" id="form">
			<div class="form-group">
				<label for="emailInput">Email address</label> <input type="email"
					class="form-control" id="emailInput" name="email"
					placeholder="Enter email" value="">
			</div>
		
			<button class="btn btn-primary pull-right" type="submit">Reset password</button>	
		
		</form>
		
		<br>

</div>
<div class="progress" style="display:none;" id="progress">
  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
    <span class="sr-only">Complete</span>
  </div>
</div>
<div class="alert alert-success" style="display:none; text-align:center;" role="alert" id="alert-success">Email was sent!</div>
<div class="alert alert-danger" style="display:none; text-align:center;" role="alert" id="alert-warning">Email was not sent!</div>
<p id="link" style="display:none; text-align:center;" ><a href="/" class="btn btn-primary">Return to main page</a></p>

	</div>
</div>
<script>
$(document).on("submit", "#form", function(event) {
	event.preventDefault();
	var email = $("#emailInput").val();
	$("#form").hide();
	$("#progress").show();
	$.post("/reset_password.do", {"email":email}, function(data) {
		$("#progress").hide();
		$('.alert').hide();	
		if(data==="allowed") {
			$('#alert-success').show();	
			$('#link').show();
		} else {
			$('#alert-warning').show();	
			$("#form").show();
		}		
	});
	return false;
});
</script>
<%@ include file = "footer.jsp"%>		