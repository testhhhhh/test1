import com.lear.dao.UserDao;
import com.lear.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;


    /**
     * 测试函数前初始化
     * @throws Exception
     */
    @Before//用于在测试方法执行之前执行
    public void init() throws  Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
//        session = factory.openSession();

    }

    /**
     * 测试函数执行后提交事务，释放资源
     * @throws Exception
     */
    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{

        in.close();
    }
    /**
     * 测试查询所有操作
     */
    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession1=factory.openSession();
        UserDao dao1=sqlSession1.getMapper(UserDao.class);
        User user1 =dao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();

        SqlSession sqlSession2=factory.openSession();
        UserDao dao2=sqlSession2.getMapper(UserDao.class);
        User user2 =dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

    }




}
