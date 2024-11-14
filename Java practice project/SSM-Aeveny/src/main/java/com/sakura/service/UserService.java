package com.sakura.service;

import com.sakura.pojo.User;
import com.sakura.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserService {
    int addUser(User user);
    int deleteUser( int id);
    int updateUser(User user);
    int queryUser( int id);
    public List<User> queryAllUser();

}
