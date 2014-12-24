package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tasks.dto.Task;
import users.dto.User;
import connection.ServerConnection;
import connection.dto.Response;

@WebServlet("/task_list.do")

public class TaskList extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("email");
		if (user == null) {
			resp.sendRedirect("/login.do");
			return;
		}
		Response response = new Response();
		response.setUser(user);
		response.setControllerType("task_list");
		ServerConnection sc = new ServerConnection();
		
		if ((response = sc.sendObject(response)) == null) {
			resp.sendRedirect("error.do");
			return;
		} 
		req.setAttribute("map", response.getTasks());
		
		req.getRequestDispatcher("WEB-INF/views/task_list.jsp").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// контроллер тип
		ServerConnection sc = new ServerConnection();
		
		
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("email");
		
		String task[] = req.getParameterValues("task");
		Task newTask = new Task();
		
		newTask.setClaimAbout(task[0]);
		newTask.setCaseTask(task[1]);
		newTask.setJudge(task[2]);
		newTask.setDefendant(task[3]);
		newTask.setClaimant(task[4]);
		newTask.setGroupClaim(task[5]);
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY / HH:mm");
			Date date = (Date) format.parse(task[6]);
			newTask.setCurrentReminder(date.getTime());
		} catch (ParseException e) {
			System.out.println("Не правильный формат даты");
			e.printStackTrace();
		}
		newTask.setUserId(user.getId());
		Response response = new Response();
		response.setUser(user);
		 if (task[7].equals("")){
			response.setControllerType("new_task");
		 } else{
			 newTask.setTaskId(Integer.valueOf(task[7]));
			 response.setControllerType("update_task");
		 }
		 
		 //TODO syso del
		 System.out.println("Task " + Arrays.toString(task));
		 System.out.println(user);
		 
		 response.setTask(newTask);
		 if ((response = sc.sendObject(response)) == null) {
			 resp.sendRedirect("error.do");
			 return;
		 } 
		 
		 req.setAttribute("map", response.getTasks());
			
		 req.getRequestDispatcher("WEB-INF/views/task_list.jsp").forward(req, resp);
		 		

	}
	


}
