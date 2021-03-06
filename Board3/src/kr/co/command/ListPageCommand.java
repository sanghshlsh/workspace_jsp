package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCurPage = request.getParameter("curPage");
		int curPage = 1;
		if (sCurPage != null) {
			curPage = Integer.valueOf(sCurPage);
		}
		
		PageTO to = new BoardDAO().page(curPage);
		//paging데이터가 필요해서 list<BoardDTO> 로는 표현못함
		//때문에 pageTO dto를 만들어 사용하거나 map을사용 전자가 일반적
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList());
		
		
		return new CommandAction(false, "list.jsp");
	}

}
