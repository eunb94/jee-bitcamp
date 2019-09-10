package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.ServiceImpls.MemberServiceImpl;
import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request) throws Exception {
		super(request);

	}
	@Override
	public void execute() {		
		super.execute();
		System.out.println("LoginCommand 도착함");
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		param.setId(id);
		param.setPw(pw);
		System.out.printf("로그인 서비스 진입 후 아이디 : %s , 비번 : %s  \n", id, pw);
		System.out.println("로그인 서비스 아웃 " + param.toString());
		CustomerBean cust = service.login(param);
		String page = "";
		if(cust == null) {
			page = "login";
		}else {
			page = "mypage";
		}
		request.setAttribute( "customer",cust);
		Receiver.cmd.setPage(page);
		System.out.println("로그인 후 갈 페이지: "+Receiver.cmd.getView());
		
	}
	
}
