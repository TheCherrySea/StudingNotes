package com.ynnz.service;

import com.ynnz.pojo.Account;
import com.ynnz.pojo.Pager;

public interface IAccountService {

	/**
	 * 查询所有账户信息
	 * @param account
	 * @param pageNumber 当前页号
	 * @param pageSize 每页需要条数
	 * @return
	 */
	public  Pager<Account> getList(Account account, Integer pageNumber, Integer pageSize);
	
	/**
	 * 批量删除账户信息
	 * @param ids
	 * @return
	 */
	public int batchDel(Integer ids[]);

}
