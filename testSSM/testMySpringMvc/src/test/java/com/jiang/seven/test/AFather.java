package com.jiang.seven.test;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class AFather {
	
	public String a = "AF--a";
	
	private String b = "AF--b";
	
	static{
		System.out.println("static .....");
	}
	
	private static void getStaticM(){
		System.out.println("staticM .....");
	}
	
	public AFather(){
		
	}
	
	public void setA(String a) {
		this.a = a;
	}





	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public AFather(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public void getAA(){
		System.out.println(a);
	}
	
	public void getBB() {
		System.out.println(b);
	}
	public static void main(String[] args) {
	
	}
}
