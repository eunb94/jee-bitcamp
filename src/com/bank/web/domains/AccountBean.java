package com.bank.web.domains;

import java.io.Serializable;

public class AccountBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNum, money, regDate;

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + getAccountNum() 
				+ ", 거래일자=" + getRegDate() 
				+ ", 금액=" + getMoney() + "]";
	}
	
}
