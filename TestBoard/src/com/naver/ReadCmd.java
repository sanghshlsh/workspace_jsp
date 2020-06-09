package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCmd implements Cmd {

	@Override
	public CA execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = 0;
		if (sNum != null) {
			num = Integer.valueOf(sNum);
		}
		
		DTO dto = new DAO().read(num);

		request.setAttribute("dto", dto);
		
		return new CA(false, "read.jsp");
	}

}
