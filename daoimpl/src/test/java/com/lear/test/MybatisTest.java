package com.lear.test;

import com.lear.dao.UserDao;
import com.lear.dao.daoimplment.UserDaoImpl;
import com.lear.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author 93553
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args)throws Exception{
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //4.使用SqlSession创建Dao接口的代理对象
        //5.使用代理对象执行方法
        UserDao userDao=new UserDaoImpl(factory);
        List<User> users =userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        in.close();
    }
}
