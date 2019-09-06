package com.bank.web.ServiceImpls;
import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;



public class MemberServiceImpl implements MemberService{
	
	private List <CustomerBean> customers;
	private List<EmployeeBean> employees;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		customers  = new ArrayList <>();
		employees = new ArrayList<>();
		dao = new MemberDAOImpl();
	}
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
		
		
	}

	@Override
	public void register(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m=c;
				
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			 
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}
	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countEmployees() {
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		MemberBean m = findById(id);
		
		return (employees.contains(m)) || (customers.contains(m));	
		
	}
	
	@Override
	public void updatePass(MemberBean param) {
	}

	@Override
	public void deleteMember(MemberBean param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CustomerBean> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeBean> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<>();
		int count = 0;
		return members;
	}
	@Override
		public CustomerBean login(CustomerBean param) {
			System.out.println("서비스 login 도착함");
	    	CustomerBean cust = dao.login(param);
	        return cust;
	}

		}
	
