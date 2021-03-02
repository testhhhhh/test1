package com.lear.dao;

import com.lear.domain.User;
import com.lear.mybatis.annotations.Select;

import java.util.List;

/**
 * @author 93553
 * 用户的持久层接口
 */
public interface UserDao {

    /**
     * c查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
