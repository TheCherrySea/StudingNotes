package com.sakura.servlet.user;

import com.sakura.pojo.User;
import com.sakura.service.user.UserService;
import com.sakura.service.user.UserServiceImpl;
import com.sakura.until.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet:控制层调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        //与数据库中的用户密码进行对比
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        if (user != null && user.getUserCode().equals(userCode) && user.getUserPassword().equals(userPassword)) {
            //查有此人可以登录
            //将用户信息放到session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            //查无此人无法登录
            //转发回登陆页面，并提示用户名或密码错误
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
