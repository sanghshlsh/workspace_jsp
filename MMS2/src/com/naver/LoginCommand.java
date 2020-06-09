package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		boolean login = dao.Login(new LoginDTO(id, pw));
		
		//request.getSession(); 세션이 없으면 세션을 생성하여 리턴.
		//request.getSession(true); 위와동일
		//request.getSession(false); 세션이 없으면 null 리턴.
		
		if (login) {
			HttpSession session = request.getSession();	
			session.setMaxInactiveInterval(60);//세션 유지시간 설정(servers의 web.xml에서는 단위가 분이었지만 이곳은 초)
			session.setAttribute("login", new LoginDTO(id, null));
//			response.sendRedirect("select.do");
			return new CommandAction(true, "select.do");
		} else {
			return new CommandAction(true, "loginui.do");
//			response.sendRedirect("loginui.do");
		}
	}

}
