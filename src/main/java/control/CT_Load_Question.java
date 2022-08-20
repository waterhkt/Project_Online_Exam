package control;

import Entity.CodeEntity;
import Entity.ExamEntity;
import Entity.QuestionEntity;
import Entity.StudentEntity;
import model.Exam;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CT_Load_Question", urlPatterns = "/CT_Load_Question")
public class CT_Load_Question extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String name = request.getParameter("subject");
            String username = request.getParameter("username");
            int subid = Integer.parseInt(name);
            String codeId = String.valueOf(CodeEntity.getCodeBySubjectId(subid));
//            String name1 = request.getParameter("name1");
//            int a = Integer.parseInt(name1);
//            String idCode = request.getParameter("codename");
//            String idSubject = request.getParameter("subjectId");
            //   String count_after = request.getParameter("count_after");
            QuestionEntity pr = new QuestionEntity();

//            List<Question> value =  pr.getAllByCode("125");
            int code1 = CodeEntity.getCodeBySubjectId(subid);
            String code2 =String.valueOf(code1);
            List<Question> value ;
//            value= pr.getAll();
            value = pr.getAllQuestionByCodeID(code2);
//            List<Integer> code = new ArrayList<>();
            //test xem có lấy đúng số lượng sản phẩm
//            for (Product p : value){
//                System.out.println(p);
//            }
            String code = request.getParameter("code_name");
            int codeName = Integer.parseInt(code);
            int user = Integer.parseInt(username);
            StudentEntity se = new StudentEntity();
            if(se.checkCode(codeName) && (user == codeName)&& (StudentEntity.getSubjectId(user)==subid)){
                request.setAttribute("code1",code1);
                request.setAttribute("list",value);
                request.setAttribute("name",name);
                request.setAttribute("name1",name);
                request.getRequestDispatcher("/exam.jsp").forward(request,response);
            }else {
                request.setAttribute("subid", subid);
                request.getRequestDispatcher("/check-inf.jsp").forward(request, response);
            }
        }catch (Exception e){

        }
    }
}
