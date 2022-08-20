package Entity;

import Dao.ConnectionDB;
import model.Code;
import model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CodeEntity {
    public static List<Code> getAllByCode(int subjectId) {

        List<Code> re;
        PreparedStatement ps = null;
        String sql ="";
        try {
            sql ="select * from code where SubjectID = ? ";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            re = new LinkedList<>();
            while (rs.next()) {
                re.add(new Code(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
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

    // Thêm 1 cau hoi vào database
    public static int addone(Code c){
        PreparedStatement pre = null;
        try {
            String sql ="insert into code (CodeID,CodeName,SubjectID,UserID,CodeDescription,Quantity,Time) values (?,?,?,?,?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setInt(1, c.getId());
            pre.setString(2,c.getName());
            pre.setInt(3,c.getSubid());
            pre.setInt(4,c.getUserid());
            pre.setString(5,c.getDes());
            pre.setInt(6, c.getQua());
            pre.setInt(7, c.getTime());

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
            String sql = "select max(CodeID) from code  ";
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
    public static int getCodeBySubjectId(int subid) {
        PreparedStatement st = null;
        int count =0;
        try {
            String sql = "select CodeName from code where  SubjectID = ?  ";
            st = ConnectionDB.connect(sql);
            st.setInt(1,subid);
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
    public static void deleteCode(int id){
        PreparedStatement ps =null ;
        try {
            String sql = "Delete From code where CodeID =?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1,id);

            ps.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int getIdCode(String username){
        int check =0;
        PreparedStatement pre ;
        try {
            String sql ="select CodeID from code where CodeName =?";
            pre = ConnectionDB.connect(sql);
            pre.setString(1,username);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                check= rs.getInt(1);;
            }

            rs.close();
            pre.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
}
