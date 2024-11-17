package com.sakura.controller;

import com.sakura.pojo.User;
import com.sakura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller调用service层
    @Autowired
    @Qualifier("UserServiceImpl")//此处名字查看spring-service.xml配置文件中的业务类注入到spring中id的值，或者注解@Service（“”）括号中的值
    private UserService userService;
    //查询全部用户，返回到用户展示页面
    @RequestMapping("/allUser")
    public String userList(Model model) {
        List<User> users = userService.queryAllUser();
        model.addAttribute("users", users);
        return "allUser";
    }


    @RequestMapping("/addUser1")
    public String addUserList(User user) {
        int users = userService.addUser(user);
        return "redirect: allUser";
    }
    @RequestMapping("/addUserPage")
    public String addUserList() {
        return "addUser";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate( int id, Model model) {
        User user = userService.queryUser(id);
        model.addAttribute("upUser", user);
        return "UpdateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser( User user) {
         userService.updateUser(user);
        return "redirect:/user/allUser";
    }
/*使用restful风格
* 前端页面传值的时候使用id传值*/
    @RequestMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") int id ) {
        userService.deleteUser(id);
        return "redirect:/user/allUser";
    }
    @RequestMapping("/queryUser")
    public String queryUser(String queryName,  Model model) {
        List<User> user =  userService.queryUserByUsername(queryName);
        model.addAttribute("users", user);
        return "allUser";
    }
}
