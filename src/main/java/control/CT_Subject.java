package control;

import Entity.SubjectEntity;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CT_Subject", urlPatterns = "/CT_Subject")
public class CT_Subject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            SubjectEntity pr = new SubjectEntity();

            List<Subject> value = pr.getAll();
            request.setAttribute("list",value);
            request.getRequestDispatcher("/admin.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
