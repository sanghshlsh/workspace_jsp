package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.bo")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		Command com = null;
		if (sp.equalsIgnoreCase("/select.bo")) {//가장많이사용하는 command를 의도적으로 최상단에 배치함으로 조금이라도 빠른 속도와 적은메모리소모를 의도함
			com = new SelectCommand();
		} else if(sp.equalsIgnoreCase("/insertui.bo")) {
			com = new InserUICommand();
		} else if (sp.equalsIgnoreCase("/insert.bo")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/selectById.bo")){
			com = new SelectByIdCommand();
		} else if(sp.equalsIgnoreCase("/updateui.bo")) {
			com = new UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/update.bo")) {
			com = new UpdateCommand();
		} else if(sp.equalsIgnoreCase("/loginui.bo")) {
			com = new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/login.bo")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/logout.bo")) {
			com = new LogoutCommand();
		} else if(sp.equalsIgnoreCase("/delete.bo")) {
			com = new DeleteCommand();
		}
		
		
		
		else {
			System.out.println("제공하지 않는 서비스입니다.");
		}
		
		if (com != null) {
			CommandAction action = com.execute(request,response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
