package com.ynnz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截认证是否登录
 * @author 吕琼华
 *
 */
@Component
public class LoginInteceptor implements HandlerInterceptor {
	
	/**
	 * 在业务方法执行前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String  uri = request.getRequestURI();
		if(uri.indexOf("/login")>-1) {//登录相关的请求
			return true;
		}
		HttpSession session = request.getSession();//获取当前会话对象
		Object obj = session.getAttribute("LOGIN_USER");//取出登录信息
		if(obj != null) {//说明登录过，有登录信息
			return true;
		}
		//请求被拦截，转发请求到登录页面
		request.getRequestDispatcher("/login/toLogin.do").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
