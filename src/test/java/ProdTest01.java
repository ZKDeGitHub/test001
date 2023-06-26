import com.javasm.listener.DBListener;
import com.javasm.mapper.MenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProdTest01 {

        private SqlSession sqlSession;
        private InputStream inputStream;
        private com.javasm.mapper.MenuMapper MenuMapper;


        // @Test，public，void，无参数列表

        /**
         * 添加@Before注解：
         * 当前测试方法会在所有的测试方法执行之前执行
         */
        @Before
        public void before() throws IOException {
            // 加载MyBatis的核心配置文件
            String resource = "mybatis-config.xml";
            // 把文件读取到了字节输入流
            inputStream = Resources.getResourceAsStream(resource);
            // 获取SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获取SqlSession对象(辅助CRUD操作)
            // 参数设置为true时，增删改操作自动提交，查询忽略
            sqlSession = sqlSessionFactory.openSession(true);
            //获得代理对象 使usermapper和下方配置文件联系在一起
            MenuMapper = sqlSession.getMapper(MenuMapper.class);
            // class com.sun.proxy.$Proxy9
            // System.out.println("==" + userMapper.getClass());
        }

        /**
         * 添加@After注解：
         * 当前测试方法会在所有的测试方法执行之后执行
         */
        @After
        public void after() throws IOException {
            // 资源关闭
            sqlSession.close();
            inputStream.close();
        }



}
