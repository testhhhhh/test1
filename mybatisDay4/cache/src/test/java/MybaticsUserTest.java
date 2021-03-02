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
import java.util.List;

public class MybaticsUserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userdao;

    /**
     * 测试函数前初始化
     * @throws Exception
     */
    @Before//用于在测试方法执行之前执行
    public void init() throws  Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
//        session = factory.openSession();
        session = factory.openSession(true);//设置自动提交事务
        userdao = session.getMapper(UserDao.class);
    }

    /**
     * 测试函数执行后提交事务，释放资源
     * @throws Exception
     */
    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        //提交事务
//        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
    /**
     * 测试查询所有操作
     */
    @Test
    public void testFirstLevelCache() {
        User user1 = userdao.findById(41);
        System.out.println(user1);
//       session.close();
//       session=factory.openSession();
//        userdao = session.getMapper(UserDao.class);

        session.clearCache();//此方法也可以清空缓存
        User user2 = userdao.findById(41);
        System.out.println(user2);

    }


    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache() {
        //1.根据id查询用户
        User user1 = userdao.findById(41);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("updateeeee");
        user1.setAddress("asjfkahdfkh");
        //3.再次查询id为41的用户
        userdao.updateUser(user1);
//       session.close();
//       session=factory.openSession();
//        userdao = session.getMapper(UserDao.class);

       // session.clearCache();//此方法也可以清空缓存
        User user2 = userdao.findById(41);
        System.out.println(user2);

    }




}
