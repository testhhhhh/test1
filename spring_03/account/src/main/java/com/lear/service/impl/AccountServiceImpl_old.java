package com.lear.service.impl;

import com.lear.Utils.TransactionManager;
import com.lear.dao.IAccountDao;
import com.lear.domain.Account;
import com.lear.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务的控制应该都是在业务层
 */
public class AccountServiceImpl_old implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAccount() {
        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作
            List<Account> accounts= accountDao.findAccount();
            //3提交事务
            txManager.commitTransaction();
            //4返回结果
            return accounts;
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作
            Account account= accountDao.findAccountById(id);
            //3提交事务
            txManager.commitTransaction();
            //4返回结果
            return account;
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
            throw new RuntimeException(e);
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作
            accountDao.saveAccount(account);
            //3提交事务
            txManager.commitTransaction();
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }


    }

    @Override
    public void updateAccount(Account account) {
        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作
            accountDao.updateAccount(account);
            //3提交事务
            txManager.commitTransaction();
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }


    }

    @Override
    public void deleteAccount(Integer id) {
        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作
            accountDao.deleteAccount(id);
            //3提交事务
            txManager.commitTransaction();
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }


    }
    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        try{
            //1开启事务
            txManager.beginTransaction();
            //2执行操作


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
            //2.6.更新转入账户
            accountDao.updateAccount(target);

                int i =1/0;

            //3提交事务
            txManager.commitTransaction();
//            //4返回结果
//            return accounts;
        }catch(Exception e){
            //回滚操作
            txManager.rollbackTransaction();
        }finally {
            //6释放连接
            txManager.releaseTransaction();
        }


    }
}
