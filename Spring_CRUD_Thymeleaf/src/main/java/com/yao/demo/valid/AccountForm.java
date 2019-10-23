package com.yao.demo.valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import com.yao.demo.model.Account;

public class AccountForm {

	private final String PSW_REG = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$"; // 至少8-20 英文數字混合 至少要有大寫 密碼
	private final String FILTER = "^[A-Za-z0-9\\u4e00-\\u9fa5]+$";
	private final String NO_SYMBOLS = "不能為空白 或 輸入特殊符號";

	private long id;

	@Pattern(regexp = FILTER, message = NO_SYMBOLS)
	private String accountName;

	@NotBlank(message = NO_SYMBOLS)
//	@Pattern(regexp = PSW_REG)
	private String password;

	@NotBlank(message = NO_SYMBOLS)
	private String confirmPassword;

	private String photoPath;

	private String authGroup;

	public AccountForm() {

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
		return "AccountForm [accountName=" + accountName
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