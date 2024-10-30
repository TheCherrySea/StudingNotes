package com.sakura.dao.user;

import com.mysql.cj.util.StringUtils;
import com.sakura.dao.BaseDao;
import com.sakura.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDao{
    @Override
    public User login(String useCode, Connection conn){
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        if (conn!=null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {useCode};
            try {
                rs=  BaseDao.execute(conn, ps, rs, sql, params);
                user=new User();
                if (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setAddress(rs.getString("address"));
                    user.setUserRole(rs.getInt("userRole"));
                    user.setCreatedBy(rs.getInt("createdBy"));
                    user.setCreationDate(rs.getDate("creationDate"));
                    user.setModifyBy(rs.getInt("modifyBy"));
                    user.setModifyDate(rs.getDate("modifyDate"));
                }
                BaseDao.closeResource(null, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
        }

        }
return user;
    }

    public int updateUserPwd( Connection conn, int id, String userPassword) throws SQLException {
        PreparedStatement ps = null;
        int result = 0;
        if (conn!=null) {
            String sql = "update smbms_user set userPassword=? where id=?";
            //占位符条件顺序需要和上面sql语句顺序保持一致
            Object[] params = {userPassword,id };
            try {
                result= BaseDao.execute(conn,ps,sql,params);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            BaseDao.closeResource(null, ps, null);
        }

      return result;
    }

    @Override
    //根据用户名或者角色查询用户总数
    public int getUserCount(Connection conn,  String userName, int useRole) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        if (conn!=null) {
            StringBuffer sql = new StringBuffer() ;
            sql.append("select count(*) as count from smbms_user u,smbms_role r where u.userRole=r.id");
            ArrayList<Object> list = new ArrayList<Object>();

            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if (useRole>0){
                sql.append(" and u.userRole=?");
                list.add(useRole);
            }
            Object[] params = list.toArray();
            System.out.println("sql:"+sql.toString());
            try {
                rs=BaseDao.execute(conn,ps,rs,sql.toString(),params);
                if (rs.next()) {
                    count = rs.getInt("count");//从结果集中去获取最终数值
                }
BaseDao.closeResource(null, ps, rs);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection conn, String userName, int userRole, int currentPage, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if(conn != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPage = (currentPage-1)*pageSize;
            list.add(currentPage);
            list.add(pageSize);
            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            try {
                rs = BaseDao.execute(conn, pstm, rs, sql.toString(), params);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }

    @Override
    public int add(Connection connection, User user) throws Exception {

        PreparedStatement pstm = null;
        int updateRows = 0;
        if(null != connection){
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUserCode(),user.getUserName(),user.getUserPassword(),
                    user.getUserRole(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getCreationDate(),user.getCreatedBy()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;

    }

    //根据用户id删除用户信息

    @Override
    public Boolean deleteUser(Connection connection, Integer id) throws Exception {
        PreparedStatement pstm = null;
        int result = 0;
        boolean flag = false;
        if (null != connection){
            String sql = "delete from smbms_user where id=?";
            Object[] params = {id};
            result=BaseDao.execute(connection,pstm,sql,params);
            if(result>0){
                flag=true;
                System.out.println("修改成功");
            }
            BaseDao.closeResource(null, pstm, null);
        }

        return flag;
    }
}
