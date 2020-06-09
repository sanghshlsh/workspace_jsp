package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IDchecker
 */
@WebServlet("/idcheck")
public class IDchecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDchecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String id=request.getParameter("idc");
	//별도의 커맨드 클래스
	System.out.println("ID:"+id);
	System.out.println("별도의 command클래스를 지정하여 실행");
	System.out.println("command클래스 내에서 DAO객체 생성하고 해당 메서드 호출 데이터 반환");
	boolean idCheck=false;
	
	if(!idCheck) {
		
		response.getWriter().print("사용가능한 아이디입니다");
	}else {
		System.out.println("사용 불가능한 아이디입니다");
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
