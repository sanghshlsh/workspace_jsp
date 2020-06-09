package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class SelectCommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = 	dao.selectAll();
		
		request.setAttribute("list", list);
		
//		request.getRequestDispatcher("select.jsp").forward(request, response);
		return new CommandAction(false, "select.jsp");
		
		
		
	}
}
