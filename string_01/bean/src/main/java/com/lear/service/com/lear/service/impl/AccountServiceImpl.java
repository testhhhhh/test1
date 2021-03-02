package com.lear.service.com.lear.service.impl;


import com.lear.service.IAccountService;
import org.w3c.dom.ls.LSOutput;

/**
 * 账户的业务层实现类
 */
public  class  AccountServiceImpl implements IAccountService {


    public  AccountServiceImpl()
    {
        System.out.println("对象创建了");
    }

//    private int i = 1;

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("出生");
    }
    public void destory(){
        System.out.println("消亡");
    }
}
