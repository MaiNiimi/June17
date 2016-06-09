package risyu_ms;

import com.google.api.server.spi.auth.common.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();

		String thisUrl = req.getRequestURI();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		//String name = user.getEmail();
		
		if (req.getUserPrincipal() != null) {
			//resp.getWriter().println("<p>" + name + "さん、ログイン中… You can <a href=\""

					resp.getWriter().println("<p>" + req.getUserPrincipal().getName() + "さん、ログイン中… You can <a href=\""
					+ userService.createLogoutURL(thisUrl) + "\">sign out</a>.</p>");
			resp.getWriter().println("<p><a href=\"main.jsp\">メニューへ</a></p>");
			
		} else {
			resp.getWriter()
					.println("<p>Please <a href=\"" + userService.createLoginURL(thisUrl) + "\">sign in</a>.</p>");
		}
	}
}