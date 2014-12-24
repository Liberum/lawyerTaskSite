package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.dto.User;
import connection.ServerConnection;
import connection.dto.Response;

@WebServlet("/registration.do")
public class Registration extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/html");
		Response response = new Response();
		ServerConnection sc = new ServerConnection();
		User user = new User();
		user.setLogin(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		response.setUser(user);
		response.setControllerType("registration");
		
		if ((response = sc.sendObject(response)) == null) {
			resp.sendRedirect("error.do");
			return;
		} 	
			if (response.getStatusLogin().equals("allowed")) {
			resp.sendRedirect("login.do");
		} else if(response.getStatusLogin().equals("denied")) {
			resp.sendRedirect("registration.do");
		}
		
	}
	
}
