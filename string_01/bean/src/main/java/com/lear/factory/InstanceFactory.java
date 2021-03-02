package com.lear.factory;

import com.lear.service.IAccountService;
import com.lear.service.com.lear.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类 ，该类可能存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数
 */
public class InstanceFactory {
    public IAccountService getAccountService(){
//        public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
