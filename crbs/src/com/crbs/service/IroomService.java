package com.crbs.service;

import com.crbs.bean.Room;

import java.util.List;

/**
 * @author lilong
 * @version 1.0
 * @#category 教室数据访问接口
 * @date 2021-03-12 14:28
 */
public interface IroomService {
    /**
     * 查询所有教室
     * @return 教室集合
     */
    public List<Room> findAll();

    /**
     *  根据教室状态查询教室集合
   //  * @param status 教室状态
     * * @return 教室的集合
     */
    public List<Room> findBystatus(String status);

    /**
     * 根据教室的规模查询教室
     * @param size 教室规模
     * @return 教室集合
     */
    public List<Room> findBySize(String size);

    /**
     * 根据教室名查找教室
     *
     * @return 教室对象
     */
    public Room findByrname(String rname);

    /**
     * 根据教室编号查找教室
     *
     * @return 教室对象
     */
    public Room findByrid(int rid);
//
//    /**
//     * @param classroom 教室对象
//     * @return 受影响的行数
//    */
   public int  update(Room room);

    /**
     * 多条件查询
     */
    public List<Room> queryByTrim(Room room);

    /**
     *  删除教室
     * @param room
     * @return true或false
     */
    public Boolean deleteRoom(Room room);


    /**
     * 增加教室
     */
  public int insertRoom(Room room);

}
