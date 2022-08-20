package control;

import Entity.GradeEntity;
import Entity.QuestionEntity;
import model.Grade;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CT_List_Grade", urlPatterns = "/CT_List_Grade")
public class CT_List_Grade extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            GradeEntity pr = new GradeEntity();
            List<Grade> value = pr.getAll();

            request.setAttribute("list",value);
            request.getRequestDispatcher("/list-grade.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
