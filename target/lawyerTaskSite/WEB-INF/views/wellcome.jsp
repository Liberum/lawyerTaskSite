<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "check_user.jsp"%> 
<%@ include file = "header.jsp"%> 

<center>
WELLCOME PAGE

<div class="panel-body">

	<a href="task_list.do" class="btn btn-primary navbar-btn"
						role="button">Зодачи</a>
						
	<a href="new_or_update_task.do" class="btn btn-primary navbar-btn"
						role="button">Новая задача</a>
						
	<a href="new_or_update_task.do" class="btn btn-primary navbar-btn"
						role="button">Обновить задачу</a>					
						
</div>
</center>



<%@ include file = "footer.jsp"%>
