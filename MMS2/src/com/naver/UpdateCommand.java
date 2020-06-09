package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public class UpdateCommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
			if (loginDTO != null) {
				if (loginDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.update(new MemberDTO(id, name, age));
//					response.sendRedirect("select.do");
					return new CommandAction(true, "select.do");
				}else {
					return new CommandAction(true,"selectById.do?id="+id );
//					response.sendRedirect("selectById.do?id="+id);
				}
			}else {
				return new CommandAction(true,"selectById.do?id="+id );
//				response.sendRedirect("selectById.do?id="+id);
			}
		} else {
//			response.sendRedirect("selectById.do?id="+id);
			return new CommandAction(true,"selectById.do?id="+id );
		}
//회원 정보 수정 때 로그인 되어있는 상황에서 수정가능하게
		
		
		
	}
}
