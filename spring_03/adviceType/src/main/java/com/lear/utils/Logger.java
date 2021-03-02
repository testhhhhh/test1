package com.lear.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("log类中的printLog方法开始记录日志  beforePrintLog");
    }

    /**
     * 后置通知
     */
    public  void afterReturningPrintLog(){
        System.out.println("log类中的printLog方法开始记录日志   afterReturningPrintLog");
    }
    /**
     * 异常通知
     */
    public  void afterThrowingPrintLog(){
        System.out.println("log类中的printLog方法开始记录日志   afterThrowingPrintLog");
    }
    /**
     * 最终通知
     */
    public  void afterPrintfLog(){
        System.out.println("log类中的printLog方法开始记录日志   afterPrintLog");
    }

    /**
     * 环绕通知
     * 问题：当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，我们的代码中没有
     * 解决：spring框架为我们提供了一个接口：ProceedingJoinPoint,该接口有一个方法proceed（），此方法就相当于明确调用切入点方法
     *  该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的 实现类供我们使用
     *  spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法合适增强的方式
     */
    public Object aroundPrintfLog(ProceedingJoinPoint pjt){
        Object rtValue=null;
        try{
            Object[] args = pjt.getArgs();
            System.out.println("log类中的printLog方法开始记录日志   aroundPrintfLog  前置");
            rtValue = pjt.proceed(args);
            System.out.println("log类中的printLog方法开始记录日志   aroundPrintfLog  后置");
            return rtValue;

        }catch(Throwable t){
            System.out.println("log类中的printLog方法开始记录日志   aroundPrintfLog  异常");
            throw new RuntimeException(t);

        }finally {
            System.out.println("log类中的printLog方法开始记录日志   aroundPrintfLog  最终");
        }

    }
}
