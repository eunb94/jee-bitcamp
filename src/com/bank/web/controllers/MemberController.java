package com.bank.web.controllers;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser;

import com.bank.web.ServiceImpls.MemberServiceImpl;
import com.bank.web.command.Sender;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.services.MemberService;

@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage();
		}

		switch(Receiver.cmd.getAction()) {

		case "join":
		System.out.println("컨트롤러 join 도착함");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String credit = request.getParameter("credit");
		System.out.println(pw);
		param.setId(id);
		param.setPw(pw);
		param.setName(name);
		param.setSsn(ssn);
		param.setCredit(credit);
		System.out.println("회원정보 : " + param.toString());
		service.join(param); 
		Receiver.cmd.setPage("login");
		break;
		
		case "login" : 
			System.out.println("컨트롤러 login 도착함");
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			System.out.printf("로그인 서비스 진입 후 아이디 : %s , 비번 : %s  \n", id, pw);
			System.out.println("로그인 서비스 아웃 " + param.toString());
			CustomerBean cust = service.login(param);
			String a = cust.getId();
			if(cust == null) {
				Receiver.cmd.setPage("login");
			}else {
				Receiver.cmd.setPage("mypage");
			}		
			request.setAttribute("customer", cust);
			break;
			
		case "existId" :
			break;
		}
		Sender.forward(request, response);



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
