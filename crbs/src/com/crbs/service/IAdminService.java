package com.crbs.service;

import com.crbs.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 管理员业务逻辑接口
 * @date 2021/3/12  17:26
 */
public interface IAdminService {
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
     * 添加管理员是否成功
     */
    public boolean addAdmin(Admin admin);

    /**
     * 修改管理员是否成功
     */
    public boolean updateAdmin(Admin admin);

    /**
     * 删除管理员是否成功
     */
    public boolean deleteAdminByAid(int aid);

    /**
     * 是否找到这个账户
     */
    public boolean find(@Param("atel")String atel, @Param("apass")String apass);

    /**
     *  数据库中是否有整个管理员
     */
    public Admin findlogin(@Param("atel")String atel, @Param("apass")String apass);

    /**
     * 添加
     */
    public boolean addadmin(String aname,String asex,int aage,String atel,String apass);

    /**
     * 通过电话查询具体管理员对象
     */
    public Admin selectAdminByAtel(String atel);

}
