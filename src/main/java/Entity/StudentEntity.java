package Entity;

import Dao.ConnectionDB;
import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class StudentEntity {
    public void uploadFile(String link) {
        String excelFilePath ="G:\\AxonActiveProject\\ProjectAxonActive\\"+ link;
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Student st = new Student();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            int id = (int) nextCell.getNumericCellValue();
//                            st.setId(id);
                            System.out.print(id);
                            break;
                        case 1:
                            int stuId = (int) nextCell.getNumericCellValue();
                            st.setStudentId(stuId);
                            System.out.print(stuId);
                            break;
                        case 2:
                            int subId = (int) nextCell.getNumericCellValue();
                            st.setSubjectId(subId);
                            System.out.print(subId);
                            break;
                        case 3:
                            int codeId = (int) nextCell.getNumericCellValue();
                            st.setCodeId(codeId);
                            System.out.print(codeId);
                            break;
                        case 4:
                            String name = nextCell.getStringCellValue();
                            st.setStudentName(name);
                            System.out.print(name);
                            break;
                        case 5:
                            String email = nextCell.getStringCellValue();
                            st.setEmail(email);
                            System.out.print(email);
                            break;
                        case 6:
                            String sex = nextCell.getStringCellValue();
                            st.setSex(sex);
                            System.out.print(sex);
                            break;
                        case 7:
                            double grade = nextCell.getNumericCellValue();
                            st.setGrade(grade);
                            System.out.print(grade);
                            break;
                        case 8:
                            String rating = nextCell.getStringCellValue();
                            st.setRating(rating);
                            System.out.print(rating);
                            break;


                    }

                }
                list.add(st);
            }

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            System.out.print(list.size());
            System.out.print(list.get(1).getEmail());
            for (int i =0; i< list.size();i++){
                addone(list.get(i));
            }


        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        }
    }
    // Thêm 1 cau hoi vào database
    public static int addone(Student q){
        PreparedStatement pre = null;
        try {
            String sql ="INSERT INTO students (id, studentId,subjectId,codeId, studentName,email,sex,grade,rating) VALUES (?,?,?,?,?, ?, ?,?,?)";
            pre= ConnectionDB.connect(sql);

            pre.setInt(1,q.getId());
            pre.setInt(2,q.getStudentId());
            pre.setInt(3,q.getSubjectId());
            pre.setInt(4,q.getCodeId());
            pre.setString(5,q.getStudentName());
            pre.setString(6,q.getEmail());
            pre.setString(7,q.getSex());
            pre.setDouble(8,q.getGrade());
            pre.setString(9,q.getRating());
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //Lấy ra tất cả Khoa trong database
    public static List<Student> getAll() {
        List<Student> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `students`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Student(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getString(9)

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

    //Lấy ra tất cả Khoa trong database
    public static List<Student> getAllByCode(int code) {
        List<Student> re;
        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM `students` where codeId = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, code);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Student(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getString(9)

                ));
            }
            rs.close();
            ps.close();

            return re ;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();

        }

    }
    //Lấy ra tất cả Khoa trong database
    //Lấy thông tin tài khoản cần chỉnh sữa
    public static double getAllGrade(int userID) {
        double result =0 ;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "SELECT g.Grade FROM `students` st join `grade` g where g.UserID like ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, userID);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                 result = rs.getDouble(1);

            }
            rs.close();
            ps.close();
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  0;
        }
    }
    public static boolean checkCode(int userID) {
        boolean result =false;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM `students` where studentID = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, userID);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = true;
            }
            rs.close();
            ps.close();
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  false;
        }
    }
    public static int getSubjectId(int userID) {
        int result =0;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "SELECT subjectId FROM `students` where studentID = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, userID);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
            }
            rs.close();
            ps.close();
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  0;
        }
    }
    //Chỉnh sữa thông tin question
    public static int update(double grade,int stuId){
        Connection con;
        PreparedStatement pre = null;
        String rate ="";
        try {
            if(grade<5){
                rate ="Yếu";
            }else{
                if(grade <7){
                    rate = "Trung Bình";
                }else{
                    if(grade <9){
                        rate = "Khá";
                    }else{
                        rate = "Giỏi";
                    }

                }
            }
            String sql ="update students set grade=?, rating =? where studentId = ?" ;
            pre= ConnectionDB.connectupdate(sql);
            pre.setDouble(1,grade);
            pre.setString(2,rate);
            pre.setInt(3,stuId);

            System.out.println(sql);
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

//    public static List<Double> getAllGrade() {
//        List<Double> re;
//        Statement st = null;
//        try {
//            st = ConnectionDB.connect();
//            ResultSet rs = st.executeQuery("SELECT g.Grade FROM `students` st join `grade` g where st.studentID like g.UserID");
//            re = new LinkedList<>();
//            while (rs.next()) {
//
//                re.add(
//                        rs.getDouble(1)
//
//                );
//            }
//            rs.close();
//            st.close();
//
//            return re ;
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return new LinkedList<>();
//
//        }
//
//    }

}

//    public void uploadFile(String link) {
//        String jdbcURL = "jdbc:mysql://localhost:3306/axonactive";
//        String username = "root";
//        String password = "18130042";
//
//        String excelFilePath ="G:\\AxonActiveProject\\ProjectAxonActive\\AxonActive\\src\\main\\java\\Dao\\"+ link;
//
//        int batchSize = 20;
//        ArrayList<Student> list = new ArrayList<Student>();
//
//        Connection connection = null;
//
//        try {
//            long start = System.currentTimeMillis();
//
//            FileInputStream inputStream = new FileInputStream(excelFilePath);
//
//            Workbook workbook = new XSSFWorkbook(inputStream);
//
//            Sheet firstSheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = firstSheet.iterator();
//
//            connection = DriverManager.getConnection(jdbcURL, username, password);
//            connection.setAutoCommit(false);
//
//            String sql = "INSERT INTO students (name, enrolled, progress) VALUES (?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            int count = 0;
//
//            rowIterator.next(); // skip the header row
//
//            while (rowIterator.hasNext()) {
//                Row nextRow = rowIterator.next();
//                Iterator<Cell> cellIterator = nextRow.cellIterator();
//                Student st = new Student();
//                while (cellIterator.hasNext()) {
//                    Cell nextCell = cellIterator.next();
//
//                    int columnIndex = nextCell.getColumnIndex();
//                    switch (columnIndex) {
//                        case 0:
//                            String name = nextCell.getStringCellValue();
//                            st.setName(name);
//                            statement.setString(1, name);
//                            System.out.print(name);
//                            break;
//                        case 1:
//                            String enrollDate = nextCell.getStringCellValue();
//                            statement.setString(2, enrollDate);
//                            st.setPro(enrollDate);
//                            System.out.print(enrollDate);
//                            break;
//                        case 2:
//                            String progress = nextCell.getStringCellValue();
//                            statement.setString(3, progress);
//                            st.setSos(progress);
//                            System.out.print(progress);
//                            break;
//
//                    }
//
//                }
//                list.add(st);
//
////            statement.addBatch();
//
//                if (count % batchSize == 0) {
//                    statement.executeBatch();
//                }
//
//            }
//            workbook.close();
//
//            // execute the remaining queries
//            statement.executeBatch();
//
//            connection.commit();
//            connection.close();
//
//            long end = System.currentTimeMillis();
//            System.out.printf("Import done in %d ms\n", (end - start));
//            System.out.print(list.size());
//            System.out.print(list.get(1).getPro());
//            for (int i =0; i< list.size();i++){
//                addone(list.get(i));
//            }
//
//
//        } catch (IOException ex1) {
//            System.out.println("Error reading file");
//            ex1.printStackTrace();
//        } catch (SQLException ex2) {
//            System.out.println("Database error");
//            ex2.printStackTrace();
//        }
//    }
