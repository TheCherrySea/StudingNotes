package com.ynnz.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynnz.dao.AccountDao;
import com.ynnz.dao.gen.AccountMapper;
import com.ynnz.pojo.Account;
import com.ynnz.pojo.AccountExample;
import com.ynnz.pojo.Pager;

@Service("accountServiceImpl")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Pager<Account> getList(Account account, Integer pageNumber, Integer pageSize) {
		String name = account.getName();
		String sex = account.getSex();
		Integer typeId = account.getTypeId();
		//查询满足条件的总记录数
		int total = accountDao.getAccountListCount(name, sex, typeId);
		Pager<Account> pager = new Pager<Account>(total, pageSize, pageNumber);
		int start = pager.getStartIndex();//拿到起始行号
		int count = pager.getPageSize();
		// 调用dao层方法
		List<Account> list =  accountDao.getAccountList(name, sex, typeId,start,count);
		pager.setList(list);//把分页查询的数据放到分页组件
		return  pager;
	}

	@Override
	public int batchDel(Integer[] ids) {
		AccountExample ae = new AccountExample();
		AccountExample.Criteria c=  ae.createCriteria();
		//把数组转为集合类
		List<Integer> idList = Arrays.asList(ids);
		c.andIdIn(idList);
		return accountMapper.deleteByExample(ae);
	}

}
