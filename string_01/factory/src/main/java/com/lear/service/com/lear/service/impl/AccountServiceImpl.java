package com.lear.service.com.lear.service.impl;

import com.lear.dao.IAccountDao;
import com.lear.dao.impl.AccountDaoImpl;
import com.lear.factory.BuildFactory;
import com.lear.service.IAccountService;
import org.w3c.dom.ls.LSOutput;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BuildFactory.getBean("accountDaoo");

//    private int i = 1;

    public void saveAccount() {
        int i=1;
        System.out.println(accountDao);
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
