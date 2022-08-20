package control;

import Entity.QuestionEntity;
import Entity.StudentEntity;
import model.Question;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CT_Load_Student", urlPatterns = "/CT_Load_Student")
public class CT_Load_Student extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String name = request.getParameter("na");
//            String as = request.getParameter("na");
            int a = Integer.parseInt(name);
            int sssv =0;
            int g = 0, k=0 , tb=0 ,y=0 ,bt=0;

            List<Student> value = new LinkedList<>();
            StudentEntity pr = new StudentEntity();
            if(name!= null){
                value = pr.getAllByCode(a);
//                value = pr.getAll();
                sssv = value.size();
                System.out.print(value.size() + "aaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }

            if(value.size()==0){
                value.add(new Student(1,0,0,0,"null","null","null",0,"N"));
                System.out.print(name + "jjjjjjj");
                request.setAttribute("list",value);
                request.setAttribute("name",name);
                request.getRequestDispatcher("/students.jsp").forward(request,response);
            }
            for (int i =0; i< value.size();i++){
                if(value.get(i).getRating().equals("Giỏi")) g = g+1;
                if(value.get(i).getRating().equals("Khá")) k = k+1;
                if(value.get(i).getRating().equals("Trung Bình")) tb = tb+1;
                if(value.get(i).getRating().equals("Yếu")) y = y+1;
                if(value.get(i).getRating().equals("N")) bt = bt+1;
            }
            request.setAttribute("list",value);
            request.setAttribute("name",name);
            request.setAttribute("tong",sssv);
            request.setAttribute("gioi",g);
            request.setAttribute("kha",k);
            request.setAttribute("trungbinh",tb);
            request.setAttribute("yeu",y);
            request.setAttribute("bothi",bt);
            request.getRequestDispatcher("/students.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
