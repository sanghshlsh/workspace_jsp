package com.naver;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File uploadFolder = new File("C:"+File.separator+"upload");
		if(!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		//데이터 넘겨받기
		String title = "";//변수선언 null이아닌 ""로 비워넣는다.
		
		
		String fileName="";//업로드한 파일은 그 이름을 그대로 가지고 가지 않고cos.jar가 새로운 이름을 부여해준다.
		String orgFileName="";//업로드 할 파일의 원래이름을 입력받아 기록남기기 위한 변수선언
		
		//객체생성 parameter request/savedirectory:저장폴더 위의 upload폴더지정
		//maxPostSize(최대크기 단위byte)/encoding:인코딩방식
		//파일이름이 중복일 때 숫자를 붙여주기위해 위해 마지막 5번째 parameter로 new DefaultFileRenamePolicy()를 설정
		MultipartRequest multi = 
				new MultipartRequest(request, "C:"+File.separator+"upload", 
									10*1024*1024, "utf-8",
									new DefaultFileRenamePolicy());
		//이곳에서 파일업로드완료
		
		
		//multiparerequest객체를 가지고 데이터를 받아올 수 있다.
		//enc타입변경을하여 request.getparameter로는 불가능 
		title = multi.getParameter("title");
		fileName = multi.getFilesystemName("file");//cos.jar를 거친 filename리턴  첨부파일의 name이 file 
		orgFileName = multi.getOriginalFileName("file");//원래 파일이름리턴
		//데이터 가지고 가는방법은 
		//1.query형태(?id=~식으로 파라미터형 입력)
		//2.request에 바인딩

		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		request.setAttribute("orgFileName", orgFileName);
		
		request.getRequestDispatcher("check.jsp").forward(request, response);
	}

}
