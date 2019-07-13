package com.yao.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>{
	
	Account findByAccountNameAndPassword(String accountName, String password);
	
	Page<Account> findAll(Pageable pagealbe);

}
