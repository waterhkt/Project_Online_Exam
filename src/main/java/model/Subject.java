package model;

import java.io.Serializable;

public class Subject implements Serializable {
    private String ma;
    private String name;
    private String tc;

    public Subject() {
    }

    public Subject(String ma, String name, String tc) {
        this.ma = ma;
        this.name = name;
        this.tc = tc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "ma='" + ma + '\'' +
                ", name='" + name + '\'' +
                ", tc='" + tc + '\'' +
                '}';
    }
}
