package com.lear.service.com.lear.service.impl;

import com.lear.dao.IAccountDao;

import com.lear.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.sql.RowId;

/**
 * 账户的业务层实现类
 *
 * 曾经xml的配置：
 *  <bean id="accountService" class="com.lear.service.com.lear.service.impl.AccountServiceImpl"  scope=“” init-method=“” destroy-method=“” >
 *      <property  name="" value=""/ref=""></property>
 *
 *  </bean>
 *
 *
 *  用于创建对象的注解
 *      他们的作用就和xml配置文件中编写一个bean标签<bean></bean>实现的功能是一样的
 *      Component：
 *          作用:用于把当前类对象存入spring容器中
 *          属性:   value:用于指定bean的id，当不写时它的默认值是当前类名且首字母改小写
 *      Controller：一般用于表现层
 *      Service：一般用在业务层
 *      Repository：一般用于持久层
 *      以上三个注解他们的作用和属性与Component是一模一样的：
 *          他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *  用于注入数据的注解
 *      他们的作用就和在xml配置温江中的<bean></bean>中写一个property标签的作用是一样的
 *      Autowired:
 *          作用:自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *              如果ioc容器中有多个类型匹配时，会根据数据类型找到这多个类型，然后根据变量名从在这几个类型中找出那一个相同的，没有就报错
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：在使用注解注入时，set方法就不是必须的了
 *      Qualifier:
 *          作用：在按照类型中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *          属性：value  用于指定注入bean的id
 *      Resource:
 *          作用：直接按照bean的id注入，它可以独立使用
 *          属性：name   用于指定bean的id
 *      以上三种注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *      另外集合类型的注入只能通过xml来实现
 *
 *      Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：value  用于指定数据的值，它可以使用spring中的SpEL（也就是spring的el表达式）
 *                  SpEL的写法：${表达式}
 *  用于改变作用范围的注解
 *      他的作用是就和在bean标签中使用scope属性实现的功能是一样的
 *      Scope：
 *          作用：用于指定bean的作用范围
 *          属性;value  指定范围的取值，常用取值：singleton （单例）  prototype  （多例）
 *  和生命周期相关的注解
 *      他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */

@Service(value = "accountServiceImpl")//如果一个注解中只有有一个属性且属性名为value时，可以省略写属性名称，如果同时有两个属性则value这个属性名必须要写
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier(value = "accountDao2")
      @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

//    private int i = 1;

    public void saveAccount() {

        accountDao.saveAccount();

    }
    @PostConstruct
    public void  init(){
        System.out.println("出生");
    }
    @PreDestroy
    public  void destroy(){
        System.out.println("死亡");
    }
}
