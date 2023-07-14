package com.crbs.bean;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 管理员实体类
 * @date 2021/3/12  13:50
 */
public class Admin {
    /**
     * 管理员编号
     */
    private int aid;
    /**
     * 管理员姓名
     */
    private String aname;
    /**
     * 管理员性别
     */
    private String asex;
    /**
     * 管理员年龄
     */
    private int aage;
    /**
     * 管理员电话（登录账号）
     */
    private String atel;
    /**
     * 管理员登录密码
     */
    private String apass;
    //构造器

    public Admin() {
    }

    public Admin(String aname, String asex, int aage, String atel, String apass) {
        this.aname = aname;
        this.asex = asex;
        this.aage = aage;
        this.atel = atel;
        this.apass = apass;
    }

    //getter和setter方法

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsex() {
        return asex;
    }

    public void setAsex(String asex) {
        this.asex = asex;
    }

    public int getAage() {
        return aage;
    }

    public void setAage(int aage) {
        this.aage = aage;
    }

    public String getAtel() {
        return atel;
    }

    public void setAtel(String atel) {
        this.atel = atel;
    }

    public String getApass() {
        return apass;
    }

    public void setApass(String apass) {
        this.apass = apass;
    }
}
