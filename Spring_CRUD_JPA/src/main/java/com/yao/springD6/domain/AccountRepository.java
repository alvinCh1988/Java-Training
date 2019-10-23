package com.yao.springD6.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>{
	
	Account findByAccountName(String accountName);

}
