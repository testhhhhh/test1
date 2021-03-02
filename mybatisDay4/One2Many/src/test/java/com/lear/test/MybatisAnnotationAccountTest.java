package com.lear.test;

import com.lear.dao.AccountDao;
import com.lear.dao.UserDao;
import com.lear.domain.Account;
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

public class MybatisAnnotationAccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountdao;
    //    public static void main(String[] args)throws  Exception {//快捷键psvn
    @Before
        public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory =  new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountdao = session.getMapper(AccountDao.class);
        }


    @After
    public void end() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Account> accounts = accountdao.findAll();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

}
