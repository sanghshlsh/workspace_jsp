package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listcmd implements Cmd {

	@Override
	public CA execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DTO> list =new DAO().list();
		
		request.setAttribute("list", list);
		
		
		return new CA(false, "list.jsp");
	}

}
