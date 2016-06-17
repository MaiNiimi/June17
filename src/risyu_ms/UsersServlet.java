package risyu_ms;

import com.google.api.server.spi.auth.common.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.security.Principal;

import javax.servlet.*;
import javax.servlet.http.*;
 
import com.google.appengine.api.users.*;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = UserServiceFactory.getUserService();
		String thisUrl = req.getRequestURI();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		resp.sendRedirect(userService.createLogoutURL(thisUrl));
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();

		String thisUrl = req.getRequestURI();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		UserService service = UserServiceFactory.getUserService();
		HttpSession session = req.getSession();
		
	
		 if (service.isUserLoggedIn()){
	            session.setAttribute("user", service.getCurrentUser());
	        } else {
	            session.removeAttribute("user");
	        }
		
		if (req.getUserPrincipal() != null) {
			resp.getWriter().println("<p>" + req.getUserPrincipal().getName() + "さん、ログイン中…"+"</p>");
			resp.getWriter().println("<p><a href=\"main.jsp\">メニューへ</a></p>");
			resp.getWriter().println("<p><a href=\"" + userService.createLogoutURL(thisUrl) + "\">ログアウトする</a></p>");
			
		} else {
			resp.getWriter()
					.println("<p><a href=\"" + userService.createLoginURL(thisUrl) + "\">ログインする！</a></p>");
		}
	}
}