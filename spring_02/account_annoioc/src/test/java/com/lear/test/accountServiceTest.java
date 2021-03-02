package com.lear.test;

import com.lear.domain.Account;
import com.lear.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试我们的配置
 */
public class accountServiceTest {
    private ApplicationContext ac;
    private IAccountService as;
    @Before
    public void Init(){
        ac = new ClassPathXmlApplicationContext("bean.xml");
        as = ac.getBean("accountService",IAccountService.class);
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
