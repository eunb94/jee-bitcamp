package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.ServiceImpls.MemberServiceImpl;
import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{

	public CreateCommand(HttpServletRequest request) throws Exception {
		super(request);
	
	}
	@Override
	public void execute() {
		super.execute();
		System.out.println("컨트롤러 join 도착함");
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		param.setName(request.getParameter("name"));
		param.setSsn(request.getParameter("ssn"));
		param.setCredit(request.getParameter("credit"));
		System.out.println("회원정보 : " + param.toString());
		service.join(param); 
		
	}
}
