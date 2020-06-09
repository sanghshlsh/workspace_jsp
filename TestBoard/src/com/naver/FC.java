package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FC
 */
@WebServlet("*.do")
public class FC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cmd com = null;
		String ctxp = request.getContextPath();
		String uri = request.getRequestURI();
		String sp = uri.substring(ctxp.length());

		if (sp.equalsIgnoreCase("/list.do")) {
			com = new Listcmd();
		} else if (sp.equalsIgnoreCase("/search.do")) {
			com = new SearchCmd();
		} else if (sp.equalsIgnoreCase("/read.do")) {
			com = new ReadCmd();
		} else if (sp.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICmd();
		}
		
		
		else {
			System.out.println("없는기능");
		}

		if (com != null) {
			CA action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
