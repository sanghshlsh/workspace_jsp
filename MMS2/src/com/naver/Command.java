package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//지금은 void지만 나중에는 commandaction이라는 클래스명으로 
//	void execute(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException;
	CommandAction execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;
}
