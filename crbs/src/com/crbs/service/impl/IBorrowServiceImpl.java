package com.crbs.service.impl;

import com.crbs.bean.Borrow;
import com.crbs.dao.IBorrowDao;
import com.crbs.service.IBorrowService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 李英
 * @date 2021年3月13日13:48:02
 * @category borrowservice的实现类
 */
public class IBorrowServiceImpl implements IBorrowService {
    IBorrowDao borrowDao = null;
    public void create(){
    String resource = "configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sessionFactory.openSession(true);
    borrowDao = sqlSession.getMapper(IBorrowDao.class);
    }
    @Override
    public List<Borrow> findAll() {
        create();
        List<Borrow> list = borrowDao.findAll();
        return list;
    }
    @Override
    public boolean update(Borrow borrow) {
        create();
        int i = borrowDao.updateSta(borrow);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean add(Borrow borrow) {
        create();
        int i = borrowDao.add(borrow);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean delete(int bid) {
        create();
        int i = borrowDao.delete(bid);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public List<Borrow> findByUid(int id) {
        create();
        List<Borrow> list = borrowDao.findByUid(id);
        return list;
    }
    @Override
    public List<Borrow> findByRid(int id) {
        create();
        List<Borrow> list = borrowDao.findByRid(id);
        return list;
    }
    @Override
    public List<Borrow> findBySta(String status) {
        create();
        List<Borrow> list = borrowDao.findBySta(status);
        return list;
    }
    @Override
    public boolean updateSta(Borrow borrow) {
        create();
        int i = borrowDao.updateSta(borrow);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Borrow findBorrowByBid(int bid) {
        create();
        Borrow borrow = borrowDao.findBorrowByBid(bid);
        return borrow;
    }
}
