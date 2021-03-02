import com.lear.dao.RoleDao;
import com.lear.dao.UserDao;
import com.lear.domain.Role;
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
    public void testFindAll() {
        List<User> users = userdao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }







}
