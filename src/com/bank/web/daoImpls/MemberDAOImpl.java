package com.bank.web.daoImpls;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import com.bank.web.pool.Constants;
public class MemberDAOImpl implements MemberDAO{
	File file = new File(Constants.FILE_PATH+"customers190905.txt");
	List<String> list = new ArrayList<>();
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s,%s,%s", param.getId(),param.getPw(),param.getName(),param.getSsn(),param.getCredit()));
			writer.newLine();
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		System.out.println("DAO 도착함" + param.toString());
			try {
				BufferedReader rd = new BufferedReader(new FileReader(file));
				String user = rd.readLine();
				rd.close();
				String[] arr = user.split(",");
				param.setId(arr[0]);
				param.setPw(arr[1]);
				param.setName(arr[2]);
				param.setSsn(arr[3]);
				param.setCredit(arr[4]);
				
				System.out.println("DAO 아웃함" +  param.toString());
				
				
			}catch(Exception e) {
				e.getStackTrace();
			}
			
			 return param;	
	}

	



}
