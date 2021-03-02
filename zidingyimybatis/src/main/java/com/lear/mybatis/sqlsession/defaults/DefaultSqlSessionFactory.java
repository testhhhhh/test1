package com.lear.mybatis.sqlsession.defaults;

import com.lear.mybatis.cfg.Configuration;
import com.lear.mybatis.sqlsession.SqlSession;
import com.lear.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author 93553
 * SqlSessionFactory接口实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public  DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
