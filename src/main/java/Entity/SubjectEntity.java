package Entity;

import Dao.ConnectionDB;
import model.Question;
import model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SubjectEntity {


    //Lấy ra tất cả Khoa trong database
    public static List<Subject> getAll() {
        List<Subject> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `subject`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Subject(

                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)

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
    // Thêm 1 cau hoi vào database
    public static int addone(Subject s){
        PreparedStatement pre = null;
        try {
            String sql ="insert into subject (SubjectID,SubjectName,Credits) values (?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setString(1,s.getMa());
            pre.setString(2,s.getName());
            pre.setString(3,s.getTc());
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public static void deleteSubject(int id){
        PreparedStatement ps =null ;
        try {
            String sql = "Delete From subject where SubjectID =?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1,id);

            ps.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
