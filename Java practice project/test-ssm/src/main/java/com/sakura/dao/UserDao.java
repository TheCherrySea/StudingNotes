package com.sakura.dao;

import com.sakura.pojo.Account;
import com.sakura.pojo.User;
import com.sakura.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int addUser(User user);
    int deleteUser(@Param("id") int id);
    int updateUser(User user);
    User queryUser(@Param("id") int id);
     List<User> queryAllUser();
    List<User> queryUserByName(String username);

}
