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
     * 保存用户
     */
   void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
   void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

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
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据quervo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
