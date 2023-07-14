package com.crbs.dao;

import com.crbs.bean.Room;
import com.crbs.bean.User;

import java.util.List;

/**
 * Project：crbs
 * Date：2021/3/12
 * Time：14:38
 * Description：TODO
 * @author 王永祺
 * @version 1.0
 * @category user的数据访问接口
 * @version 2.0
 * @category 增加模糊查询
 */
public interface IUserDao {
    /**
     * 查询所有的用户列表
     * @return 用户列表
     */
    public List<User> findAllUser();

    /**
     * 用户根据手机号和密码查询用户
     * @param utel 手机号
     * @param upass 密码
     * @return 用户个体
     */
    public User findUserBytp(String utel,String upass);

    /**
     * 通过姓名查询用户个体
     * @return 用户个体
     */
    public User findUserByname(String uname);
    /**
     * 通过uid查询用户个体
     * @return 用户个体
     */
    public User findUserByuid(int uid);
    /**
     * 通过用户个体信息增加用户
     * @param user 用户个体
     * @return 受影响行数
     */
    public int addUser(User user);

    /**
     * 根据uid删除用户信息
     * @param uid uid
     * @return 受影响行数
     */
    public int deleteUser(int uid);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 用户信息
     */
    public int updateUser(User user);

    /**
     * 通过手机号查询用户名是否重复
     * @param utel 手机号
     * @return
     */
    public User findUserBytel(String utel);
    /**
     * 通过姓名模糊查询用户集合
     * @return 用户个体
     */
    public List<User> findUserlistByname(String uname);
    /**
     * 通过uid模糊查询用户集合
     * @return 用户集合
     */
    public List<User> findUserBylistuid(int uid);
}
