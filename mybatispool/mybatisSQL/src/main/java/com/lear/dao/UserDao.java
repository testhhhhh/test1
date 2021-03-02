package com.lear.dao;

import com.lear.domain.QueryVo;
import com.lear.domain.User;

import javax.management.Query;
import java.util.List;

/**
 * @author 93553
 * 用户操作接口
 */
public interface UserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名字模糊查询用户
     * @param name
     * @return
     */
    List<User> findByName(String name);



    /**
     * 根据quervo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件，user信息不全，可能全没有，也可能全有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合，查询用户ID信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
