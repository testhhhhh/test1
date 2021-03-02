package com.lear.dao;

import com.lear.domain.User;

import java.util.List;

/**
 * @author 93553
 * 用户操作接口
 */
public interface UserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);


}
