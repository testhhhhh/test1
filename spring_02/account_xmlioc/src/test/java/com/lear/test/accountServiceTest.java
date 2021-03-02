package com.lear.test;

import com.lear.domain.Account;
import com.lear.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.Location;
import java.util.List;

/**
 * 使用Junit单元测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class accountServiceTest {

    @Autowired
    private IAccountService as = null;

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
