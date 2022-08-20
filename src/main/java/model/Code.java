package model;

import java.io.Serializable;

public class Code implements Serializable {
    private int id;
    private String name;
    private int subid;
    private int userid;
    private String des;
    private int qua;
    private int time;

    public Code() {
    }

    public Code(int id, String name, int subid, int userid, String des, int qua, int time) {
        this.id = id;
        this.name = name;
        this.subid = subid;
        this.userid = userid;
        this.des = des;
        this.qua = qua;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
