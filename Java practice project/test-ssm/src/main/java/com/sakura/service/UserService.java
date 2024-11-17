package com.sakura.service;

import com.sakura.pojo.User;
import com.sakura.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserService {
    int addUser(User user);
    int deleteUser( int id);
    int updateUser(User user);
    User queryUser(@Param("id") int id);
    public List<User> queryAllUser();
    List<User> queryUserByUsername(@Param("username") String username);

}
