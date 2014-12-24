package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie myCookie;
		Cookie[] cookie = req.getCookies();
		for ( int i = 0 ; i < cookie.length ; i ++){
			if ( cookie[i].getName().equals("email")){
			myCookie = cookie[i];
			myCookie.setMaxAge(0);
			resp.addCookie(myCookie);
		
			}
		}
		
//		resp.addCookie(new Cookie("email", ""));
        req.getSession().invalidate();
        resp.sendRedirect("wellcome.do");
	}
	
}
