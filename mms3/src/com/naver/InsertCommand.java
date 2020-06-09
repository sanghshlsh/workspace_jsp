package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw1");
		if (!request.getParameter("pw2").equals(pw)) {
			System.out.println("패스워드가 동일하지 않습니다.");
			return new CommandAction(true, "insertui.bo");
		}
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}
		
		new MemberDAO().Insert(new MemberDTO(id, name, age, pw));
	
		return new CommandAction(true, "select.bo");
	}

}
