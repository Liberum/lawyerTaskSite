<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Calendar"%>
<div class="center-block" style="width: 350px; margin-top: 50px; text-align: center;" >
<%
	Calendar c = Calendar.getInstance();
%>
(C)<%=c.get(Calendar.YEAR)%> By cool group of three developers
</div>
</body>