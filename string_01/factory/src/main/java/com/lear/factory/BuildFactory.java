package com.lear.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean，计算机英语中又可重用组件的含义
 * JavaBean，用java语言编写的可重用组件
 *          Javabean > 实体类
 *
 *  它就是创建我们的service，dao对象的
 *
 *  第一个：需要一个配置文件来配置我们的service和dao
 *          配置文件的内容：唯一标志=全限定类名 （key=value）
 *  第二个：通过读取配置文件中配置的内容，反射创建bean对象
 *
 *  我们的配置文件可以是xml也可以是properties
 */
public class BuildFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个map，用于存放我们要创建的对象，我们把它称为容器
    private static Map<String,Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try{
        //实例化对象
        props = new Properties();
        //获取properties文件的流对象
        InputStream in = BuildFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        props.load(in);
        //实例化容器
        beans = new HashMap<String,Object>();
        //取出配置文件中所有的key
        Enumeration keys = props.keys();
        //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).getConstructor().newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String  beanName){
        return beans.get(beanName);
    }
//    /**
//     * 根据bean的名称获取bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
