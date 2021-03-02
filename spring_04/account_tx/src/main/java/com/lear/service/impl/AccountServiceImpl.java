package com.lear.service.impl;

import com.lear.dao.IAccountDao;
import com.lear.domain.Account;
import com.lear.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务的控制应该都是在业务层
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Account findAccountById(Integer id) {
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            @Override
            public Account doInTransaction(TransactionStatus transactionStatus) {
                return accountDao.findAccountById(id);
            }
        });
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
//                int i=1/0;
                //2.6.更新转入账户
                accountDao.updateAccount(target);


                return null;
            }
        });




    }
}
