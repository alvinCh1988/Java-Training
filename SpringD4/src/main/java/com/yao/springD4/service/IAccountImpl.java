package com.yao.springD4.service;

import com.yao.springD4.model.AccountVO;

public interface IAccountImpl {
	
	public void addAct(String lastName, String firstName, String account, String password, String imgPath);
	public AccountVO getOneAct(String account);

}
