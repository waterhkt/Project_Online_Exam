package control;

import Entity.QuestionEntity;
import Entity.StudentEntity;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CT_Check_Inf", urlPatterns = "/CT_Check_Inf")
public class CT_Check_Inf extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String subid = request.getParameter("subId");

                request.setAttribute("subid",subid);
                request.getRequestDispatcher("/check-inf.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
