package Dao;

import Entity.*;
import model.Answers;
import model.Question;
import model.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class ConnectionDB {
    static Connection con;

    public static Statement connect() throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/axonnative", "root", "BrittanyHan.320@");
            if (con != null) System.out.println("da ket noi");
            return con.createStatement();
        } else
            return con.createStatement();

    }

    public static PreparedStatement connect(String sql) throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/axonnative", "root", "BrittanyHan.320@");
            return con.prepareStatement(sql);
        } else {
            return con.prepareStatement(sql);
        }
    }

    public static PreparedStatement connectupdate(String sql) throws ClassNotFoundException ,SQLException {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axonnative", "root", "BrittanyHan.320@");
            return con.prepareCall(sql);
        } else {
            return con.prepareCall(sql);
        }
    }
//public static Statement connect() throws ClassNotFoundException, SQLException {
//    if (con == null || con.isClosed()) {
//        Class.forName("com.mysql.jdbc.Driver");
//        con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/axonactive", "root", "18130042");
//        if (con != null) System.out.println("da ket noi");
//        return con.createStatement();
//    } else
//        return con.createStatement();
//
//}
//
//    public static PreparedStatement connect(String sql) throws ClassNotFoundException, SQLException {
//        if (con == null || con.isClosed()) {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/axonactive", "root", "18130042");
//            return con.prepareStatement(sql);
//        } else {
//            return con.prepareStatement(sql);
//        }
//    }
//
//    public static PreparedStatement connectupdate(String sql) throws ClassNotFoundException ,SQLException {
//        if (con == null || con.isClosed()) {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axonactive", "root", "18130042");
//            return con.prepareCall(sql);
//        } else {
//            return con.prepareCall(sql);
//        }
//    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//    try{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con=DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/axonactive","root","18130042");
////here sonoo is database name, root is username and password
//        Statement stmt=con.createStatement();
//        int a =0;
//        ResultSet rs=stmt.executeQuery("select * from user");
//        while(rs.next())
//            System.out.println(a++);
//        con.close();
//    }catch(Exception e){ System.out.println(e);
//    }


//    ConnectionDB.connect();

//    System.out.print(UserEntity.checkLogin("tino","1911"));
//    ExamEntity.getAll().get(0).getA();
//    System.out.print(ExamEntity.getAll().get(0).getA());
//    ExamEntity.checkResult(1,"d");
//    System.out.print( ExamEntity.checkResult(1,"d"));
//    System.out.print( UserEntity.checkRole("18130282"));
//    System.out.print( SubjectEntity.getAll().get(1).getTc());
//    QuestionEntity q = new QuestionEntity();
////    Question qs = new Question(5,1,5,"Cau hoi 5","1","2","3","4","B");
////    System.out.print(q.addone(qs));
//    for (int i =1; i<8;i++){
//        System.out.print("a"+i);
//    }
//    String name = "123";
//    QuestionEntity.getAllByCode(name);

//    System.out.print(CodeEntity.getIdCode("123"));

//        StudentEntity st = new StudentEntity();
//        st.update(2,18130042);
//        st.uploadFile("Students.xlsx");
//        System.out.print(st.checkCode(18130051));
//        AnswersAntity a = new AnswersAntity();
//
        QuestionEntity q = new QuestionEntity();
        System.out.print(q.getCodeByFile("Exams.xlsx")+"code");
//        List<Question> lq = q.getAll();
////        q.uploadFile("Exams.xlsx");
//int re=0;
//        AnswersAntity sc = new AnswersAntity();
//        List<Answers> scc = sc.getAll();
//
//        for (int i=0; i< lq.size();i++){
//            if(lq.get(i).getResukt().equals(scc.get(i).getAnswersChoosecol()))
//                re= re+1;
//            re =re;
//        }
//        System.out.print(re + "   111111");
//        UserEntity.addone(new User("1111","1111",0));
//        Cập nhập điểm
//        QuestionEntity q1 = new QuestionEntity();
//        List<Question> lq = q1.getAllQuestionByCodeID("125");
//        System.out.print(lq.size()+"lq");
//        int re=0;
//        AnswersAntity sc = new AnswersAntity();
//        for (int i = 0; i<StudentEntity.getAll().size();i++) {
//            List<Answers> scc = sc.getAll(StudentEntity.getAll().get(i).getStudentId(), 125);
//            if (scc.size() == 0) {
//                re = 0;
//            } else {
//                System.out.print(scc.size()+"sc");
//                for (int j = 0; j < scc.size(); j++) {
//                    if (lq.get(j).getResukt().equals(scc.get(j).getAnswersChoosecol())){
//                        re++;
//                    }
//
//                }
//                System.out.print("aaaaaaa"+re/2+"jjjjjjjj");
//            }
//
//        }
    }
}

