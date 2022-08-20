package Entity;

import Dao.ConnectionDB;
import model.Answers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AnswersAntity {

    public static List<Answers> getAll(int mssv ,int code) {
        List<Answers> re;
        PreparedStatement pre = null;
        try {
            String sql = "SELECT * FROM `answerstudentchoose` where UserID = ? and QuestionID = ?";
            pre= ConnectionDB.connect(sql);
            pre.setInt(1,mssv);
            pre.setInt(2,code);
            ResultSet rs = pre.executeQuery();
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Answers(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
            rs.close();
            pre.close();

            return re ;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();

        }

    }
    // Thêm 1 cau hoi vào database
    public static int addone(Answers a){
        PreparedStatement pre = null;
        try {
            String sql ="insert into answerstudentchoose (ID,UserID,QuestionID,answersChoosecol) values (?,?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setInt(1, a.getId());
            pre.setInt(2,a.getUserId());
            pre.setInt(3,a.getQuestionId());
            pre.setString(4,a.getAnswersChoosecol());

            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public static int maxIdCode() {
        PreparedStatement st = null;
        int count =0;
        try {
            String sql = "select max(ID) from answerstudentchoose ";
            st = ConnectionDB.connect(sql);
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                count =rs.getInt(1);
            }
            rs.close();
            st.close();
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 0;

        }
    }
}
