package com.lear.dao;

import com.lear.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户,同时还要获取当前账户所属的用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountById(Integer uid);
}
