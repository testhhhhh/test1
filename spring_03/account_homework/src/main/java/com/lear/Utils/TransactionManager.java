package com.lear.Utils;

import com.lear.domain.Account;
import com.lear.service.IAccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务，释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

//    public void setConnectionUtils(ConnectionUtils connectionUtils) {
//        this.connectionUtils = connectionUtils;
//    }
//
//    public void setAccountService(IAccountService accountService) {
//        this.accountService = accountService;
//    }

   @Pointcut("execution(* com.lear.service.impl.AccountServiceImpl.*(..))")
    private void mt(){}

    /**
     * 开启事务
     */
//    @Before("mt()")
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 提交事务
     */
//    @AfterReturning("mt()")
    public void commitTransaction(){
        try{
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
//    @AfterThrowing("mt()")
    public void rollbackTransaction(){
        try{
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 释放事务
     */
//    @After("mt()")
    public  void releaseTransaction(){
        try{
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
            System.out.println("释放事务");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Around("mt()")
    public Object round(ProceedingJoinPoint pjt) throws SQLException {
        Object rtValue=null;
        try{
            //1开启事务
            this.beginTransaction();
            //2执行操作
            Object[] args=pjt.getArgs();
            rtValue = pjt.proceed(args);
//            int i =1/0;
            //3提交事务
           this.commitTransaction();
//            //4返回结果
            return rtValue;
        }catch(Throwable e){
            //回滚操作
            this.rollbackTransaction();
            throw  new RuntimeException(e);
        }finally {
           this.releaseTransaction();
        }
    }
}
