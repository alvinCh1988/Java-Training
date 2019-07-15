package com.yao.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tbl_account")
public class Account {
	
	private final String FILTER = "^[A-Za-z0-9\\u4e00-\\u9fa5]+$";
	private final String NO_SYMBOLS = "不能為空白 或 輸入特殊符號";

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="accountname")
	private String accountName;
	
	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	@Column(name="firstname")
	private String firstName;
	
	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="photopath")
	private String photoPath;
	
	@Column(name="authgroup")
	private String authGroup;
	
	public Account() {	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}
	
	
	
	
	
}
