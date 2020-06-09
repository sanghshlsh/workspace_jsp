package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		boolean isTrue = new MemberDAO().Login(new LoginDTO(id, pw));
		// new MemberDTO(id, null, 0, pw)로하는게 아닌 Login DTO방식을 쓰는게 일반적
		if (isTrue) {
			HttpSession session = request.getSession();
			if (session.getAttribute("login") == null) {
				session.setAttribute("login", new LoginDTO(id, null));
				if (session.getAttribute("selectById") != null) {
					session.removeAttribute("selectById");
					return new CommandAction(true, "selectById.bo?id=" + id);

				} else {
					return new CommandAction(true, "select.bo");
				}

			}else {
				session.removeAttribute("login");
				session.setAttribute("login", new LoginDTO(id, null));
				if (session.getAttribute("selectById") != null) {
					session.removeAttribute("selectById");
					return new CommandAction(true, "selectById.bo?id=" + id);

				} else {
					return new CommandAction(true, "select.bo");
				}
			}
		}
		return new CommandAction(true, "loginui.bo");

	}

}
