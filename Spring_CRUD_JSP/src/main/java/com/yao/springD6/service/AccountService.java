package com.yao.springD6.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yao.springD6.domain.Account;
import com.yao.springD6.domain.AccountRepository;

@Service("AccountService")
public class AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	

	public Account findByAccountName(String accountName) {
		
		return accountRepository.findByAccountName(accountName);

	}
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	

}
