package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.dto.User;
import connection.ServerConnection;
import connection.dto.Response;

/**
 * Servlet implementation class Direct
 */

@WebServlet("/login.do")
public class Direct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		ServerConnection sc = new ServerConnection();
		Response response = new Response();
		response.setControllerType("login");
		User user = new User();
		user.setLogin(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		response.setUser(user);
		
		
		if ((response = sc.sendObject(response)) == null) {
			resp.sendRedirect("error.do");
			return;
		} 
		
			System.out.println(response.getStatusLogin());
			if (response.getStatusLogin().equals("allowed")) {
			

			
//			//TODO Тестовая часть сессии 
			user = response.getUser();
			HttpSession session = req.getSession();
			session.setAttribute("email", user);
			session.setMaxInactiveInterval(3*60*60);
            Cookie userName = new Cookie("email", user.getLogin());
            userName.setMaxAge(20*365*24*60*60);
            resp.addCookie(userName);
			
			
			
			
			resp.sendRedirect("wellcome.do");
			
		} else if(response.getStatusLogin().equals("denied")) {
			resp.sendRedirect("error.do");
		}
		
	}
	

}
