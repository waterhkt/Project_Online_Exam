package control;

import Entity.CodeEntity;
import Entity.QuestionEntity;
import Entity.StudentEntity;
import Entity.UserEntity;
import model.Code;
import model.Student;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CT_Import_File", urlPatterns = "/CT_Import_File")
public class CT_Import_File extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String link2 = request.getParameter("fileToUploadStudent");
            StudentEntity ss = new StudentEntity();
            ss.uploadFile(link2);
            String name = request.getParameter("na");
            List<Student> value = new LinkedList<>();
            StudentEntity pr = new StudentEntity();
            UserEntity us = new UserEntity();
            value = pr.getAll();
            for (int i=0;i<value.size();i++){
//                int max = 1;
//                if(us.maxUserId()==0 ){
//                    max =1;
//                }else{
//                    max = us.maxUserId()+1;
//                }
                String username = String.valueOf(value.get(i).getStudentId());
                String password = String.valueOf(value.get(i).getStudentId());
                User u = new User(username,password,0);
                us.addone(u);
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Load_Student");
            dispatcher.forward(request, response);
        }finally {
            out.close();
        }
    }
}
