<%@ page import="users.dto.User" %>
<% User loggedUser = (User) session.getAttribute("email"); 
%>
<%if (loggedUser != null ) {%>
	<div style="height:0px; width:auto; border-bottom:2px solid #cc0033;"></div>
	
<%} else{
	Cookie[] cookies = request.getCookies();
	if(cookies !=null){
		for(Cookie cookie : cookies){
		    if(cookie.getName().equals("email")) {
		    	String login = cookie.getValue();
		    	//TODO проверка на юзера кроме админа
		    	if (login.equals("admin@admin.net")) {
		    		User newUser = new User();
		    		newUser.setLogin(login);
		    		
		    		System.out.println(newUser);
		    		session = request.getSession();
					session.setAttribute("email", newUser);
					
					%>	
					<div style="height:0px; width:auto; border-bottom:2px solid #cc0033;"></div>	
					<%
					return;
		    	}
		    }
		}
	}
	
	 if (loggedUser == null){
		   response.sendRedirect("login.do");
		  return;
	   }
}
%>