package com.lear.factory;

import com.lear.Utils.TransactionManager;
import com.lear.domain.Account;
import com.lear.service.IAccountService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService){
        this.accountService = accountService;
    }

    /**
     * 获取Service的代理对象
     * @return
     */
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            //1开启事务
                            txManager.beginTransaction();
                            //2执行操作
                            rtValue = method.invoke(accountService,args);
                            //3提交事务
                            txManager.commitTransaction();



                            //4返回结果
                            return rtValue;
                        }catch(Exception e){
                            //回滚操作
                            txManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        }finally {
                            //6释放连接
                            txManager.releaseTransaction();
                        }
                    }
                });
    }
}
