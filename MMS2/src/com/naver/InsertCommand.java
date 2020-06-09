package com.naver;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class InsertCommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}
		String pw = request.getParameter("pw");//2.회원가입시 비밀번호추가
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age),pw);//2.회원가입시 비밀번호추가
		
		return new CommandAction(true, "select.do");
//		response.sendRedirect("select.do");
		
	}
}
