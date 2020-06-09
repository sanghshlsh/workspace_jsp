package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class InsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age=0;
		if (sAge!=null) {
			age=Integer.valueOf(sAge);
		}
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		//커맨드 인터페이스가 보이드 메소드를 가지고 있었기때문에 어쩔수 없이 지금은 여기서 포워딩을 해야한다.
		
		response.sendRedirect("select");
		
	}
}
