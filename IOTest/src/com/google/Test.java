package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class Test {

	public void me1() {
		// char stream
		// 잘사용하지 않는 코드
		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copy_test112.txt");

		Reader in = null;
		Writer out = null;
//		Reader reader = null;
//		Writer writer = null;

		try {
			// 스트림생성
			in = new FileReader(f1);
			out = new FileWriter(f2);// boolean파라미터 추가하는것은 추가할것이냐 덮어씌울것이냐

			char[] arr = new char[64];
			int leng = -1;
			while (true) {
//				leng = in.read(arr); 이처럼해도 상관없다.
				leng = in.read(arr, 0, arr.length);
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}

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

	public void me2() {
		// bufferd char stream (node stream filter stream X)

		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copy_test113.txt");

		Reader in = null;
		BufferedReader br = null;
		// BufferedReader는 줄바꿈표시가 있기 전까지 한줄씩 읽어온다. - 문자열
		// 줄바꿈기호누락
		Writer out = null;
		BufferedWriter bw = null;
		// bufferedreader에 비해 bufferedwriter는 잘 사용한한다. BR은 BW가아닌 printwriter와 더 자주사용한다.

		try {
			in = new FileReader(f1);
			br = new BufferedReader(in);
			out = new FileWriter(f2);
			bw = new BufferedWriter(out);

			String msg = "";

			while (true) {
				msg = br.readLine();
				if (msg == null) {
					break;
				}
				bw.write(msg);
				// bw.newLine();//bw의 줄바꿈기호 입력 method
				bw.write(System.getProperty("line.separator"));// 라인구분자=줄바꿈기호 입력
				// System.getProperty("line.separator") 운영체계에 따라 맞춰 라인구분자 String 출력
				// 출력된 라인구분자를 bw.write로 입력 bw가아니라도 사용가능
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
				if (bw != null) {
					bw.close();
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
		// 문자 스트림 사용시 주의사항
		// 입출력 순서 바꿈
		// 바이트 스트림에서는 가능하지만 문자스트림에서는 그냥은 안된다.
		// 문자스트림에서 출력작업 후에는 반드시 flush를 호출해줘야한다.
		// 전단계까지는 입력을 먼저해서 flush를 호출하지 않아도 출력후 close를 바로하게되어 close안에 flush가 있어 상관이 없었다.
		// 앞으로는 문자스트림을 사용할때 항상 출력작업 후에 flush호출할것
		Writer out = null;
		BufferedWriter bw = null;
		Reader in = null;
		BufferedReader br = null;

		try {
			out = new FileWriter("C:" + File.separator + "no.txt");
			bw = new BufferedWriter(out);
			bw.write("hello");
			bw.write(System.getProperty("line.separator"));
			bw.write("World");
			bw.write(System.getProperty("line.separator"));
			bw.write("good");
			bw.write(System.getProperty("line.separator"));

			bw.flush();

			in = new FileReader("C:" + File.separator + "no.txt");
			br = new BufferedReader(in);

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);// print x println o
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (out != null) {
					out.close();
				}
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/////// 노드 스트림 장치연결가능
	////// 꼭그런것은 아니다
	public void me9() {
		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copy_test112_2.txt");

		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(f1));
			bw = new BufferedWriter(new FileWriter(f2));

			while (true) {

				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				bw.write(msg);
				bw.write(System.getProperty("line.separator"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void me4() {
		// 데이터를 입력받아 콘솔에 출력
		// byte+char stream 혼용
		File f1 = new File("C:" + File.separator + "no.txt");

		InputStream in = null;
		InputStreamReader isr = null;// byte stream 과 char stream 을 연결시켜주는 역할
		BufferedReader br = null;

		try {
			in = new FileInputStream(f1);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			// chaining완료

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}
			//이곳에서 f1.renameTo(new File("C:", "nono.txt"));이 안된 이유는
			//스트림이 연결된 상태에서 f1을 변경시키면 stream에 문제가 생겨 실행을 하지 못한것
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		f1.renameTo(new File("C:", "nono.txt"));
	}

}
