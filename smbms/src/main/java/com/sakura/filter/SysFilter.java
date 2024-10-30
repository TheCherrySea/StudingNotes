package com.sakura.filter;


import com.sakura.pojo.User;
import com.sakura.until.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//通过HttpServletRequest拿到session
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //过滤器从session中获取用户
        User user= (User) req.getSession().getAttribute(Constants.USER_SESSION);
        if (user==null){
            //已经被移除或注销，未登录
            res.sendRedirect(req.getContextPath()+"/error.jsp");

        }else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
