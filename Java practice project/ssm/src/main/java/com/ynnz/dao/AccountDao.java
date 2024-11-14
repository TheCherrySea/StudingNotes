package com.ynnz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ynnz.pojo.Account;

public interface AccountDao {

	/**
	 * 查询所有账户信息
	 * 
	 * @param name   姓名
	 * @param sex    性别
	 * @param typeId 账户类别ID
	 * @return
	 */
	public List<Account> getAccountList(@Param("name") String name, @Param("sex") String sex,
			@Param("typeId") Integer typeId, @Param("start") int start, @Param("count") int count);
	
	/**
	 * 根据条件查询总记录数
	 * @param name
	 * @param sex
	 * @param typeId
	 * @return
	 */
	public int getAccountListCount(@Param("name") String name, @Param("sex") String sex,
			@Param("typeId") Integer typeId);

}
