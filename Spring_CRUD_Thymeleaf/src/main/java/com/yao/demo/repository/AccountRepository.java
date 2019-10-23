package com.yao.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yao.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	
	Account findByAccountName(String accountName);

	Account findByAccountNameAndPassword(String accountName, String password);
	
	Page<Account> findAll(Pageable pagealbe);


}
