package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.updateui(id);
		
		
		
		request.setAttribute("dto", dto);
//		request.getRequestDispatcher("update.jsp").forward(request, response);
		return new CommandAction(false, "update.jsp");
	}

}
