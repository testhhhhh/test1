package com.lear.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否单例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取queryrunner对象
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner1==runner2);
    }
}
