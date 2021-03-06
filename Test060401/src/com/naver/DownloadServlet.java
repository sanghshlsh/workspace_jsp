package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("fileName");
		String orgFileName = request.getParameter("orgFileName");//추가
		String uploadPath = "C:"+File.separator+"upload";
		//c에 업로드한경우는 위와 같지만 실제로는 projct내부 webcontent폴더에 폴더를 만들어서 하므로 아래 코드를 자주 사용함
		//String uploadPath = request.getServletContext().getRealPath("img");
		//webcontent폴더에 만든 img폴더의 절대좌표 추출
		
		
		String filePath = uploadPath+File.separator+fileName;
		File f = new File(filePath);//알아낸 파일경로를 통해 파일객체 생성
		
		InputStream in = null;
		//outputstream은 시스템에서  제공하는 
		try {
			in = new FileInputStream(f);//stream 연결
			String sMimeType = getServletContext().getMimeType(filePath);
			if(sMimeType == null){
				sMimeType = "application/octet-stream";//mimetype이 지정되지 않았을때 그냥 다운로드 받으라는 의미
			}
			response.setContentType(sMimeType);
			//mimetype설정완료
			
			//브라우져 인코딩방식에 맞춰 설정
//			String encoding = new String(fileName.getBytes("utf-8"),"8859_1"); 수업진행 아래는 변경
			String encoding = new String(orgFileName.getBytes("utf-8"),"8859_1");
			//파일네임이 꺠지지 않게 하기위해 8859_1 형태의 인코딩타입으로 변경
			//8859_1 브라우져 기본인코딩형태
			
			response.setHeader("Content-Disposition", "attachment;filename="+encoding);
			//정해져있다. 이대로 사용
			//content-~ 의 이름으로 되어있는 키를 "attach~로 변경
			
		//------------------------------------------다운로드를 위한 환경설정	String smime~response.setheader
			
			ServletOutputStream out = response.getOutputStream();//outstream연결
			//container 가 가지고있는 객체를 out이라는 이름으로 사용 - 우리가 만들어버린 in과는 다르다.
			//이미 사용되고 있던 객체는 clsoe하면 안된다.(계속 사용해야하기떄문)
			byte[] arr =new byte[1024];
			int leng = -1;
			while (true) {
				leng = in.read(arr,0,arr.length);//arr을 읽어오는데 0번쨰부터 arr의 최대 length개만큼
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
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
