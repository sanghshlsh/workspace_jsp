package kr.co.ca;

import java.io.File;

public class MainEx {
	public static void main(String[] args) {
		/*
		 * c://new.txt
		 * c://BBB//new.txt 옮겨라
		 * */
		
		
		
		File f3 = new File("C:", "test119.txt");
		File newName = new File("C:", "new.txt");
		
		f3.renameTo(newName);
		
		
		
		File f4 = new File("C:"+File.separator+"BBB");
		File f5 = new File("C:"+File.separator+"BBB"+File.separator+"new.txt");
		//== new File(f4,"new.txt"); 가독성확보를위해 주석처럼 자주사용한다
		if (!f4.exists()) {
			f4.mkdir();
		}
		
		newName.renameTo(f5);
		//f5.delete();
		
		
		File f2 = new File("C:"+File.separator+"test119.txt");
		
		boolean isDel = f2.delete();		
		if (isDel) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		File f1 = new File("C:"+File.separator+"AAA");
		/*저 경로상의 파일을 가르키는 객체 f1
			확장자가 없으면 폴더
			'//' 파일 구분자 ("C://AAA)
			//를 사용하지 않고 File.separator를 사용하여 리눅스/윈도우 운영체계에 맞는 구분자를 사용 할 수 있다.
		
			exists() 존재유무 확인
			실무에서는 !exists()를 주로 사용한다. 
		*/
		
		if (!f1.exists()) {
			f1.mkdir();//directory 생성
		}else {
			f1.delete();//directory 제거
		}
		
	}
}
