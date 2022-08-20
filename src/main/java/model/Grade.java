package model;

import java.io.Serializable;

public class Grade implements Serializable {
    private int id;
    private int userid;
    private int codeid;
    private int ncorrect;
    private double grade;
    private String stime;
    private String date;

    public Grade() {
    }
    public Grade(int userid, int codeid, int ncorrect, double grade, String stime, String date) {
        this.userid = userid;
        this.codeid = codeid;
        this.ncorrect = ncorrect;
        this.grade = grade;
        this.stime = stime;
        this.date = date;
    }
    public Grade(int id,int userid, int codeid, int ncorrect, double grade, String stime, String date) {
        this.id = id;
        this.userid = userid;
        this.codeid = codeid;
        this.ncorrect = ncorrect;
        this.grade = grade;
        this.stime = stime;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCodeid() {
        return codeid;
    }

    public void setCodeid(int codeid) {
        this.codeid = codeid;
    }

    public int getNcorrect() {
        return ncorrect;
    }

    public void setNcorrect(int ncorrect) {
        this.ncorrect = ncorrect;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
