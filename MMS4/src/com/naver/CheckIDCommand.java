package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckIDCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (new MemberDAO().CheckId(id)) {
			HttpSession session = request.getSession();
			session.setAttribute("idOK", new MemberDTO(id, null, 0, null));
			
			return new CommandAction(true, "insertui.bo");
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("isOK");
		}
		return new CommandAction(true, "insertui.bo");
		
	}

}
