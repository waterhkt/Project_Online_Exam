package control;

import Entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Login", urlPatterns = "/CT_Login")
public class CT_Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();


        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean check = UserEntity.checkLogin(username,password);
            int role;
            if(check){
                role = UserEntity.checkRole(username);
                System.out.print(role);
                if(role == 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("ten_dang_nhap", username);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Index");
                    dispatcher.forward(request, response);
                }
                if(role==1){
                    HttpSession session = request.getSession();
                    session.setAttribute("ten_dang_nhap", username);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                    dispatcher.forward(request, response);
                }
            }
            if(!check ){
                HttpSession session =request.getSession();
                session.setAttribute("ten_dang_nhap", username);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request,response);
            }


        }finally {
            out.close();
        }
    }
}
