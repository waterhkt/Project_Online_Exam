package Entity;

import Dao.ConnectionDB;
import model.Exam;
import model.Question;
import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuestionEntity {
    //Lấy ra tất cả Khoa trong database
    public static List<Question> getAll() {
        List<Question> re;
        Statement st = null;
        try {
            st = ConnectionDB.connect();
            ResultSet rs = st.executeQuery("SELECT * FROM `question`");
            re = new LinkedList<>();
            while (rs.next()) {

                re.add(new Question(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
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
    public static List<Question> getAllByCode(String code) {
            System.out.print(code +"aaaaaaaaaaaa");
        List<Question> re;
        PreparedStatement ps = null;
        String sql ="";
        try {
            sql ="select * from question q join code c where c.CodeName = q.CodeID";
            ps = ConnectionDB.connect(sql);
//            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            re = new LinkedList<>();
            while (rs.next()) {
                re.add(new Question(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)

                ));
            }
            System.out.println(re.size() + "wwwwwwwwwww");
            rs.close();
            ps.close();
            return re;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();

        }

    }

    public static List<Question> getAllQuestionByCodeID(String code){
        List<Question> re;
        PreparedStatement ps = null;
        String sql ="";
        try {
            sql ="select * from question where CodeID = ? ";
            ps = ConnectionDB.connect(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            re = new LinkedList<Question>();
            while (rs.next()) {
                re.add(new Question(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)

                ));
            }
            Iterator<Question> iterator = re.iterator();
            System.out.println("Các phần tử có trong list là: ");
            while (iterator.hasNext()) {
                System.out.println( iterator.next());
            }
            rs.close();
            ps.close();
            return re;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String code = "123";
        getAllQuestionByCodeID(code);
    }
    public void uploadFile(String link) {
        String excelFilePath ="G:\\AxonActiveProject\\ProjectAxonActive\\"+ link;
        ArrayList<Question> list = new ArrayList<Question>();
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
                Question q = new Question();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {

                        case 0:
                            int code = Integer.parseInt(nextCell.getStringCellValue());
                            q.setCode(code);

                            break;
                        case 1:
                            String content = nextCell.getStringCellValue();
                            q.setContent(content);

                            break;
                        case 2:
                            String a = nextCell.getStringCellValue();
                            q.setA(a);
                            break;
                        case 3:
                            String b = nextCell.getStringCellValue();
                            q.setB(b);
                            break;
                        case 4:
                            String c = nextCell.getStringCellValue();
                            q.setC(c);
                            break;
                        case 5:
                            String d = nextCell.getStringCellValue();
                            q.setD(d);
                            break;
                        case 6:
                            String result  = nextCell.getStringCellValue();
                            q.setResukt(result);
                            break;


                    }

                }
                list.add(q);
            }

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            System.out.print(list.size());
            for (int i =0; i< list.size();i++){
                list.get(i).setNumber(i+1);
                addone(list.get(i));
            }


        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        }
    }
    // Thêm 1 cau hoi vào database
    public static int addone(Question q){
        PreparedStatement pre = null;
        try {
            String sql ="insert into question (QuestionID,CodeID,QuestionNumber,Content,AnswerA,AnswerB,AnswerC,AnswerD,TrueAnswer) values (?,?,?,?,?,?,?,?,?)" ;
            pre= ConnectionDB.connect(sql);
            pre.setInt(1,q.getId());
            pre.setInt(2,q.getCode());
            pre.setInt(3,q.getNumber());
            pre.setString(4,q.getContent());
            pre.setString(5,q.getA());
            pre.setString(6,q.getB());
            pre.setString(7,q.getC());
            pre.setString(8,q.getD());
            pre.setString(9,q.getResukt());
            pre.executeUpdate();

            return 0;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public static int maxMaCauHoi() {
        PreparedStatement st = null;
        int count =0;
        try {
            String sql = "select max(QuestionID) from question  ";
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
    public static boolean checkResult(int code ,String a) {
        Question q = getQuestionByCode(code);
            if(q.getResukt().equals(a))
                return true;
        return false;
    }
    public static void deleteQuestion(int id){
        PreparedStatement ps =null ;
        try {
            String sql = "Delete From question where QuestionID =?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1,id);

            ps.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // get question by code
    public static Question getQuestionByCode(int codeId) {
        Question q ;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "select * from question where CodeID = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, codeId);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            q = new Question();
            while (rs.next()) {
                int id= rs.getInt(1);
                int code= rs.getInt(2);
                int number= rs.getInt(3);
                String content =rs.getString(4);
                String a =rs.getString(5);
                String b = rs.getString(6);
                String c =rs.getString(7);
                String d = rs.getString(8);
                String result = rs.getString(9);

                q= new Question(id,code,number,content,a,b,c,d,result);
            }
            rs.close();
            ps.close();
            return q;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }

    }
    // get question by id
    public static Question getQuestionById(int idQ) {
        Question q ;
        Connection con=null;
        PreparedStatement ps = null;
        try {
            String sql = "select * from question where QuestionID = ?";
            ps = ConnectionDB.connect(sql);
            ps.setInt(1, idQ);
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            q = new Question();
            while (rs.next()) {
                int id= rs.getInt(1);
                int code= rs.getInt(2);
                int number= rs.getInt(3);
                String content =rs.getString(4);
                String a =rs.getString(5);
                String b = rs.getString(6);
                String c =rs.getString(7);
                String d = rs.getString(8);
                String result = rs.getString(9);

                q= new Question(id,code,number,content,a,b,c,d,result);
            }
            rs.close();
            ps.close();
            return q;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }

    }
    //Chỉnh sữa thông tin question
    public static int update(Question q){
        Connection con;
        PreparedStatement pre = null;
        try {

            String sql ="update question set CodeID=?,QuestionNumber=?,Content=?,AnswerA=?,AnswerB=? ,AnswerC=? ,AnswerD=? ,TrueAnswer=?   where QuestionID = ?" ;
            pre= ConnectionDB.connectupdate(sql);
            pre.setInt(1,q.getCode());
            pre.setInt(2,q.getNumber());
            pre.setString(3,q.getContent());
            pre.setString(4,q.getA());
            pre.setString(5,q.getB());
            pre.setString(6,q.getC());
            pre.setString(7,q.getD());
            pre.setString(8,q.getResukt());
            pre.setInt(9,q.getId());


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
}

