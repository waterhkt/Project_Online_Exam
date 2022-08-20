package control;

import Entity.CodeEntity;
import Entity.QuestionEntity;
import model.Code;
import model.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Add_Question", urlPatterns = "/CT_Add_Question")
public class CT_Add_Question extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String add = request.getParameter("123");
            int a = CodeEntity.getIdCode(add);
            String sel = request.getParameter("sel");
            String thutu =request.getParameter("thutu");
            String question =request.getParameter("question");
            String ans1 = request.getParameter("ans1");
            String ans2 = request.getParameter("ans2");
            String ans3 = request.getParameter("ans3");
            String ans4 = request.getParameter("ans4");
            String result = request.getParameter("result");
            int count =QuestionEntity.maxMaCauHoi() +1;
            System.out.print(sel + question+ ans1 +count);

            Question q = new Question();
            Code c = new Code();

            if(sel!=null ||thutu!=null|| question!=null || ans1 !=null || ans2 !=null
                    || ans3 !=null || ans4 !=null ||result !=null ) {
                if((ans1.equals(result)||ans2.equals(result)||ans3.equals(result)||ans4.equals(result))
                        &&(!ans1.equals(ans2)&&!ans1.equals(ans3)&&!ans1.equals(ans4)&&!ans2.equals(ans3)&&
                        !ans2.equals(ans4)&&!ans3.equals(ans4))){
                    q.setId(count);
                    q.setCode(1);
                    q.setNumber(Integer.parseInt(thutu));
                    q.setContent(question);
                    q.setA(ans1);
                    q.setB(ans2);
                    q.setC(ans3);
                    q.setD(ans4);
                    q.setResukt(result);
                    QuestionEntity.addone(q);
                    c.setId(1);
                    c.setName("123");
                    c.setQua(10);
                    c.setUserid(1);
                    c.setSubid(213423);
                    CodeEntity.addone(c);
                    request.getRequestDispatcher("/CT_Subject").forward(request,response);
                }else{
                    request.getRequestDispatcher("add-question.jsp").forward(request,response);
                }

            }
            if(sel==null ||thutu==null|| question==null || ans1 ==null || ans2 ==null
                    || ans3 ==null || ans4 ==null ||result ==null )
                request.getRequestDispatcher("add-question.jsp").forward(request,response);

        }finally {
            out.close();
        }

    }
}
