package com.lear.service.impl;

import com.lear.Utils.TransactionManager;
import com.lear.dao.IAccountDao;
import com.lear.domain.Account;
import com.lear.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务的控制应该都是在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao) {
//
//        this.accountDao = accountDao;
//    }

    @Override
    public List<Account> findAccount() {
       return accountDao.findAccount();

    }

    @Override
    public Account findAccountById(Integer id) {
        return  accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {
       accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);

    }
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer开始执行");
            //2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);
//            int i=1/0;
            //2.6.更新转入账户
            accountDao.updateAccount(target);





    }
}
