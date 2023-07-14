package com.crbs.dao;

import com.crbs.bean.Admin;
import com.crbs.bean.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 管理员数据访问接口
 * @date 2021/3/12  14:39
 */
public interface IAdminDao {
    /**
     * 查询所有管理员
     * @return 管理员集合
     */
    public List<Admin> selectAllAdmin();

    /**
     * 根据管理员编号查询具体的管理员对象
     * @param aid 管理员编号
     * @return 具体的管理员对象
     */
    public Admin selectAdminByAid(int aid);

    /**
     * 根据管理员编号模糊查询
     * @param aid 管理员编号
     * @return 管理员集合
     */
    public List<Admin> selectAdminlistByAid(int aid);
    /**
     * 根据管理员姓名查询具体的管理员对象
     * @param aname 管理员姓名
     * @return 具体的管理员对象
     */
    public Admin selectAdminByAname(String aname);

    /**
     * 根据管理员姓名进行模式查询
     * @param aname 管理员姓名
     * @return 管理员集合
     */
    public List<Admin> selectAdminlistByAname(String aname);

    /**
     * 通过电话查询具体的管理员对象
     * @param atel 电话
     * @return 管理员对象
     */
    public Admin selectAdminByAtel(String atel);
    /**
     * 增加新的管理员
     * @param admin 管理员对象
     * @return 受影响的行数
     */
    public int addAdmin(Admin admin);

    /**
     * 更新管理员信息
     * @param admin 管理员对象
     * @return 受影响的行数
     */
    public int updateAdmin(Admin admin);

    /**
     * 根据管理员编号删除管理员
     * @param aid 管理员编号
     * @return 受影响的行数
     */
    public int deleteAdminByAid(int aid);


    /**
     * 根据管理员电话（登录账号）和管理员登录密码判断账号是否存在
     * @param atel 管理员电话（登录账号）
     * @param apass 管理员登录密码
     * @return 管理员对象
     */
    public Admin find(@Param("atel") String atel, @Param("apass") String apass);

}
