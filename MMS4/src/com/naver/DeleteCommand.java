package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO dto = (LoginDTO) session.getAttribute("login");
			if (dto != null) {
				String id = request.getParameter("id");
				if (dto.getId().equals(id)) {
					new MemberDAO().Delete(id);
					session.invalidate();
					return new CommandAction(true, "select.bo");
				}

			}
		}

		return new CommandAction(true, "loginui.bo");
	}

}
