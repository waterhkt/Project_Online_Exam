package control;

import Entity.AnswersAntity;
import Entity.EmailUtility;
import Entity.QuestionEntity;
import Entity.StudentEntity;
import model.Answers;
import model.Question;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CT_Question_Update", urlPatterns = "/CT_Question_Update")
public class CT_Question_Update extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("id");
            int idi = Integer.parseInt(id);
            String ma = request.getParameter("code");
            int code = Integer.parseInt(ma);
            String thutu = request.getParameter("thutu");
            String content = request.getParameter("question");
            String a = request.getParameter("ans1");
            String b = request.getParameter("ans2");
            String c = request.getParameter("ans3");
            String d = request.getParameter("ans4");
            String result = request.getParameter("result");


            Question q = new Question();
            if(  result !=null ) {
                q.setCode(code);
                q.setId(Integer.parseInt(id));
                q.setNumber(Integer.parseInt(thutu));
                q.setContent(content);
                q.setA(a);
                q.setB(b);
                q.setC(c);
                q.setD(d);
                q.setResukt(result);
                QuestionEntity.update(q);

//                Cập nhập điểm
                QuestionEntity q1 = new QuestionEntity();
                List<Question> lq = q1.getAllQuestionByCodeID(ma);

                int re=0;
                AnswersAntity sc = new AnswersAntity();
                for (int i = 0; i<StudentEntity.getAllByCode(code).size();i++) {
                    List<Answers> scc = sc.getAll(StudentEntity.getAllByCode(code).get(i).getStudentId(),code);
                    if(scc.size()==0){
                        re =0;
                    }else{
                    for (int j = 0; j < lq.size(); j++) {
                        if (lq.get(j).getResukt().equals(scc.get(j).getAnswersChoosecol()))
                            re = re + 1;
                        re = re;
                    }}
//                    double score = Math.round(re/2 *10 / (lq.size())* 100.0) / 100.0;
                    double score = re *10 / (lq.size());
//                    Thông báo mail khi thay đổi đáp án
                    try {
                        if(StudentEntity.getAllByCode(code).get(i).getGrade() != score) {
                            EmailUtility.sendEmail(host, port, user, pass, StudentEntity.getAllByCode(code).get(i).getEmail(), "Đồ án chuyên ngành",
                                    "Điểm của bạn đã thay đổi thành :" + score);
                        }
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    StudentEntity.update(score, StudentEntity.getAllByCode(code).get(i).getStudentId());
                    re=0;
//
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                dispatcher.forward(request,response);
            }else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CT_Subject");
                dispatcher.forward(request,response);
            }
        }finally {
            out.close();
        }
    }
}
