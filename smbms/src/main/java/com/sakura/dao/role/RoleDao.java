package com.sakura.dao.role;

import com.sakura.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {

    //获取角色列表
    public List<Role> getRoleList (Connection conn) throws SQLException;

}
