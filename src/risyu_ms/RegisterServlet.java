package risyu_ms;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req,
           HttpServletResponse resp)
           throws ServletException, IOException {
       resp.setContentType("text/plain");
       resp.getWriter().println("no url...");
   }

   @Override
   protected void doPost(HttpServletRequest req,
           HttpServletResponse resp)
           throws ServletException, IOException {
	   req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");

       String className = req.getParameter("name");
       String teacher = req.getParameter("teacher");
       String explanation = req.getParameter("explanation");
       Date date = Calendar.getInstance().getTime();
       LinkData data = new LinkData(className, teacher, explanation ,date);
       PersistenceManagerFactory factory = PMF.get();
       PersistenceManager manager = factory.getPersistenceManager();
       try {
           manager.makePersistent(data);
       } finally {
           manager.close();
       }
     //出力する
     		PrintWriter out = resp.getWriter();
     		String res2 = req.getUserPrincipal().getName()  + "さん、" + className + "を登録しました！";
     		out.println(res2);
     		out.println("<p><a href=\"main.jsp\">メニューへ</a></p>");
       //resp.sendRedirect("/timetable.jsp");
   }
}

