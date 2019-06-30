package com.yao.springD4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yao.springD4.model.AccountDAO;
import com.yao.springD4.model.AccountService;
import com.yao.springD4.model.FileUtils;

@Configuration
public class TestConfiguration {
	
	@Bean
	public AccountService accountService() {
		return new AccountService();
	}
	
	@Bean
	public AccountDAO accountDAO() {
		return new AccountDAO();
	}
	
	@Bean
	public FileUtils fileUtils() {
		return new FileUtils();
	}
	

}
