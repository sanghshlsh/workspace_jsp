package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.DeleteCommand;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListCommand;
import kr.co.command.ListPageCommand;
import kr.co.command.ReadCommand;
import kr.co.command.ReplyCommand;
import kr.co.command.ReplyUICommand;
import kr.co.command.SearchCommand;
import kr.co.command.SearchPageCommand;
import kr.co.command.UpdateCommand;
import kr.co.command.UpdateUICommand;
import kr.co.domain.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctxp = request.getContextPath();
		String uri = request.getRequestURI();
		String sp = uri.substring(ctxp.length());

		Command com = null;

		if (sp.equalsIgnoreCase("/list.do")) {
//			com = new ListCommand();
			com = new ListPageCommand();
		} else if (sp.equalsIgnoreCase("/writeui.do")) {
			com = new InsertUICommand();
		} else if (sp.equalsIgnoreCase("/write.do")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/search.do")) {
			// com = new SearchCommand();
			com = new SearchPageCommand();
		} else if (sp.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		} else if (sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if (sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if (sp.equalsIgnoreCase("/replyui.do")) {
			com = new ReplyUICommand();
		} else if (sp.equalsIgnoreCase("/reply.do")) {
			com = new ReplyCommand();
		}

		else {
			System.out.println("존재하지 않는 기능입니다.");
		}

		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
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
