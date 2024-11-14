package com.ynnz.service;

import com.ynnz.pojo.User;

public interface IUserService {
	
	/**
	 * 根据登录名查询用户信息
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName);

}
