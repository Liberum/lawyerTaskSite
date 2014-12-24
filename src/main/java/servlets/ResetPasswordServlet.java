package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.dto.User;
import connection.ServerConnection;
import connection.dto.Response;

@WebServlet("/reset_password.do")
public class ResetPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/reset_password.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServerConnection sc = new ServerConnection();
		Response response = new Response();
		User user = new User();
		response.setControllerType("reset");
		user.setLogin(req.getParameter("email"));
		response.setUser(user);
		if ((response = sc.sendObject(response)) == null) {
			resp.sendRedirect("error.do");
			return;
		} 
		PrintWriter pw = resp.getWriter();
		if (response.getStatusLogin().equals("allowed")) {
			pw.print("allowed");
		} else {
			pw.print("denied");
		}
		pw.flush();
		pw.close();
		
	}
}