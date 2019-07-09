package com.yao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.yao.demo.domain.Account;
import com.yao.demo.domain.AccountRepository;

@Service("AccountService")
public class AccountService{
	
	@Autowired
	private AccountRepository accountRepository;	
	
	/**
	 * 新增資料
	 * @param account
	 * @return
	 */
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	/**
	 * 以帳號名稱以及密碼為條件取得一筆資料
	 * @param accountName
	 * @param password
	 * @return
	 */
	public Account findByAccountNameAndPassword(String accountName, String password) {
		return accountRepository.findByAccountNameAndPassword(accountName, password);
	}

	/**
	 * 取得全部資料
	 * @return
	 */
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	/**
	 * 以id為條件取得一筆資料
	 * @param id
	 * @return
	 */
	public Account getOne(long id) {
		return accountRepository.getOne(id);
	}

	/**
	 * 以id為條件刪除一筆資料
	 * @param id
	 */
	public void delete(long id) {
		accountRepository.deleteById(id);
	}
	
	/**
	 * 分頁查詢
	 * @param pageable
	 * @return	
	 */
	public Page<Account> findAllByPage(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}
	

}
