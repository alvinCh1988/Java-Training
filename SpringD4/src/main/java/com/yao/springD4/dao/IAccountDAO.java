package com.yao.springD4.dao;

import com.yao.springD4.model.AccountVO;

public interface IAccountDAO {
	
	public void insert(AccountVO accountVO);
	public AccountVO getOne(String account);

}
