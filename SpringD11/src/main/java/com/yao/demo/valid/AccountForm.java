package com.yao.demo.valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.yao.demo.domain.Account;

public class AccountForm {

	private final String PSW_REG = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$";
	private final String FILTER = "[^'\"{}\\[\\]\\\\//s!@#$%^&*()-+=_]*";
	private final String NOTBLANK = "不得為空白"; 
	private final String NO_SYMBOLS = "不得有特殊符號";

	@NotBlank(message = NOTBLANK)
	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	private String accountName;

	@NotBlank(message = NOTBLANK)
	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	private String firstName;

	@NotBlank(message = NOTBLANK)
	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	private String lastName;

	@Length(min = 8)
	@Pattern(regexp = PSW_REG)
	private String password;

	@NotBlank(message = NOTBLANK)
	private String confirmPassword;

	private String photoPath;

	private String authGroup;

	public AccountForm() {

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	
	@Override
	public String toString() {
		return "AccountForm [accountName=" + accountName + ", firstName=" + firstName + ", lastName=" + lastName
		+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", photoPath=" + photoPath
		+ ", authGroup=" + authGroup + "]";
	}
	
	public Account ConvertToAccount() {
		Account account = new AccountFormConvert().convert(this);
		return account;
	}

	private class AccountFormConvert implements FormConvert<AccountForm, Account> {

		@Override
		public Account convert(AccountForm accountForm) {
			Account account = new Account();
			BeanUtils.copyProperties(accountForm, account);
			return account;
		}
	}

	public Boolean confirmPassword() {

		if (confirmPassword.equals(password)) {
			return true;
		}
		return false;
	}

};