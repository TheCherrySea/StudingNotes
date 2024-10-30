package com.sakura.service.role;

import com.sakura.dao.BaseDao;
import com.sakura.dao.role.RoleDao;
import com.sakura.dao.role.RoleImpl;
import com.sakura.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    //引入dao
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleImpl();
    }

    @Override
    public List<Role> getRoles() {
        Connection conn = null;
        List<Role> roleList = null;
        conn= BaseDao.getConnection();
        try {
            roleList=roleDao.getRoleList(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(conn,null,null);
        }

        return roleList;
    }

    @Test
    public void insertRole() {
        RoleServiceImpl roleService = new RoleServiceImpl();
       List<Role> a= roleService.getRoles();
        for (Role role : a) {
            System.out.println(role.getRoleName());
        }
    }

}
