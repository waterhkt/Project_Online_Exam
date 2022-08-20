package control;

import Entity.QuestionEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Delete_Question", urlPatterns = "/CT_Delete_Question")
public class CT_Delete_Question extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String idDelete = request.getParameter("id");
            if(idDelete!=null) {
                int id = Integer.parseInt(idDelete);
                QuestionEntity.deleteQuestion(id);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                dispatcher.forward(request, response);

            }else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Load_List");
                dispatcher.forward(request,response);
            }
        }finally {
            out.close();
        }
    }
}
