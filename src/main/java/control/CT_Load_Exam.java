package control;

import Entity.ExamEntity;
import model.Exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CT_Load_Exam", urlPatterns = "/CT_Load_Exam")
public class CT_Load_Exam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String count_page = request.getParameter("count_page");
            String idCode = request.getParameter("codename");
            String idSubject = request.getParameter("subjectId");
            //   String count_after = request.getParameter("count_after");
            ExamEntity pr = new ExamEntity();

            List<Exam> value = pr.getAllByCode(Integer.parseInt(idCode));
//            List<Integer> code = new ArrayList<>();
            //test xem có lấy đúng số lượng sản phẩm
//            for (Product p : value){
//                System.out.println(p);
//            }
    System.out.print(idCode);
    System.out.print(idSubject);

            request.setAttribute("list",value);
            request.getRequestDispatcher("/exam.jsp").forward(request,response);
        }catch (Exception e){

        }
    }
}
