package com.yao.springD4.model;


import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
	
	@Autowired
	private IAccount dao;
	
//	public AccountService() {
//		dao = new AccountDAO();
//	}
	
	public AccountVO getOneAct(String account) {
		
		return dao.getOne(account);
		
	}
	
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
