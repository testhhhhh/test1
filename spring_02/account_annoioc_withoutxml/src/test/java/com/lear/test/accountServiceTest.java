package com.lear.test;

import com.lear.domain.Account;
import com.lear.service.IAccountService;
import config.JDBCConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试我们的配置
 * Spring整合Junit的配置
 *      1.导入spring整合Junit的jar包（坐标）
 *      2.使用Junit提供的一个注解把原有的main方法换了，替换成spring提供的
 *          @Runwith
 *      3.告知spring运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration:
 *              locations:指定xml文件的位置，加上classpath关键字表示在类路径下
 *              classes:指定注解类所在的位置
 *      当我们使用spring 5.x版本的时候，要求JUNIT 的jar包必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class accountServiceTest {
//    private ApplicationContext ac;
    @Autowired
    private IAccountService as = null;
    @Before
    public void Init(){
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JDBCConfig.class);
//        as = ac.getBean("accountService",IAccountService.class);
    }
    @Test
    public void testFindAll() {
        List<Account> accounts = as.findAccount();
        for(Account a : accounts){
            System.out.println(a);
        }
    }
    @Test
    public void testFindOne() {
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account = as.findAccountById(4);
        account.setName("asdasdasd");
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }

}
