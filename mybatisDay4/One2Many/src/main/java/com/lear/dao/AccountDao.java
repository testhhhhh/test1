package com.lear.dao;

import com.lear.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，获取每个账户下所属用户的所有信息
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid", one=@One(select="com.lear.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{uid}")
    @ResultMap(value = {"accountMap"})
    List<Account> findAccountByUid(Integer id);
}
