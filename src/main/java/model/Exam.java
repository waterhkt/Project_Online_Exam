package model;

import java.io.Serializable;

public class Exam implements Serializable {
    private int id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String resulte;
    private int code;

    public Exam() {
    }

    public Exam(int id, String a, String b, String c, String d, String resulte, int code) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.resulte = resulte;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getResulte() {
        return resulte;
    }

    public void setResulte(String resulte) {
        this.resulte = resulte;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", resulte='" + resulte + '\'' +
                ", code=" + code +
                '}';
    }
}
