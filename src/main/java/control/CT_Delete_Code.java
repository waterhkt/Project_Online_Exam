package control;

import Entity.CodeEntity;
import Entity.SubjectEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Delete_Code", urlPatterns = "/CT_Delete_Code")
public class CT_Delete_Code extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
//            int subid = Integer.parseInt(request.getParameter("idsub"));
            String idDelete = request.getParameter("a");
//            System.out.print(idDelete +"a" +subid);
            if(idDelete!=null) {
                int id = Integer.parseInt(idDelete);
                CodeEntity.deleteCode(id);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                dispatcher.forward(request, response);

            }else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                dispatcher.forward(request,response);
            }
        }finally {
            out.close();
        }
    }
}
