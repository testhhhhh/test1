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
import java.util.ArrayList;
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
    public void MyTest() {
        List<User> users = userdao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
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
     *测试按条件查询
     */
    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setPhone("111");
//        user.setName("111");
        List<User> users = userdao.findUserByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     *测试foreach标签的使用
     */
    @Test
    public void testFindUserInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(7);
        ids.add(16);
        ids.add(19);
        vo.setIds(ids);
        List<User> users = userdao.findUserInIds(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }


}
