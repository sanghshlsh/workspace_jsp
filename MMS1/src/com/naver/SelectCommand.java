package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//selectcommand class에서 하는일
		//1. client가 보내준 데이터 획득 및 가공(string으로 받은 age int형가공)
		//2. dao 객체 생성 및 해당 method 호출
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		//3. jsp에 뿌려줄 데이터 바인딩
		//로그인과 관련된것은 세션에 data를 바인딩 나머지들은 request에 data를 바인딩
		request.setAttribute("list", list);
		//"list"라는이름으로(키) list데이터를(이름) 저장 일반적으로는 키와 이름을 같게저장
		//4. forwarding 작업
		//redirect를 시키면 request에 저장된 데이터는사라지고
		//dispatcher를시키면 request에 저장된 데이터는 남아있다.
		//따라서 dispatcher방식을 사용해야한다.
		RequestDispatcher dis = request.getRequestDispatcher("select.jsp");
		dis.forward(request, response);
		
	}

}
