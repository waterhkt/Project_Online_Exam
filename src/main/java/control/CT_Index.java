package control;

import Entity.SubjectEntity;
import Entity.UserEntity;
import model.Question;
import model.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CT_Index", urlPatterns = "/CT_Index")
public class CT_Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();


        try {

            String username = request.getParameter("ten_dang_nhap");
            SubjectEntity s = new SubjectEntity();
            List<Subject> value = s.getAll();

            request.setAttribute("list",value);
            request.setAttribute("username",username);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);


        }finally {
            out.close();
        }
    }
}
