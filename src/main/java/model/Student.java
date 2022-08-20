package model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private int studentId;
    private int subjectId;
    private int codeId;
    private String studentName;
    private String email;
    private String sex;
    private double grade;
    private String rating;

    public Student() {
    }

    public Student(int id, int studentId, int subjectId, int codeId, String studentName, String email, String sex, double grade, String rating) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.codeId = codeId;
        this.studentName = studentName;
        this.email = email;
        this.sex = sex;
        this.grade = grade;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
