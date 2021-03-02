package com.lear.test;

import com.lear.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop的配置
 */
public class AopTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ap = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService accountService = ap.getBean("accountService",IAccountService.class);
        //3.执行方法
        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deleteAccount();

    }
}
