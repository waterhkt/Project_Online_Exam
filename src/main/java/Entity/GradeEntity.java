package Entity;

import Dao.ConnectionDB;
import model.Grade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GradeEntity {
    //Lấy ra tất cả Khoa trong database
    public static List<Grade> getAll() {
        List<Grade> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `grade`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Grade(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)

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
    // Thêm 1 diem vào database
    public static int addone(Grade q){
        PreparedStatement pre = null;
        try {
            String sql ="insert into grade (UserID,CodeID,NumberOfCorrectAnswers,Grade,SubmitTime,Date) values (?,?,?,?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setInt(1,q.getUserid());
            pre.setInt(2,q.getCodeid());
            pre.setInt(3,q.getNcorrect());
            pre.setDouble(4,q.getGrade());
            pre.setString(5,q.getStime());
            pre.setString(6,q.getDate());
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
