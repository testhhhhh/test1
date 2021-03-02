package com.lear.dao;

import com.lear.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

/**
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select(value="select * from user")
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select="com.lear.dao.AccountDao.findAccountByUid",fetchType= FetchType.LAZY))

    })
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    @ResultMap(value={"userMap"})
    User findById(Integer id);

    @Select("select * from user where username like #{username}")
    @ResultMap(value={"userMap"})
    List<User> findUserByName(String username);

}
