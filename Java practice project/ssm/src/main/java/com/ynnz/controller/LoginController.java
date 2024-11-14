package com.ynnz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynnz.pojo.User;
import com.ynnz.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserService userServiceImpl;

	/**
	 * 浏览器打开登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login/login";
	}

	/**
	 * 验证登录过程
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(String username, String password,Model model,HttpServletRequest req) {
		System.out.println("用户名：" + username);
		User u = userServiceImpl.getUserByLoginName(username);
		String msg = null;
		if (u == null) {//判断用户是否存在
			msg = "该用户不存在！";
			model.addAttribute("msg", msg);
			return "/login/login";
		}
		if (!u.getLoginPwd().equals(password)) {//判断密码是否正确
			msg = "密码输入错误！";
			model.addAttribute("msg", msg);
			return "/login/login";
		}
		HttpSession session = req.getSession();
		session.setAttribute("LOGIN_USER", u);//把验证通过的用户对象放到session
		return "redirect:/getList.do";
	}
}
