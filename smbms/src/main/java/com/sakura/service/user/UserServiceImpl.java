package com.sakura.service.user;

import com.sakura.dao.BaseDao;
import com.sakura.dao.user.UserDao;
import com.sakura.dao.user.UserImpl;
import com.sakura.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //业务层都会调用DAO层，引入DAO层
    private UserDao userDao;
    public UserServiceImpl() {
    userDao=new UserImpl();
}
    @Override
    public User login(String userCode, String password) {
        Connection con=null;
        User user=null;
        try {
            con=BaseDao.getConnection();
            //通过业务层调用具体的数据库操作
            user=userDao.login(userCode,con);
        }catch (Exception e){
e.printStackTrace();
        }finally {
            BaseDao.closeResource(con,null,null);
        }
        return user;
    }

    @Override
    public Boolean updatePwd(int id, String userPassword) {
        Connection con=null;
        boolean flag=false;

        try {
            con=BaseDao.getConnection();
            if (userDao.updateUserPwd(con,id,userPassword)>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(con,null,null);
        }
        return flag;
    }

    @Override
    public int querryUser(String userName, int userRole) {
        Connection con=null;
        int count=0;
        try {
            con=BaseDao.getConnection();
            count= userDao.getUserCount(con,userName,userRole);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(con,null,null);
        }
        return count;
    }
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();

        System.out.println(userService.querryUser(null,1));
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int page, int rows) {
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + userName);
        System.out.println("queryUserRole ---- > " + userRole);
        System.out.println("currentPageNo ---- > " + page);
        System.out.println("pageSize ---- > " + rows);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, userName,userRole,page,rows);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;

    }

    @Override
    public boolean add(User user) {
        boolean flag = false;
        Connection connection = null;

        try {
            connection = BaseDao.getConnection();
//            一切的增删改查都需要处理事务
            int updateRow=userDao.add(connection,user);//开启JDBC事务管理
            connection.setAutoCommit(false);
            if (updateRow>0){
                connection.commit();
            }else {
                connection.rollback();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean deleteUserById(Integer id) {
  Connection connection = null;
  boolean flag = false;
        connection=BaseDao.getConnection();
        try {
            if ((userDao.deleteUser(connection,id))!=null){
                flag=true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }
}
