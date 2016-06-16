package risyu_ms;

import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PairCourseServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String param1 = req.getParameter("id");
		String loginId = req.getUserPrincipal().getName();
		PrintWriter out = resp.getWriter();
		List<Lesson> list = null;
		if (param1 == null || param1 == "") {
			String query = "select from " + Lesson.class.getName();
			try {
				list = (List<Lesson>) manager.newQuery(query).execute();
			} catch (JDOObjectNotFoundException e) {
			}
		} else {
			try {
				Lesson data = (Lesson) manager.getObjectById(Lesson.class, Long.parseLong(param1));
				list = new ArrayList();
				list.add(data);
			} catch (JDOObjectNotFoundException e) {
			}
		}
		String res = "[";
		if (list != null) {
			for (Lesson data : list) {
				res += "{id:" + data.getId() + ",className:'" + data.getClassName() + "',teacher:'" + data.getTeacher()
						+ "',period:'" + data.getPeriod() + "',credit:'" + data.getCredit() + "',term:'" + data.getTerm() + "',explanation:'" + data.getExplanation()
						+ "',week:'" + data.getWeek() +"',student:'" + data.getStudent()+ "',loginId:'" + loginId+ "'},";
			}
		}
		res += "]";
		out.println(res);
		manager.close();
	}
}
