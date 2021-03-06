package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public void me1() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copy_test.jpg");
		// f1이가르키는 파일을 복사하여 f2에 넣기(파일복사) bytestream 구현
		// 장치 2개인 상황

		InputStream in = null;
		OutputStream out = null;
		// finally를 하기위해 변수선언해야ㅐ한다.
		int what = -1;
		// byte형이지만 int 형에 넣어서 보낸다.(전송을위한 변수생성)

		try {
			// stream 생성
			in = new FileInputStream(f1);
			// f1에서 file 정보를 inputstream해올것이기에
			out = new FileOutputStream(f2);
			// stream 생성완료
			// 데이터 전송
			while (true) {
				what = in.read();// 데이터 읽어오기 int형반환 (test.jpg에서 받아온 byte1개)
									// 더이상 받아올 데이터가 없으면 -1 반환

				if (what == -1) {
					break;
				}
				out.write(what);
			}
			// 데이터 전송완료
			System.out.println("파일 복사 종료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//	chain상황이 아니기에 close순서 상관x
//	try-catch를 if문마다 하게되면 너무 길기 때문에 묶어서 한다.-mms의 dao에서도 이이유로 묶어서함 
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	public void me2() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copy_test.jpg");

		InputStream in = null;
		OutputStream out = null;
		// 배열을 이용 복사
		// 이떄는 int형으로 받지않고byte형 그대로 사용
		byte[] arr = new byte[512];

		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);

			while (true) {
				int leng = in.read(arr);

				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			System.out.println("파일복사 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void me3() {
		// bufferd stream (byte[] 유사개념 데이터를 buffer에 집어넣고 넘겨주는 stream)
		File f1 = new File("C:" + File.separator + "show.jpg");
		File f2 = new File("C:", "copy_show.jpg");
		
		InputStream in = null;
		BufferedInputStream bis = null;// 대문자BIS c+s

		OutputStream out = null;
		BufferedOutputStream bos = null;// 대문자BOS c+s

		try {
			//stream 생성
			in = new FileInputStream(f1);//nodestream 장치(f1)와연결
			bis = new BufferedInputStream(in);//filterstream stream(in)과 연결(장치연결불가) - chaining
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			
			int what = -1;
			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// filter stream을 사용하게 되면서 chaining 발생
				// close 순서 지켜야한다. filter stream은 장치에 직접연결 불가
				// node stream에서 가장 멀리 있는 filter stream부터 close
				// 입력 출력 무엇을 먼제 close 할지는 상관없다
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public void me4() {
		
		File f1 = new File("C:","test112.txt");
		File f2 = new File("C:","copy_test112.txt");
		
		InputStream in = null;
		BufferedInputStream bis = null;
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		byte[] arr = new byte[512];
		int leng = -1;
		
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			
			while (true) {
				leng = bis.read(arr);
				if (leng == -1) {
					break;
				}	
				bos.write(arr, 0, leng);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
public void me33() {
		
	File f1 = new File("C:" + File.separator + "show.jpg");
	File f2 = new File("C:", "copy_show.jpg");
		
		InputStream in = null;
		BufferedInputStream bis = null;
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		byte[] arr = new byte[512];
		int leng = -1;
		
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			
			while (true) {
				leng = bis.read(arr);
				if (leng == -1) {
					break;
				}	
				bos.write(arr, 0, leng);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
