package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		
		BoardDAO dao = new BoardDAO();
		
	
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		//다중입력
//		for (int i = 0; i < 100; i++) {
//			
//			dao.insert(new BoardDTO(-1, "writer" + i, "title" + i, "content" + i, null, 0, 0, 0, 0));
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} asasas
		return new CommandAction(true, "list.do");
	}

}
