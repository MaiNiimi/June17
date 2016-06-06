package risyu_ms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String className = req.getParameter("name");
		String name = "umeko";
		ServletContext application = this.getServletContext();
		application.setAttribute("name", name);
		application.setAttribute("className", className);
		// PersistenceManagerFactory factory = PMF.get();
		// PersistenceManager manager = factory.getPersistenceManager();
		// Student data = new Student(name,id);
		/*
		 * try{ manager.makePersistent(data); }finally{ manager.close(); }
		 */
		PrintWriter out = resp.getWriter();
		String res = req.getUserPrincipal().getName()  + "さん、" + className + "を登録しました！";
		out.println(res);
		out.println("<p><a href=\"main.jsp\">メニューへ</a></p>");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
