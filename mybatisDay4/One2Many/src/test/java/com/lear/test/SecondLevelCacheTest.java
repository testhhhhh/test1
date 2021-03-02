package com.lear.test;

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

public class SecondLevelCacheTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;
    UserDao userdao;
    //    public static void main(String[] args)throws  Exception {//快捷键psvn
    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory =  new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userdao = session.getMapper(UserDao.class);
    }


    @After
    public void end() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void selectByIdTest(){
        User u1=userdao.findById(48);
        System.out.println(u1);

       session.close();
        session=factory.openSession();
        userdao=session.getMapper(UserDao.class);
        User u2=userdao.findById(48);
        System.out.println(u2);
    }
}
