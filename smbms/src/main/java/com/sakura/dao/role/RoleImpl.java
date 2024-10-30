package com.sakura.dao.role;

import com.sakura.dao.BaseDao;
import com.sakura.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleImpl implements RoleDao {
    @Override
    public List<Role> getRoleList(Connection conn) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Role> _role = new ArrayList<>();

        if (conn!=null) {
            String   sql="select * from smbms_role ";

            try {
                Object[] params = {};
                rs= BaseDao.execute(conn,pstm,rs,sql,params);
                while (rs.next()) {
                    Role role = new Role();
                        role.setId(rs.getInt("id"));
                        role.setRoleName(rs.getString("roleName"));
                        role.setRoleCode(rs.getString("roleCode"));
                        _role.add(role);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally{
                BaseDao.closeResource(null, pstm, rs);
            }

        }
        return _role;
    }

/*    public List<Role> getRoleList(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList<Role>();
        if(connection != null){
            String sql = "select * from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while(rs.next()){
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null, pstm, rs);
        }

        return roleList;
    }

}*/

    @Test
    public void test(){
        Connection conn = BaseDao.getConnection();
        try {
            List<Role> a=getRoleList(conn);
            for (Role role : a) {
                System.out.println(role.getRoleName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


