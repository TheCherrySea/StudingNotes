package com.sakura.service.user;

import com.sakura.pojo.User;

import java.util.List;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
    //根据用户id修改用户密码

    public Boolean updatePwd(int id, String userPassword);

    public int querryUser(String userName,int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String userName,int userRole,int page,int rows);

    //增加用户信息
    /**
     * 增加用户信息
     * @param user
     * @return
     */
    public boolean add(User user);

    //根据id删除用户信息
    public boolean deleteUserById(Integer id);
}
