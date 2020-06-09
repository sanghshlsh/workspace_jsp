package com.naver;

public class Test {
	private int c;
	private int d = 100;
	//d = 2; 필드 대입불가
	//me1()  필드 메소드호출 불가
	public Test() {
		int a = 10;
		a = 5;
		System.out.println(a);
	}
	public void me1() {
		System.out.println(c+d);
	}
}
