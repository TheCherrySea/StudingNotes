package com.sakura.dao.user;

import com.sakura.pojo.Role;
import com.sakura.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到要登陆的用户
    public User login(String useCode, Connection conn) throws SQLException;

    //根据id修改用户密码
    public int updateUserPwd(Connection conn, int id, String userPassword) throws SQLException;

    //查询用户总数
    public int getUserCount(Connection conn, String userName, int useRole) throws SQLException;

    //根据用户名或者角色查询用户列表
    public List<User> getUserList(Connection conn, String userName, int userRole, int currentPage, int pageSize) throws SQLException;

    //添加用户
    public int add(Connection connection, User user) throws Exception;

    //通过用户id删除用户信息
    public Boolean deleteUser(Connection connection, Integer id) throws Exception;
}
