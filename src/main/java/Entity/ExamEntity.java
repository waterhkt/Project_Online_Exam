package Entity;

import Dao.ConnectionDB;
import model.Exam;
import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ExamEntity {

    //Lấy ra tất cả Khoa trong database
    public static List<Exam> getAll() {
        List<Exam> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `exam`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Exam(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)

                ));
            }
            rs.close();
            st.close();

            return re ;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();

        }

    }
    public static List<Exam> getAllByCode(int code) {
        List<Exam> re;
        PreparedStatement ps = null;
        String sql ="";
        try {
            sql ="select * from exam where idcode = ? ";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            re = new LinkedList<>();
            while (rs.next()) {
                re.add(new Exam(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
            System.out.println(re.size());
            rs.close();
            ps.close();
            return re;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();

        }

    }
    //Lấy thông tin tài khoản cần Sửa
    public static Exam getExamById(int idExam) {
        Exam exam ;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "select * from exam where idexam = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, idExam);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            exam = new Exam();
            while (rs.next()) {
                int id= rs.getInt(1);
                String a =rs.getString(2);
                String b = rs.getString(3);
                String c =rs.getString(4);
                String d = rs.getString(5);
                String result = rs.getString(6);
                int code = rs.getInt(7);

                exam= new Exam(id,a,b,c,d,result,code);
            }
            rs.close();
            ps.close();
            return exam;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }
    public static double checkResult(int code ,String a) {
        List<Exam> e = getAllByCode(code);
        System.out.print(e.get(1).getResulte() + "1111111111");
        double result = 0;
        for (int i = 0; i< e.size();i++) {
                if (a.equals(e.get(i).getResulte())) {
                       result ++;

            }
        }
        return result;
    }
}
