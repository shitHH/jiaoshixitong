package com.crbs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: wangjuyuan
 * @Date: Created in 09:49 2021-03-10
 * @Description: 获得sqlsession 会话对象 工具类
 * @Version: 1.0
 */
public class SqlSessionUtil {

    /**
     * 获得sqlsession会话对象
     * @return
     */
    public static SqlSession getSqlSession(){
        // 声明会话对象
        SqlSession sqlSession = null;
        try {
            // 存储配置文件路径
            String resource = "configuration.xml";
            // 获得输入流对象
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 获得会话工厂对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获得会话对象
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }
}
