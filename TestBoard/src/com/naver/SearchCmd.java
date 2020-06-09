package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCmd implements Cmd {

	@Override
	public CA execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		List<DTO> list = new DAO().search(title);
		request.setAttribute("list", list);
		
		return new CA(false, "search.jsp");
	}

}
