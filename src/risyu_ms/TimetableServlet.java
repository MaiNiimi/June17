package risyu_ms;

import java.io.IOException;
import java.io.PrintWriter;
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
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		
		String loginId = req.getUserPrincipal().getName();
		//なんか、Portion of expression could not be parsed: @gm.tsuda.ac.jpってエラー出る
		//String query = "select from " + Lesson.class.getName() + " where request.responseText.student==" + loginId;
		//これが正しいやつ！全部表示される！
		String query = "select from " + Lesson.class.getName();// + " where className == " + className;
		//なんかずっとあるやつ！
		//String query = "select from" +Lesson.class.getName() + "where student ==" + loginId;
		//PrintWriter out = resp.getWriter();
		
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
						+ data.getTeacher() + "',period:'" + data.getPeriod() + "',credit:'" + data.getCredit()
						+ "',term:'" + data.getTerm() + "',explanation:'"
						+ data.getExplanation() + "',week:'" + data.getWeek() + "'}";
			}
		}

		res += "]";
		manager.close();
		//out.println(res);
        resp.sendRedirect("/timetable.jsp");
	}
	
	protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
}
