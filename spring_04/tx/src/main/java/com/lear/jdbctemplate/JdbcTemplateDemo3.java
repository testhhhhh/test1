package com.lear.jdbctemplate;

import com.lear.dao.IAccountDao;
import com.lear.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jdbctemplate的最crud用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao",IAccountDao.class);
        Account account = accountDao.findAccountById(10);
        System.out.println(account);
        account.setMoney(30000f);
        accountDao.updateAccount(account);
    }
}