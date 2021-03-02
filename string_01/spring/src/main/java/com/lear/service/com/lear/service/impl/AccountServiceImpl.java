package com.lear.service.com.lear.service.impl;

import com.lear.dao.IAccountDao;
import com.lear.dao.impl.AccountDaoImpl;
import com.lear.service.IAccountService;
import org.w3c.dom.ls.LSOutput;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

//    private int i = 1;

    public void saveAccount() {

        accountDao.saveAccount();

    }
}
