package com.lear.ui;


import com.lear.service.IAccountService;
import com.lear.service.com.lear.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        as.saveAccount();
//        System.out.println(as);

//        IAccountService as = (IAccountService)ac.getBean("accountService2");
//        as.saveAccount();
//        System.out.println(as);

        IAccountService as = (IAccountService)ac.getBean("accountService3");
        as.saveAccount();
        System.out.println(as);
    }
}
