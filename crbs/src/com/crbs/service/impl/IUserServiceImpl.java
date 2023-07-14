package com.crbs.service.impl;

import com.crbs.bean.User;
import com.crbs.dao.IUserDao;


import com.crbs.service.IUserService;
import com.crbs.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.util.ArrayList;
import java.util.List;

/**
 * Project：crbs
 * Date：2021/3/12
 * Time：17:50
 * Description：TODO
 *
 * @author 王永祺
 * @version 1.0
 * @category 用户的业务逻辑实现接口
 * @version 2.0
 *  @category 增加模糊查询
 */
public class IUserServiceImpl implements IUserService {
    IUserDao iUserDao = SqlSessionUtil.getSqlSession().getMapper(IUserDao.class);


    @Override
    public List<User> findAllUser() {
        return iUserDao.findAllUser();
    }

    @Override
    public User findUserBytp(String utel, String upass) {
        return iUserDao.findUserBytp(utel, upass);
    }




//改成集合未修复
    @Override
    public User findUserByname(String uname) {
        return iUserDao.findUserByname(uname);
    }
    @Override
    public User findUserByuid(int uid) {
        return iUserDao.findUserByuid(uid);
    }
    @Override
    public boolean addUser(User user) {
        return iUserDao.addUser(user) > 0 ? true : false;
    }

    @Override
    public boolean deleteUser(int uid) {
        return iUserDao.deleteUser(uid) > 0 ? true : false;
    }

    @Override
    public boolean updateUser(User user) {
        return iUserDao.updateUser(user) > 0 ? true : false;
    }

    @Override
    public boolean findUserBytel(String utel) {
        User user = iUserDao.findUserBytel(utel);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<User> findUserlistByname(String uname) {
        List<User> list=iUserDao.findUserlistByname(uname);
        return list;
    }

    @Override
    public List<User> findUserBylistuid(int uid) {
        List<User> list=iUserDao.findUserBylistuid(uid);
        return list;
    }
}