package com.crbs.bean;

/**
 * @author  李龙      李英
 * @version 1.0
 * @category 教室实体类       增加了一个tostring的方法
 * @date 2021/3/12  13:50  2021年3月13日11:39:05
 */
public class Room {
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
     * 教室状态
     */
    private String status;
    //构造器

    public Room() {
    }

    public Room(int rid, String rname, String size, String status) {
        this.rid = rid;
        this.rname = rname;
        this.size = size;
        this.status = status;
    }
    //getter和setter方法

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
