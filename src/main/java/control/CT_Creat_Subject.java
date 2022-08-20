package control;

import Entity.QuestionEntity;
import Entity.SubjectEntity;
import model.Question;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Creat_Subject", urlPatterns = "/CT_Creat_Subject")
public class CT_Creat_Subject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String id = request.getParameter("subjectId");
            String name = request.getParameter("subjectName");
            String tc = request.getParameter("subjectTc");
            System.out.print(id + name + tc);
//            int count = QuestionEntity.maxMaCauHoi() +1;

            Subject s = new Subject();

            if(id!=null ||name!=null|| tc!=null  ) {
                s.setMa(id);
                s.setName(name);
                s.setTc(tc);
                SubjectEntity.addone(s);
                request.getRequestDispatcher("/CT_Subject").forward(request,response);
            }
            if(id==null ||name==null|| tc==null  )
                request.getRequestDispatcher("/CT_Index").forward(request,response);

        }finally {
            out.close();
        }
    }
}
