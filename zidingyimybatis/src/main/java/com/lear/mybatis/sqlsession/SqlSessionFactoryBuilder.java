package com.lear.mybatis.sqlsession;

import com.lear.mybatis.cfg.Configuration;
import com.lear.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.lear.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author 93553
 * 用于创建一个SqlSessionFactoryBuilder对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
