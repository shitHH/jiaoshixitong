package com.crbs.service.impl;
import com.crbs.dao.IBorrowVODao;
import com.crbs.service.IBorrowVOservice;
import com.crbs.vo.BorrowVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 李英
 * @date 2021年3月15日16:46:11
 * @category borrowvo 业务逻辑实现
 */
public class IBorrowVOServiceImpl implements IBorrowVOservice {
    IBorrowVODao borrowVODao ;
    protected  void create()  {
        String resource = "configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        borrowVODao = sqlSession.getMapper(IBorrowVODao.class);
    }
    @Override
    public List<BorrowVO> findAll() {
        create();
        List<BorrowVO> list = borrowVODao.findAll();
        return list;
    }
}
