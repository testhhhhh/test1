package com.lear.mybatis.sqlsession.defaults;

import com.lear.mybatis.cfg.Configuration;
import com.lear.mybatis.sqlsession.SqlSession;
import com.lear.mybatis.sqlsession.proxy.MapperProxy;
import com.lear.mybatis.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public  DefaultSqlSession(Configuration cfg){
        this.cfg=cfg;
        connection= DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象 动态代理
     * @param daoInterFaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterFaceClass) {

        //创建一个代理对象Proxy，代理对象的每个被调用了的要执行的方法都会替换执行Invocation中的invoke方法，即
        //MapperProxy(cfg.getMappers())里面的invoke方法
        return (T) Proxy.newProxyInstance(daoInterFaceClass.getClassLoader(),
                new Class[]{daoInterFaceClass},new MapperProxy(cfg.getMappers(),connection));

    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(connection!=null){
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
