package com.lear.mybatis.sqlsession;

/**
 * @author 93553
 * 自定义mybatis中和数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterFaceClass dao的接口字节码
     * @param <T>
     * @return
     */
   <T> T getMapper(Class<T> daoInterFaceClass);

    /**
     * 释放资源
     */
   void close();
}
