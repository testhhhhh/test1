import com.lear.dao.BusDao;
import com.lear.domain.Bus;
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

public class BusTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private BusDao busdao;

    /**
     * 测试函数前初始化
     * @throws Exception
     */
    @Before//用于在测试方法执行之前执行
    public void init() throws  Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        busdao = session.getMapper(BusDao.class);
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
        List<Bus> buss = busdao.findAll();
        for (Bus bus : buss) {
            System.out.println(bus);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        Bus bus=new Bus();
        bus.setType("bbb");
        bus.setNumber("12121");
        System.out.println("保存操作之前："+bus);
        busdao.saveBus(bus);
        System.out.println("保存操作之后"+bus);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        Bus bus=new Bus();
        bus.setType("jgfjfj");
        bus.setNumber("12121");
        bus.setBusId(9);
        busdao.updateBus(bus);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        busdao.deleteBus(2);
    }

    /**
     * 测试根据id查询一个用户操作
     */
    @Test
    public void testFindOne() {
        Bus bus=busdao.findById(7);
        System.out.println(bus);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void findByType() {
        List<Bus> buss = busdao.findByType("大型车");
        for (Bus bus : buss) {
            System.out.println(bus);
        }
    }

}
