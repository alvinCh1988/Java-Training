package com.yao.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{

	/**
	 * 處理拋出的例外
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	


	
}
