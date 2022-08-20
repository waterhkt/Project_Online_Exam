package control;

import Entity.*;
import model.Answers;
import model.Grade;
import model.Question;

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

@WebServlet(name = "CT_Submit", urlPatterns = "/CT_Submit")
public class CT_Submit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String username = request.getParameter("username");
            String code = request.getParameter("code");
            int codeNumber = Integer.parseInt(code);
            System.out.print(username);
            int id = Integer.parseInt(username);
            int count =0;
            double correct = 0;
            double score = 0;
            StudentEntity st = new StudentEntity();
            QuestionEntity pr = new QuestionEntity();
            List<Question> value = pr.getAllQuestionByCodeID(code);
            String date = String.valueOf(java.time.LocalDate.now() );
            String time = String.valueOf(java.time.LocalTime.now());

            AnswersAntity sc = new AnswersAntity();



//            Lưu đáp án của sv xg DB
            for (int i =0;i< value.size();i++){
                int max = sc.maxIdCode();
                if(max ==0){
                    max=i+1;
                }else{
                    max =max +1;
                }
                Answers ans = new Answers(max,id,codeNumber,request.getParameter("ans"+(i+1)));
                sc.addone(ans);
//                Xác định số câu đúng
                if(value.get(i).getResukt().equals(request.getParameter("ans"+(i+1)))){
                    correct++;
                }
            }

            System.out.println(java.time.LocalDate.now());
            System.out.println(java.time.LocalTime.now().getHour());
            score= Math.round( correct*10/(value.size())*100.0)/100.0;
            count= (int) correct;
//            Thêm điểm vào bảng điểm
            Grade g = new Grade(id,3,count,score,time,date);
            GradeEntity.addone(g);
//            update điểm sv
            st.update(score,id);

            HttpSession session =request.getSession();
            session.setAttribute("score" , score);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Score");
            dispatcher.forward(request,response);


        }finally {
            out.close();
        }
    }
//    static String get1(String text){
//        String result = null;
//        for (int i =0;i< text.length();i++){
//            result = String.valueOf(text.charAt(0));
//        }
//        return result;
//    }
}
