package control;

import Entity.QuestionEntity;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CT_Load_List", urlPatterns = "/CT_Load_List")
public class CT_Load_List extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String name = request.getParameter("na");
//            String as = request.getParameter("na");
//            int a = Integer.parseInt(name);
            List<Question> value = new LinkedList<>();
            QuestionEntity pr = new QuestionEntity();
            if(name!= null){
//                value = pr.getAllQuestionByCodeID(name);
//                value = pr.getAll();
                value = pr.getAllQuestionByCodeID(name);
                System.out.print(value.get(0) + "aaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
                System.out.print(name + "jjjjjjj");
                request.setAttribute("list", value);
                request.setAttribute("name", name);
                request.getRequestDispatcher("/list-question.jsp").forward(request, response);


        }catch (Exception e){

        }
    }
}
