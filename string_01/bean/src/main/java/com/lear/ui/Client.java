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
        /**
         * main函数是一切应用程序的入口，当main方法结束，当前应用中线程占用的内存全部释放，也包含容器，
         * 如果不手动关闭容器，那么当main函数执行完毕，容器没来得及执行消亡方法就被销毁了
         * 如果要手动调用关闭容器方法，ApplicationContext是父类接口，ClassPathXmlApplicationContext是子类接口实现类
         * ac。close（）是在ClassPathXmlApplicationContext中，
         * 如果这样ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
         * 多态，Java中多态的前提：
         *         A:有继承关系
         *         B:有方法重写（不是必须）
         *         C:有父类引用指向子类对象
         *
         * 多态中成员的访问特点：
         *         A:成员变量：编译看左边，执行看左边。
         *         B:成员方法：编译看左边，执行看右边。
         *所以编译时，系统会查看父类ApplicationContext中有无close方法，无则报错，运行时调用ClassPathXmlApplicationContext子类的方法
         * 但close方法就是在ClassPathXmlApplicationContext里面的，所以
         * ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");这样的编译会报错
         * 所以要改成ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
         */
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as1 = (IAccountService)ac.getBean("accountService");
        IAccountService as2 = (IAccountService)ac.getBean("accountService");
//        as.saveAccount();
        System.out.println(as1);
        System.out.println(as2);

        ac.close();

    }
}
