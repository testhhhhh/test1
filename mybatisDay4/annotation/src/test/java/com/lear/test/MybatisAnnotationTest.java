package com.lear.test;

import com.lear.dao.UserDao;
import com.lear.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisAnnotationTest {
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
    public void findAllTest(){
        List<User> users = userdao.findAll();
        for (User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void saveUserTest(){
        User u=new User();
        u.setUsername("aaaaa");
        u.setAddress("aaaa");
        u.setSex("s");
        u.setBirthday(new Date());
        userdao.saveUser(u);
    }

    @Test
    public void updateUserTest(){
        User u=new User();
        u.setId(49);
        u.setUsername("aaaaa");
        u.setAddress("aaaa");
        u.setSex("f");
        u.setBirthday(new Date());
        userdao.updateUser(u);
    }

    @Test
    public void deleteUserTest(){
        userdao.deleteUser(49);
    }

    @Test
    public void selectByIdTest(){
        System.out.println(userdao.findById(48));
    }

    @Test
    public void findByNameTest(){
        List<User> users = userdao.findUserByName("%小%");
        for (User u : users){
            System.out.println(u);
        }
    }

    @Test
    public void findTotalTest(){
        System.out.println(userdao.findTotal());
    }


//    }
}
