package com.ynnz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynnz.dao.gen.UserMapper;
import com.ynnz.pojo.User;
import com.ynnz.pojo.UserExample;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByLoginName(String loginName) {
		// 创建example构造查询条件
		UserExample ue = new UserExample();
		UserExample.Criteria c = ue.createCriteria();
		c.andLoginNameEqualTo(loginName);
		List<User> list = userMapper.selectByExample(ue);
		User u = null;
		if (list != null && list.size()>0) {
			u = list.get(0);
		}
		return u;
	}

}
