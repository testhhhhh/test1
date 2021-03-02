package com.lear.ui;

import com.lear.dao.IAccountDao;
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
     * 获取spring的ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext  它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了   （常用
     *      FileSystemXmlApplicationContext  它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext  它适用于读取注解创建容器的
     *
     *  核心容器的两个接口引发出的问题
     *  ApplicationContext:  单例   （常用
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说一读取完配置文件马上创建配置文件中配置的对象
     *
     *  BeanFactory:   多例
     *      它在创建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说什么时候根据id获取对象了什么时候在真正的创建对象
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao ad = ac.getBean("accountDao",IAccountDao.class);
        as.saveAccount();

        System.out.println(as);
        System.out.println(ad);


//        //-------------------BeanFactory----------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory bf = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)bf.getBean("accountService");
//        System.out.println(as);

    }
}
