package com.crbs.service.impl;

import com.crbs.bean.Admin;
import com.crbs.dao.IAdminDao;
import com.crbs.service.IAdminService;
import com.crbs.util.SqlSessionUtil;

import java.util.List;

/**
 * @author lixiaobin
 * @version 1.0
 * @category 管理员业务逻辑实现类
 * @date 2021/3/12  17:32
 */
public class IAdminServiceImpl implements IAdminService {
    //创建数据访问对象
    IAdminDao adminDao= SqlSessionUtil.getSqlSession().getMapper(IAdminDao.class);

    @Override
    public List<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    @Override
    public Admin selectAdminByAid(int aid) {
        return adminDao.selectAdminByAid(aid);
    }

    @Override
    public List<Admin> selectAdminlistByAid(int aid) {
        return adminDao.selectAdminlistByAid(aid);
    }

    @Override
    public Admin selectAdminByAname(String aname) {
        return adminDao.selectAdminByAname(aname);
    }

    @Override
    public List<Admin> selectAdminlistByAname(String aname) {
        return adminDao.selectAdminlistByAname(aname);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.addAdmin(admin)>0?true:false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin)>0?true:false;
    }

    @Override
    public boolean deleteAdminByAid(int aid) {
        return adminDao.deleteAdminByAid(aid)>0?true:false;
    }

    @Override
    public boolean find(String atel, String apass) {
        Admin admin=adminDao.find(atel,apass);
        if(admin==null){
            return true;//账户密码不存在，可以添加
        }else{
            return false;//账号密码存在，不可以添加
        }
    }

    @Override
    public Admin findlogin(String atel, String apass) {
        Admin admin=adminDao.find(atel, apass);
        return admin;
    }

    @Override
    public boolean addadmin(String aname, String asex, int aage, String atel, String apass) {
        Admin admin=new Admin(aname,asex,aage,atel,apass);
        int i=adminDao.addAdmin(admin);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Admin selectAdminByAtel(String atel) {
        return adminDao.selectAdminByAtel(atel);
    }
}
