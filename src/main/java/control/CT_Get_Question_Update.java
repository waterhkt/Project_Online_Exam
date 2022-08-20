package control;

import Entity.QuestionEntity;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CT_Get_Question_Update", urlPatterns = "/CT_Get_Question_Update")
public class CT_Get_Question_Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        if(id!=null) {
            int a = Integer.parseInt(id);
            QuestionEntity dao = new QuestionEntity();
            Question value = dao.getQuestionById(a);
            request.setAttribute("code", code);
            request.setAttribute("detail", value);
            request.getRequestDispatcher("/update_question.jsp").forward(request, response);

        }
    }
}
