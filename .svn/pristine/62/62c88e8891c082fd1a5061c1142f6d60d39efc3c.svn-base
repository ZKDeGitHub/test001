package com.javasm.listener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
@WebListener
public class DBListener implements ServletContextListener {
    //使用监听器达成 每当服务器启动时SqlSessionUtils的单例模式都启动
    //首先创建工厂对象
    static SqlSessionFactory sqlSessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("DBListener的contextInitialized执行了+++++++");
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
    public static SqlSession getSqlSession() {
        // 设置参数为true，执行增删改操作时自动进行事务的提交操作
        return sqlSessionFactory.openSession(true);
    }
    public static SqlSession getSqlSessionNoCommit() {
        // 事务不会自动提交
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
