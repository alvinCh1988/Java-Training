package com.yao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yao.demo.exception.AccountNotFoundException;
import com.yao.demo.model.Account;
import com.yao.demo.repository.AccountRepository;

@Service("AccountService")
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	/**
	 * 新增一筆資料
	 * 
	 * @param account
	 * @return
	 */
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	/**
	 * 以帳號名稱取得一筆資料 若為空值會拋出NotFoundException並將畫面帶到 404
	 * 
	 * @param accountName
	 * @param password
	 * @return
	 */
	public Account findByAccountName(String accountName) {

		Account account = accountRepository.findByAccountName(accountName);
		if (account == null) {
			throw new AccountNotFoundException();
		}
		return account;
	}

	/**
	 * 檢查帳號名稱是否已使用
	 */
	public Boolean checkAccountNameUsed(String accountName) {

		Account account = accountRepository.findByAccountName(accountName);

		if (account != null) {
			return true;
		}
		return false;
	}

	/**
	 * 以accountName 取得一筆資料後並驗證後回傳
	 * 
	 * @param accountName
	 * @param password
	 * @return
	 */
	public Map<String, Object> findByAccountNameAndPassword(String accountName, String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		Account account = accountRepository.findByAccountName(accountName);

		if (account == null) {
			map.put("status", "ACT_ERROR");
			return map;
		}

		if (!account.getPassword().equals(password)) {
			map.put("status", "PSW_ERROR");
			return map;
		}

		if (account.getAuthGroup() == null || account.getAuthGroup().equals("")) {
			map.put("status", "UNAUTH");
			return map;
		}
		
	
		map.put("account", account);
		map.put("status", "SUCCESS");
		return map;

	}

	/**
	 * 取得全部資料
	 * 
	 * @return
	 */
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	/**
	 * 以id為條件取得一筆資料
	 * 
	 * @param id
	 * @return
	 */
	public Account getOne(long id) {
		return accountRepository.getOne(id);
	}

	/**
	 * 以id為條件刪除一筆資料
	 * 
	 * @param id
	 */
	public void delete(long id) {
		accountRepository.deleteById(id);
	}

	/**
	 * 分頁查詢
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Account> findAllByPage(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

}
