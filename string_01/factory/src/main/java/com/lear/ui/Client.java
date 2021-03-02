package com.lear.ui;

import com.lear.factory.BuildFactory;
import com.lear.service.IAccountService;
import com.lear.service.com.lear.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BuildFactory.getBean("accountService");//每次都会调用默认构造函数创建对象
            System.out.println(as);
            as.saveAccount();
        }

    }
}
