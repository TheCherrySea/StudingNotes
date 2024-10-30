package com.sakura.servlet.user;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.mysql.cj.util.StringUtils;

import com.sakura.pojo.Role;
import com.sakura.pojo.User;
import com.sakura.service.role.RoleService;
import com.sakura.service.role.RoleServiceImpl;
import com.sakura.service.user.UserService;
import com.sakura.service.user.UserServiceImpl;
import com.sakura.until.Constants;
import com.sakura.until.PageSupport;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserServlet extends HttpServlet {
//从session中获取id

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String method = req.getParameter("method");
     if (method.equals("savepwd")&&method!=null){
     this.updatePwd(req, resp);
     }else if (method.equals("pwdmodify")&&method!=null){
         this.pwdModify(req, resp);
     }else if (method.equals("query")&&method!=null){
this.query(req, resp);
     }else if(method != null && method.equals("deluser")){
this.delUserById(req,resp);
     }else if(method != null && method.equals("add")){
this.add(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
doGet(req, resp);

    }

    //修改密码
    private void updatePwd(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //从session中获取id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");

        boolean flag = false;

        if(o != null && !StringUtils.isNullOrEmpty(newpassword)) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User)o).getId(),newpassword);
            if(flag){
                req.setAttribute("message", "修改密码成功,请退出并使用新密码重新登录！");
                req.getSession().removeAttribute(Constants.USER_SESSION);//session注销
            }else{
                req.setAttribute("message", "修改密码失败！");
            }
        }else{
            req.setAttribute(Constants.USER_SESSION, "新密码出现问题！");
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
    }
    //验证旧密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        Map<String,String> resultMap = new HashMap<String,String>();

        if (o==null){
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){
resultMap.put("result","error");
        }else {
            String userpassword =((User)o).getUserPassword();
            if (oldpassword.equals(userpassword)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }

        }
        resp.setContentType("application/json");
        try {
            PrintWriter writer=resp.getWriter();
            writer.write(JSON.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//查询用户列表
    public void query(HttpServletRequest req, HttpServletResponse resp){
        //从前端获取数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        int queryUserRole = 0;
        UserService userService = new UserServiceImpl();
        List<User> userList = null;
        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;
        /**
         * http://localhost:8090/SMBMS/userlist.do
         * ----queryUserName --NULL
         * http://localhost:8090/SMBMS/userlist.do?queryname=
         * --queryUserName ---""
         */
        System.out.println("queryUserName servlet--------"+queryUserName);
        System.out.println("queryUserRole servlet--------"+queryUserRole);
        System.out.println("query pageIndex--------- > " + pageIndex);
        if(queryUserName == null){
            queryUserName = "";
        }
        if(temp != null && !temp.equals("")){
            queryUserRole = Integer.parseInt(temp);
        }

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                try {
                    resp.sendRedirect("error.jsp");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        //总数量（表）
        int totalCount	= userService.querryUser(queryUserName,queryUserRole);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);

        int totalPageCount = pages.getTotalPageCount();

        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;

        }

        userList = userService.getUserList(queryUserName,queryUserRole,currentPageNo, pageSize);
        req.setAttribute("userList", userList);
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoles();
        req.setAttribute("roleList", roleList);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //添加用户
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add()================");
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)req.getSession().getAttribute(Constants.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if(userService.add(user)){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("useradd.jsp").forward(req, resp);
        }

    }
//根据id删除用户
    public void delUserById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
String  id = req.getParameter("uid");
Integer delId = 0;
delId=Integer.parseInt(id);
HashMap<String,String> resultMap=new HashMap<>();
if (delId<=0){
resultMap.put("result","noteExist");
}else {
UserService userService = new UserServiceImpl();
if (userService.deleteUserById(delId)){
    resultMap.put("result","true");
}else {
    resultMap.put("result","false");
}
}
        //把resultMap转换成json对象输出
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = resp.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();

    }

}

