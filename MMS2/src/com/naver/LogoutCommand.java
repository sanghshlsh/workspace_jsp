package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session의 scope 시간&브라우저
		//-일정시간 지나면 세션유지x
		//-다른브라우저에서는 세션유지x
		
		//로그아웃 3가지 방법
		//1.세션시간 0으로 설정
				//세션시간설정 setMaxInactiveInterval() 메소드호출
		//2. 세션제거
		//3. 세션에 바인딩된 데이터제거
		
		
		//세션가져오기
		HttpSession session = request.getSession(false);
		if (session != null) {
			//session.setMaxInactiveInterval(1); //시간설정으로 종료
			//session.removeAttribute("login"); //세션에 바인딩된 데이터 제거
			session.invalidate();//세션제거
		}
//			response.sendRedirect("select.do");
			return new CommandAction(true, "select.do");
		
		
	}

}
