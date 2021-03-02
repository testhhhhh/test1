package com.lear.dao;

import com.lear.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 根据id查询用户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
