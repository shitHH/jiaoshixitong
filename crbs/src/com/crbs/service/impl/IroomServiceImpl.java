package com.crbs.service.impl;

import com.crbs.bean.Room;
import com.crbs.dao.IroomDao;
import com.crbs.service.IroomService;
import com.crbs.util.SqlSessionUtil;


import java.util.List;

/**
 * @author lilong
 * @version 1.0
 * @#category 教室业务逻辑实现类
 * @date 2021-03-12 16:53
 */
public class IroomServiceImpl implements IroomService {
    IroomDao roomDao= SqlSessionUtil.getSqlSession().getMapper(IroomDao.class);
    @Override
    public List<Room> findAll() {
        List<Room>room=roomDao.findAll();
        return room;
    }

    @Override
    public List<Room> findBystatus(String status) {
        List<Room> room=roomDao.findBystatus(status);
        return room;
    }

    @Override
    public List<Room> findBySize(String size) {
        List<Room> room=roomDao.findBySize(size);
        return room;
    }

    @Override
    public Room findByrname(String rname) {
        Room room=roomDao.findByrname(rname);
        return room;
    }

    @Override
    public Room findByrid(int rid) {
        Room room=roomDao.findByrid(rid);
        return room;
    }

    @Override
    public int update(Room room) {
      int i=roomDao.update(room);

        return i;
    }

    @Override
    public List<Room> queryByTrim(Room room) {
     List<Room>rooms =roomDao.queryByTrim(room);
        return rooms;
    }

    @Override
    public Boolean deleteRoom(Room room) {
        Boolean flag=roomDao.deleteRoom(room);
        return flag;
    }

    @Override
    public int insertRoom(Room room) {
       int i=roomDao.insertRoom(room);
        return i;
    }
}
