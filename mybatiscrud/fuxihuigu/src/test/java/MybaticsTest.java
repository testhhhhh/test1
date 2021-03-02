import com.lear.dao.UserDao;
import com.lear.domain.QueryVo;
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

public class MybaticsTest {
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
        session = factory.openSession();
        userdao = session.getMapper(UserDao.class);
    }

    /**
     * 测试函数执行后提交事务，释放资源
     * @throws Exception
     */
    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
    /**
     * 测试查询所有操作
     */
    @Test
    public void MyTest() {
        List<User> users = userdao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user=new User();
        user.setPhone("111");
        user.setPassword("111");
        user.setIdentitycard("111");
        user.setName("111");
        System.out.println("保存操作之前："+user);
        userdao.saveUser(user);
        System.out.println("保存操作之后"+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user=new User();
        user.setPhone("111");
        user.setPassword("111");
        user.setIdentitycard("111");
        user.setName("111");
        user.setUserid(7);
        userdao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        userdao.deleteUser(14);
    }

    /**
     * 测试根据id查询一个用户操作
     */
    @Test
    public void testFindOne() {
        User user=userdao.findById(7);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void findByName() {
        //List<User> users = userdao.findByName("复");//用statement用的，即用'%${value}%'
        List<User> users = userdao.findByName("%复%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据查询总记录条数
     */
    @Test
    public void testFindTotal() {
        System.out.println( userdao.findTotal());
    }


}
