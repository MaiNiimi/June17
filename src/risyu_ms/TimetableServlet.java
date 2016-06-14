package risyu_ms;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String className = req.getParameter("className");
		String teacher = req.getParameter("teacher");
		String term = req.getParameter("term");
		String week = req.getParameter("week");
		String query = "select from " + Lesson.class.getName() + " where className == " + className;
		// PrintWriter out = response.getWriter();
		List<Lesson> list = null;
		try {
			list = (List<Lesson>) manager.newQuery(query).execute();
			// http://puyooboe.blogspot.jp/2015/12/gae.html
		} catch (JDOObjectNotFoundException e) {
		}
		String res = "[";
		if (list != null) {
			for (Lesson data : list) {
				res += "{id:" + data.getId() + ",className:'" + data.getClassName() + "',teacher:'"
						+ data.getTeacher() + "',period:'"
						+ "',teacher:'" + data.getTeacher() + "',term:'" + data.getTerm() + "',explanation:'"
						+ data.getExplanation() + "',week:'" + data.getWeek() + "'},";
			}
		}
		res += "]";
		manager.close();
        resp.sendRedirect("/timetable.jsp");
	}
	
	protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
}
