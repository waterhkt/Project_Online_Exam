package control;

import Entity.*;
import model.Code;
import model.Question;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CT_Add_Code", urlPatterns = "/CT_Add_Code")
public class CT_Add_Code extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //demo_template
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String link1 = request.getParameter("fileToUploadExam");
//            String link2 = request.getParameter("fileToUploadStudent");
//            System.out.print(link1);
//            StudentEntity ss = new StudentEntity();
//            ss.uploadFile(link2);
            QuestionEntity qe = new QuestionEntity();
            qe.uploadFile(link1);
            String subid = request.getParameter("idsub");
            int codeid = CodeEntity.maxIdCode();
            String user = request.getParameter("dn");
            String id = request.getParameter("codename");
            String des = request.getParameter("des");
            String time = "60";
            String quan = "40";
//            int userid = UserEntity.getIdUser(user);
//            System.out.print(user+ subid);
//            int count = QuestionEntity.maxMaCauHoi() +1;
            if(codeid==0){
                codeid=1;
            }
            Code s = new Code();

            if(id!=null ||des!=null|| time!=null  ) {
                s.setId(codeid+1);
                s.setName(id);
                s.setSubid(Integer.parseInt(subid));
                s.setUserid(0);
                s.setDes(des);
                s.setQua(Integer.parseInt(quan));
                s.setTime(Integer.parseInt(time));
                CodeEntity.addone(s);
                request.getRequestDispatcher("/CT_List_Code?id="+subid).forward(request,response);
            }
            if(id==null ||des==null|| time==null  )
                request.getRequestDispatcher("/CT_Index").forward(request,response);

        }finally {
            out.close();
        }
    }
}
