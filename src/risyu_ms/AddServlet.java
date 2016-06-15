package risyu_ms;

import java.io.IOException;
 
import javax.jdo.*;
import javax.servlet.http.*;

import com.google.api.server.spi.auth.common.User;

import risyu_ms.Lesson;
import risyu_ms.PMF;

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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
        String className = req.getParameter("className");
        String teacher = req.getParameter("teacher");
        String term = req.getParameter("term");
        String week = req.getParameter("week");
        String periodS = req.getParameter("period");
        int period = Integer.parseInt(periodS);
        String creditS = req.getParameter("credit");
        int credit = Integer.parseInt(creditS);
        String explanation = req.getParameter("explanation");
        String student = req.getUserPrincipal().getName();
        Lesson data = new Lesson(className,teacher, term, week,period, credit, explanation, student);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        //out.println(className);
        
        /*
        String teacher = req.getParameter("teacher");        
        String term = req.getParameter("term");
        String week = req.getParameter("week");
        String periodS = req.getParameter("period");
        int period = Integer.parseInt(periodS);
        String creditS= req.getParameter("credit");
        int credit = Integer.parseInt(creditS);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String student = user.getEmail();
        
        String explanation = req.getParameter("explanation");
        Lesson lesson = new Lesson(className, teacher, term, week, period, credit,
    			  explanation, student);
  
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		 

        try {
        manager.makePersistent(lesson);
        } finally {
        	manager.close();
        }
        */
		
		//出力する

		String res2 = req.getUserPrincipal().getName()  + "さん、" + className + "を登録しました！";
		out.println(res2);
		out.println("<p><a href=\"main.jsp\">メニューへ</a></p>");
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
