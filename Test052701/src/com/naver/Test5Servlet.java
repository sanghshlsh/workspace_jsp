package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test5
 */
@WebServlet("*.do")
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식을 위한 인코딩 get방식을 위한 인코딩은 servers.xml에 되어있다.
		response.setContentType("text/html;charset=utf-8");
//		System.out.println(".do로 끝나는 요청은 모두 이 서블릿으로 들어온다.");
		//select.do insert.do -->servlet path 클라이언트가 요청한 이를 가져오는 방법은 다음과 같다.
		//다음은 실무에서 아직 사용하지 않는 방식으로 그 다음방식을 활용하라
		//1.
//		String sp = request.getServletPath();
//		System.out.println(sp);
		//2.
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
				
		System.out.println(uri);
		System.out.println(ctxp);
		System.out.println(sp);
		
		if (sp.equalsIgnoreCase("/insert.do")) {
			System.out.println("입력입니다.");
		}else if(sp.equalsIgnoreCase("/select.do")){
			System.out.println("조회입니다.");
		}else if (sp.equalsIgnoreCase("/update.do")) {
			System.out.println("수정입니다.");
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
