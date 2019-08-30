package com.bank.web.ServiceImpls;
import java.util.Date;
import java.util.Random;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;
public class AccountServiceImpl implements AccountService {

	private List<AccountBean> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money+"");
		account.setRegDate(findDate());
		accounts.add(account);
		System.out.println(accounts.toString());
		
		
	}

	@Override
	public String createAccountNum() { // 1234-1234
		Random ran = new Random();
		String result = "";
		for(int i=0; i<10;i++) {
				 result = ran.nextInt(10)+"";
				 if(i==4) {
					 result += "-";
				 
				break;			
		}
		}
	
		return result;
	}
	

	@Override
	public List<AccountBean> findAll() {
		
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
			AccountBean acc = new AccountBean();
			for(AccountBean a : accounts) {
				if(accountNum.equals(a.getAccountNum())) {
					acc = a;
					break;
				}
			}
		return acc;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
			for(AccountBean a : accounts) {
				if(accountNum.equals(a.getAccountNum())){
					flag = true;
					break;
				}
			}
		return flag;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd/hh:dd").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
			
			String oldB = param.getMoney().split(",")[0];
			String deposit = param.getMoney().split(",")[1];	
			param.setMoney(String.valueOf(Integer.parseInt(oldB) + Integer.parseInt(deposit)));
			
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		String oldB = param.getMoney().split(",")[0];
		String with = param.getMoney().split(",")[1];	
		param.setMoney(String.valueOf(Integer.parseInt(oldB) - Integer.parseInt(with)));
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		
		
	}

}
