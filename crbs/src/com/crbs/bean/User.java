package com.crbs.bean;

/**
 * @author lixiaobin 李英
 * @version 1.0
 * @category 用户实体类      增加了一个tostring的方法
 * @date 2021/3/12  13:50  2021年3月13日11:38:36
 */
public class User {
    /**
     * 用户编号
     */
    private int uid;
    /**
     * 用户姓名
     */
    private String uname;
    /**
     * 用户性别
     */
    private String usex;
    /**
     * 用户年龄
     */
    private int uage;
    /**
     * 用户电话（登录账号）
     */
    private String utel;
    /**
     * 用户登录密码
     */
    private String upass;
    //构造器

    public User() {
    }

    public User(int uid, String uname, String usex, int uage, String utel, String upass) {
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
        this.uage = uage;
        this.utel = utel;
        this.upass = upass;
    }
    //getter和setter方法

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                ", uage=" + uage +
                ", utel='" + utel + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }
}
