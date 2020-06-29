package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	
		
		List<MemberDTO> list= new MemberDAO().selectAll();
	
		request.setAttribute("list", list);
	
		return new CommandAction(false,"select.jsp");
	}

}
