package com.naver;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		System.out.println("me1 metohd byte stream");
		long start = System.currentTimeMillis();
		t1.me1();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println(":::::::::::::::::::::::::::::");
		System.out.println("me2 method byte[] stream");
		start = System.currentTimeMillis();
		t1.me2();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println(":::::::::::::::::::::::::::::");
		Test t2 = new Test();
		System.out.println("me3 method bufferd stream");
		start = System.currentTimeMillis();
		t2.me3();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(":::::::::::::::::::::::::::::");
		System.out.println("me33 method bufferd byte[] stream");
		start = System.currentTimeMillis();
		t2.me33();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(":::::::::::::::::::::::::::::");
		System.out.println("me4 method bufferd byte[] stream");
		start = System.currentTimeMillis();
		t2.me4();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
	}

}
