package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/authorization.do")
public class Authorization extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO test getCookie
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		
		if(cookies !=null){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals("email")) userName = cookie.getValue();
			    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
			}
		
			System.out.println("email = " + userName + "; session ID = " + sessionID);
		
		// finish test cookie
		request.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(request, response);
		
	}

}
