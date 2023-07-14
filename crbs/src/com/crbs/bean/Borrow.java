package com.crbs.bean;

import java.util.Date;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 借用表实体类
 * @date 2021/3/12  13:50
 */
public class Borrow {
    /**
     * 借用表编号
     */
    private int bid;
    /**
     * 用户编号
     */
    private int uid;
    /**
     * 教室编号
     */
    private int rid;
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

    public Borrow() {
    }

    public Borrow(int bid, int uid, int rid, Date starttime, Date endtime, Date inputtime, String status) {
        this.bid = bid;
        this.uid = uid;
        this.rid = rid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.inputtime = inputtime;
        this.status = status;
    }

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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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
}
