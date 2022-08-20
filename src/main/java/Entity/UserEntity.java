package Entity;

import Dao.ConnectionDB;
import model.Subject;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserEntity {

    //Lấy ra tất cả Khoa trong database
    public static List<User> getAll() {
        List<User> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `user`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)

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
    public static boolean checkLogin(String username , String password){
        boolean check =false;
        PreparedStatement pre ;
        try {
            String sql ="select * from user where username =? and password =?";
            pre = ConnectionDB.connect(sql);
            pre.setString(1,username);
            pre.setString(2,password);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                check = true;
            }else check=false;

            rs.close();
            pre.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public static int checkRole(String username){
        int check =0;
        PreparedStatement pre ;
        try {
            String sql ="select role from user where username =?";
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
    public static int getIdUser(String username){
        int check =0;
        PreparedStatement pre ;
        try {
            String sql ="select UserID from user where username =?";
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
    // Thêm 1 cau hoi vào database
    public static int addone(User user){
        PreparedStatement pre = null;
        try {
            String sql ="insert into user (id,username,password,role) values (?,?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setInt(1,user.getId());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getUsername());
            pre.setInt(4,user.getRole());
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public static int maxUserId() {
        PreparedStatement st = null;
        int count =0;
        try {
            String sql = "select max(id) from user  ";
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
