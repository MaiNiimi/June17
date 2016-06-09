package risyu_ms;

import java.io.IOException;
 
import javax.jdo.*;
import javax.servlet.http.*;

import risyu_ms.Lesson2;
import risyu_ms.PMF2;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("UTF-8");
        String className = req.getParameter("className");
        String teacher = req.getParameter("teacher");
        String term = req.getParameter("term");
        String week = req.getParameter("week");
        String periodS = req.getParameter("period");
        int period = Integer.parseInt(periodS);
        String creditS= req.getParameter("credit");
        int credit = Integer.parseInt(creditS);

        String explanation = req.getParameter("explanation");
        Lesson2 lesson2 = new Lesson2(className,teacher,term,week,period,credit,explanation);
        PersistenceManagerFactory factory = PMF2.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(lesson2);
        } finally {
            manager.close();
        }*/
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String className = req.getParameter("name");
		String name = "umeko";
		ServletContext application = this.getServletContext();
		application.setAttribute("name", name);
		application.setAttribute("className", className);
		
		// Student data = new Student(name,id);
		//try{ manager.makePersistent(data); }finally{ manager.close(); }
		
		PersistenceManagerFactory factory = PMF2.get();
		PersistenceManager manager = factory.getPersistenceManager();
		String param1 = req.getParameter("id");
		List<Lesson> list = null;
		if (param1 == null || param1 ==""){
            String query = "select from " + Lesson2.class.getName();
            try {
                list = (List<Lesson>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Lesson data = (Lesson)manager.getObjectById(Lesson.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Lesson data : list){
				res += "{id:" + data.getId() + ",className:'" + data.getClassName() + "',teacher:'"
						+ data.getTeacher() + "',period:'" + data.getPeriod() + "',credit:'" + data.getCredit()
						+ "',teacher:'" + data.getTeacher() + "',term:'" + data.getTerm() + "',explanation:'"
						+ data.getExplanation() + "',week:'" + data.getWeek() + "'},";
            }
            
        }
        res += "]";
        //manager.makePersistent(list);
        manager.close();
		//
		//出力する
		PrintWriter out = resp.getWriter();
		String res2 = req.getUserPrincipal().getName()  + "さん、" + className + "を登録しました！";
		out.println(res2);
		out.println("<p><a href=\"main.jsp\">メニューへ</a></p>");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
