package com.lear.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 93553
 * 查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)//改变注解的生命周期
@Target(ElementType.METHOD)//改变注解出现的位置
public @interface Select {

    /**
     * 配置sql语句的
     * @return
     */
    String value();
}
