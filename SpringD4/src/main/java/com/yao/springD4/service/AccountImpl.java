package com.yao.springD4.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yao.springD4.dao.IAccountDAO;
import com.yao.springD4.model.AccountVO;

@Service("AccountService")
public class AccountImpl implements IAccountImpl{
	
	@Autowired
	private IAccountDAO dao;
	
	@Override
	public AccountVO getOneAct(String account) {
		
		return dao.getOne(account);
		
	}
	
	@Override
	public void addAct(String lastName, String firstName, String account, String password, String imgPath) {
		
		AccountVO accountVO = new AccountVO();
		
		accountVO.setAccount(account);
		accountVO.setFirstName(firstName);
		accountVO.setLastName(lastName);
		accountVO.setPassword(password);
		accountVO.setImgPath(imgPath);
		
		dao.insert(accountVO);	
		
	}

}
