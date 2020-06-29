package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		String pw = request.getParameter("pw");
		int age= 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
	
			new MemberDAO().Update(new MemberDTO(id, name, age, pw));	
			
		
		
		
		return new CommandAction(true, "selectById.bo?id="+id);
	}

}
