package model;

import java.io.Serializable;

public class Question implements Serializable {

    private int id;
    private int code;
    private int number;
    private String content;
    private String a;
    private String b;
    private String c;
    private String d;
    private String resukt;

    public Question() {
    }

    public Question(int id, int code, int number, String content, String a, String b, String c, String d, String resukt) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.content = content;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.resukt = resukt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getResukt() {
        return resukt;
    }

    public void setResukt(String resukt) {
        this.resukt = resukt;
    }
}
