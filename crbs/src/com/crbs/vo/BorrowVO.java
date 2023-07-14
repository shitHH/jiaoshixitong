package com.crbs.vo;

import java.util.Date;

/**
 * @author 李英
 * @date 2021年3月15日15:52:02
 * @category borrow页面展示
 */
public class BorrowVO {
    /**
     * 借用表编号
     */
    private int bid;
    /**
     * 用户编号
     */
    private int uid;
    /**
     * 用户姓名
     */
    private String uname;
    /**
     * 用户电话（登录账号）
     */
    private String utel;
    /**
     * 教室编号
     */
    private int rid;
    /**
     * 教室名称
     */
    private String rname;
    /**
     * 教室容量
     */
    private String size;
    /**
     * 要借用的开始时间
     */
    private Date starttime;
    /**
     * 借用的归还时间
     */
    private Date endtime;
    /**
     * 借用时间
     */
    private Date inputtime;
    /**
     * 教室的状态
     */
    private String status;
    //构造器
    public BorrowVO(int bid, int uid, String uname, String utel, int rid, String rname, String size, Date starttime, Date endtime, Date inputtime, String status) {
        this.bid = bid;
        this.uid = uid;
        this.uname = uname;
        this.utel = utel;
        this.rid = rid;
        this.rname = rname;
        this.size = size;
        this.starttime = starttime;
        this.endtime = endtime;
        this.inputtime = inputtime;
        this.status = status;
    }

    public BorrowVO(int bid, int uid, String uname, String utel, String rname, String size, Date starttime, Date endtime, Date inputtime, String status) {
        this.bid = bid;
        this.uid = uid;
        this.uname = uname;
        this.utel = utel;
        this.rname = rname;
        this.size = size;
        this.starttime = starttime;
        this.endtime = endtime;
        this.inputtime = inputtime;
        this.status = status;
    }

    public BorrowVO() {
    }
    //get和set方法
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
