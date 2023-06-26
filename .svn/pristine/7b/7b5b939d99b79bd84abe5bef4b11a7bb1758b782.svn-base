package com.javasm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 单例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 获取SqlSession对象
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession() {
        // 设置参数为true，执行增删改操作时自动进行事务的提交操作
        return sqlSessionFactory.openSession(true);
    }

    /**
     * 获取SqlSession对象
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSessionNoCommit() {
        // 事务不会自动提交
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }


}
